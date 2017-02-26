
package eu.doppel_helix.dev.pdfgenerationtest.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataList {
    @XmlElement
    private List<DataEntry> entries = new ArrayList<>();

    public List<DataEntry> getEntries() {
        return entries;
    }
}
