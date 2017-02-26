
package eu.doppel_helix.dev.pdfgenerationtest.persistence;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataEntry {
    private String firmaName1;
    private String firmaName2;
    private String firmaStrasse;
    private String firmaHausnummer;
    private String firmaPLZ;
    private String firmaOrt;
    private int firmaBetriebsnummer;
    
    private String maAnrede;
    private String maVorname;
    private String maNachname;
    private String maStrasse;
    private String maHausnummer;
    private String maPLZ;
    private String maOrt;
    private String maPersonalnummer;
    private String maVersicherungsnummer;
    
    private Date zeitraumVon;
    private Date zeitraumBis;
    
    private Date uebermitteltAm;
    private String grundDerAbgabeCode;
    private boolean stornierung;
    
    private int einzugsstelleBetriebsnummer;
    private String einzugsstelleName;
    
    private String beitragsgruppeKVCode;
    private String beitragsgruppeKVName;
    private String beitragsgruppeRVCode;
    private String beitragsgruppeRVName;
    private String beitragsgruppeAVCode;
    private String beitragsgruppeAVName;
    private String beitragsgruppePVCode;
    private String beitragsgruppePVName;
    
    private String personengruppenschluesselCode;
    private String personengruppenschluesselName;
    
    private String staatsangehoerigkeitCode;
    private String staatsangehoerigkeitName;
    
    private String rechtskreisCode;
    private String rechtskreisName;
    
    private String mehrfachbeschaeftigterCode;
    private String mehrfachbeschaeftigterName;
    
    private String gleitzoneCode;
    private String gleitzoneName;
    
    private String taetigkeitsschluesselCode;
    
    private BigDecimal entgeltInEuro;

    public String getFirmaName1() {
        return firmaName1;
    }

    public void setFirmaName1(String firmaName1) {
        this.firmaName1 = firmaName1;
    }

    public String getFirmaName2() {
        return firmaName2;
    }

    public void setFirmaName2(String firmaName2) {
        this.firmaName2 = firmaName2;
    }

    public String getFirmaStrasse() {
        return firmaStrasse;
    }

    public void setFirmaStrasse(String firmaStrasse) {
        this.firmaStrasse = firmaStrasse;
    }

    public String getFirmaHausnummer() {
        return firmaHausnummer;
    }

    public void setFirmaHausnummer(String firmaHausnummer) {
        this.firmaHausnummer = firmaHausnummer;
    }

    public String getFirmaPLZ() {
        return firmaPLZ;
    }

    public void setFirmaPLZ(String firmaPLZ) {
        this.firmaPLZ = firmaPLZ;
    }

    public String getFirmaOrt() {
        return firmaOrt;
    }

    public void setFirmaOrt(String firmaOrt) {
        this.firmaOrt = firmaOrt;
    }

    public int getFirmaBetriebsnummer() {
        return firmaBetriebsnummer;
    }

    public void setFirmaBetriebsnummer(int firmaBetriebsnummer) {
        this.firmaBetriebsnummer = firmaBetriebsnummer;
    }

    public String getMaAnrede() {
        return maAnrede;
    }

    public void setMaAnrede(String maAnrede) {
        this.maAnrede = maAnrede;
    }

    public String getMaVorname() {
        return maVorname;
    }

    public void setMaVorname(String maVorname) {
        this.maVorname = maVorname;
    }

    public String getMaNachname() {
        return maNachname;
    }

    public void setMaNachname(String maNachname) {
        this.maNachname = maNachname;
    }

    public String getMaStrasse() {
        return maStrasse;
    }

    public void setMaStrasse(String maStrasse) {
        this.maStrasse = maStrasse;
    }

    public String getMaHausnummer() {
        return maHausnummer;
    }

    public void setMaHausnummer(String maHausnummer) {
        this.maHausnummer = maHausnummer;
    }

    public String getMaPLZ() {
        return maPLZ;
    }

    public void setMaPLZ(String maPLZ) {
        this.maPLZ = maPLZ;
    }

    public String getMaOrt() {
        return maOrt;
    }

    public void setMaOrt(String maOrt) {
        this.maOrt = maOrt;
    }

    public String getMaPersonalnummer() {
        return maPersonalnummer;
    }

    public void setMaPersonalnummer(String maPersonalnummer) {
        this.maPersonalnummer = maPersonalnummer;
    }

    public String getMaVersicherungsnummer() {
        return maVersicherungsnummer;
    }

    public void setMaVersicherungsnummer(String maVersicherungsnummer) {
        this.maVersicherungsnummer = maVersicherungsnummer;
    }

    public Date getZeitraumVon() {
        return zeitraumVon;
    }

    public void setZeitraumVon(Date zeitraumVon) {
        this.zeitraumVon = zeitraumVon;
    }

    public Date getZeitraumBis() {
        return zeitraumBis;
    }

    public void setZeitraumBis(Date zeitraumBis) {
        this.zeitraumBis = zeitraumBis;
    }

    public Date getUebermitteltAm() {
        return uebermitteltAm;
    }

    public void setUebermitteltAm(Date uebermitteltAm) {
        this.uebermitteltAm = uebermitteltAm;
    }

    public String getGrundDerAbgabeCode() {
        return grundDerAbgabeCode;
    }

    public void setGrundDerAbgabeCode(String grundDerAbgabeCode) {
        this.grundDerAbgabeCode = grundDerAbgabeCode;
    }

    public boolean isStornierung() {
        return stornierung;
    }

    public void setStornierung(boolean stornierung) {
        this.stornierung = stornierung;
    }

    public int getEinzugsstelleBetriebsnummer() {
        return einzugsstelleBetriebsnummer;
    }

    public void setEinzugsstelleBetriebsnummer(int einzugsstelleBetriebsnummer) {
        this.einzugsstelleBetriebsnummer = einzugsstelleBetriebsnummer;
    }

    public String getEinzugsstelleName() {
        return einzugsstelleName;
    }

    public void setEinzugsstelleName(String einzugsstelleName) {
        this.einzugsstelleName = einzugsstelleName;
    }

    public String getBeitragsgruppeKVCode() {
        return beitragsgruppeKVCode;
    }

    public void setBeitragsgruppeKVCode(String beitragsgruppeKVCode) {
        this.beitragsgruppeKVCode = beitragsgruppeKVCode;
    }

    public String getBeitragsgruppeKVName() {
        return beitragsgruppeKVName;
    }

    public void setBeitragsgruppeKVName(String beitragsgruppeKVName) {
        this.beitragsgruppeKVName = beitragsgruppeKVName;
    }

    public String getBeitragsgruppeRVCode() {
        return beitragsgruppeRVCode;
    }

    public void setBeitragsgruppeRVCode(String beitragsgruppeRVCode) {
        this.beitragsgruppeRVCode = beitragsgruppeRVCode;
    }

    public String getBeitragsgruppeRVName() {
        return beitragsgruppeRVName;
    }

    public void setBeitragsgruppeRVName(String beitragsgruppeRVName) {
        this.beitragsgruppeRVName = beitragsgruppeRVName;
    }

    public String getBeitragsgruppeAVCode() {
        return beitragsgruppeAVCode;
    }

    public void setBeitragsgruppeAVCode(String beitragsgruppeAVCode) {
        this.beitragsgruppeAVCode = beitragsgruppeAVCode;
    }

    public String getBeitragsgruppeAVName() {
        return beitragsgruppeAVName;
    }

    public void setBeitragsgruppeAVName(String beitragsgruppeAVName) {
        this.beitragsgruppeAVName = beitragsgruppeAVName;
    }

    public String getBeitragsgruppePVCode() {
        return beitragsgruppePVCode;
    }

    public void setBeitragsgruppePVCode(String beitragsgruppePVCode) {
        this.beitragsgruppePVCode = beitragsgruppePVCode;
    }

    public String getBeitragsgruppePVName() {
        return beitragsgruppePVName;
    }

    public void setBeitragsgruppePVName(String beitragsgruppePVName) {
        this.beitragsgruppePVName = beitragsgruppePVName;
    }

    public String getPersonengruppenschluesselCode() {
        return personengruppenschluesselCode;
    }

    public void setPersonengruppenschluesselCode(String personengruppenschluesselCode) {
        this.personengruppenschluesselCode = personengruppenschluesselCode;
    }

    public String getPersonengruppenschluesselName() {
        return personengruppenschluesselName;
    }

    public void setPersonengruppenschluesselName(String personengruppenschluesselName) {
        this.personengruppenschluesselName = personengruppenschluesselName;
    }

    public String getStaatsangehoerigkeitCode() {
        return staatsangehoerigkeitCode;
    }

    public void setStaatsangehoerigkeitCode(String staatsangehoerigkeitCode) {
        this.staatsangehoerigkeitCode = staatsangehoerigkeitCode;
    }

    public String getStaatsangehoerigkeitName() {
        return staatsangehoerigkeitName;
    }

    public void setStaatsangehoerigkeitName(String staatsangehoerigkeitName) {
        this.staatsangehoerigkeitName = staatsangehoerigkeitName;
    }

    public String getRechtskreisCode() {
        return rechtskreisCode;
    }

    public void setRechtskreisCode(String rechtskreisCode) {
        this.rechtskreisCode = rechtskreisCode;
    }

    public String getRechtskreisName() {
        return rechtskreisName;
    }

    public void setRechtskreisName(String rechtskreisName) {
        this.rechtskreisName = rechtskreisName;
    }

    public String getMehrfachbeschaeftigterCode() {
        return mehrfachbeschaeftigterCode;
    }

    public void setMehrfachbeschaeftigterCode(String mehrfachbeschaeftigterCode) {
        this.mehrfachbeschaeftigterCode = mehrfachbeschaeftigterCode;
    }

    public String getMehrfachbeschaeftigterName() {
        return mehrfachbeschaeftigterName;
    }

    public void setMehrfachbeschaeftigterName(String mehrfachbeschaeftigterName) {
        this.mehrfachbeschaeftigterName = mehrfachbeschaeftigterName;
    }

    public String getGleitzoneCode() {
        return gleitzoneCode;
    }

    public void setGleitzoneCode(String gleitzoneCode) {
        this.gleitzoneCode = gleitzoneCode;
    }

    public String getGleitzoneName() {
        return gleitzoneName;
    }

    public void setGleitzoneName(String gleitzoneName) {
        this.gleitzoneName = gleitzoneName;
    }

    public String getTaetigkeitsschluesselCode() {
        return taetigkeitsschluesselCode;
    }

    public void setTaetigkeitsschluesselCode(String taetigkeitsschluesselCode) {
        this.taetigkeitsschluesselCode = taetigkeitsschluesselCode;
    }

    public BigDecimal getEntgeltInEuro() {
        return entgeltInEuro;
    }

    public void setEntgeltInEuro(BigDecimal entgeltInEuro) {
        this.entgeltInEuro = entgeltInEuro;
    }
    
    
}
