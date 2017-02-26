package eu.doppel_helix.dev.pdfgenerationtest;

import eu.doppel_helix.dev.pdfgenerationtest.persistence.DataList;
import eu.doppel_helix.dev.pdfgenerationtest.persistence.DataEntry;
import com.lowagie.text.DocumentException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.apache.pdfbox.multipdf.PageExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        try {
            main.setEntryCount(Integer.parseInt(args[0]));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {}
        main.run();
    }

    private static final Configuration config;
    private static final Template deuevtemplate;
    private static final JAXBContext jaxbCtx;

    static {
        try {
            config = new Configuration(Configuration.VERSION_2_3_25);
            config.setLocale(Locale.GERMANY);
            config.setClassForTemplateLoading(Main.class, "");
            deuevtemplate = config.getTemplate("Deuevmeldung.html.ftl");
            jaxbCtx = JAXBContext.newInstance(DataList.class, DataEntry.class);
        } catch (IOException | JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

    private final File outputdir;
    private int entryCount = 100;

    private Main() throws IOException {
        this.outputdir = new File(System.getProperty("java.io.tmpdir"), "PDFGeneration");
        if (this.outputdir.exists()) {
            Files.walk(this.outputdir.toPath()).forEach(p -> p.toFile().delete());
        }
        this.outputdir.mkdirs();
    }

    public int getEntryCount() {
        return entryCount;
    }

    public void setEntryCount(int entryCount) {
        this.entryCount = entryCount;
    }
    
    private String processDEUEV(DataEntry de) {
        try {
            StringWriter sw = new StringWriter(2048);
            deuevtemplate.process(Collections.singletonMap("data", de), sw);
            return sw.toString();
        } catch (TemplateException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void run() throws IOException {
        System.out.println("Outputdir: " + outputdir.getAbsolutePath());
        System.out.println("Test-Size: " + entryCount);

        long start = System.currentTimeMillis();
        
        generateTestData();

        long endGenerateTestData = System.currentTimeMillis();

        renderBigPDF();
        
        long endGenerateBigPDF = System.currentTimeMillis();
        
        splitBigPDF();
        
        long endSplitBigPDF = System.currentTimeMillis();
        
        System.out.println(String.format(Locale.GERMANY, "%1$-40s: %2$,6d ms", "Generate Testdata", (endGenerateTestData - start)));
        System.out.println(String.format(Locale.GERMANY, "%1$-40s: %2$,6d ms", "Generate Big-PDF", (endGenerateBigPDF - endGenerateTestData)));
        System.out.println(String.format(Locale.GERMANY, "%1$-40s: %2$,6d ms", "Split Big-PDF", (endSplitBigPDF - endGenerateBigPDF)));
        System.out.println("=======================================================================");
        System.out.println(String.format(Locale.GERMANY, "%1$-40s: %2$,6d ms", "Total runtime", (endGenerateBigPDF - start)));
    }
    
    private void splitBigPDF() throws IOException {
        File splittedDir = new File(this.outputdir, "splitted");
        splittedDir.mkdirs();
        try(PDDocument inputdocument = PDDocument.load(new File(this.outputdir, "demodata.pdf"))) {
            PageExtractor pe = new PageExtractor(inputdocument);
            int pageCount = inputdocument.getNumberOfPages();
            for(int i = 1; i <= pageCount; i++) {
                pe.setStartPage(i);
                pe.setEndPage(i);
               try(PDDocument resultDocument = pe.extract()) {
                    resultDocument.save(new File(splittedDir, i + ".pdf"));
               }
            }
        }
    }

    private void renderBigPDF() throws IOException {
        DataList dl;
        try (FileInputStream fis = new FileInputStream(new File(this.outputdir, "demodata.xml"))) {
            try {
                dl = (DataList) jaxbCtx.createUnmarshaller().unmarshal(fis);
            } catch (JAXBException ex) {
                throw new IOException(ex);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(new File(this.outputdir, "demodata.pdf"))) {
            ITextRenderer renderer = new ITextRenderer();
            for(int i = 0; i < dl.getEntries().size(); i++) {
                renderer.setDocumentFromString(processDEUEV(dl.getEntries().get(i)));
                renderer.layout();
                if(i == 0) {
                    renderer.createPDF(fos, false);
                } else {
                    renderer.writeNextDocument();
                }
            }
            renderer.finishPDF();
        } catch (DocumentException ex) {
            throw new IOException(ex);
        }
    }

    private void generateTestData() throws IOException {
        DataList dl = new DataList();
        for (int i = 0; i < entryCount; i++) {
            DataEntry de = generateSample(i);
            dl.getEntries().add(de);
        }
        try (FileOutputStream fos = new FileOutputStream(new File(this.outputdir, "demodata.xml"))) {
            try {
                jaxbCtx.createMarshaller().marshal(dl, fos);
            } catch (JAXBException ex) {
                throw new IOException(ex);
            }
        }
    }

    private DataEntry generateSample(int count) {
        DataEntry de = new DataEntry();
        de.setFirmaName1("Musterfirma");
        de.setFirmaName2("AG & Co. KG");
        de.setFirmaStrasse("Musterstraße");
        de.setFirmaHausnummer("23a");
        de.setFirmaPLZ("12345");
        de.setFirmaOrt("Musterhausen");
        de.setFirmaBetriebsnummer(12345678);
        if (count % 2 == 0) {
            de.setMaAnrede("Herrn");
            de.setMaVorname("Max");
            de.setMaNachname("Mustermann (" + count + ")");
        } else {
            de.setMaAnrede("Frau");
            de.setMaVorname("Maxine");
            de.setMaNachname("Musterfrau (" + count + ")");
        }
        de.setMaStrasse("Codename T Straße");
        de.setMaHausnummer("42");
        de.setMaPLZ("56789");
        de.setMaOrt("Racoon City");
        de.setMaPersonalnummer(Integer.toString(90000000 + count));
        de.setMaVersicherungsnummer("12345678B012");
        de.setUebermitteltAm(new GregorianCalendar(2017, Calendar.FEBRUARY, 3).getTime());
        de.setZeitraumVon(new GregorianCalendar(2016, Calendar.JANUARY, 1).getTime());
        de.setZeitraumBis(new GregorianCalendar(2016, Calendar.DECEMBER, 31).getTime());
        de.setGrundDerAbgabeCode("50");
        de.setStornierung(false);
        de.setEinzugsstelleBetriebsnummer(87654321);
        de.setEinzugsstelleName("KKK");
        de.setBeitragsgruppeKVCode("1");
        de.setBeitragsgruppeKVName("allgemeiner Beitrag");
        de.setBeitragsgruppeRVCode("1");
        de.setBeitragsgruppeRVName("voller Beitrag");
        de.setBeitragsgruppeAVCode("1");
        de.setBeitragsgruppeAVName("voller Beitrag");
        de.setBeitragsgruppePVCode("1");
        de.setBeitragsgruppePVName("voller Beitrag");
        de.setPersonengruppenschluesselCode("101");
        de.setPersonengruppenschluesselName("SV-Pflichtige");
        de.setStaatsangehoerigkeitCode("000");
        de.setStaatsangehoerigkeitName("deutsch");
        de.setRechtskreisCode("W");
        de.setRechtskreisName("altes Bundesland");
        de.setMehrfachbeschaeftigterCode("N");
        de.setMehrfachbeschaeftigterName("kein Mehrfachbeschäftigter");
        de.setGleitzoneCode("0");
        de.setGleitzoneName("keine Gleitzone");
        de.setTaetigkeitsschluesselCode("123456789");
        de.setEntgeltInEuro(new BigDecimal("23456.78"));
        return de;
    }
}
