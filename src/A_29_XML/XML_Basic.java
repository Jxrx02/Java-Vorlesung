package A_29_XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.*; import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class XML_Basic {


    /**
     * Ein leeres Dokument im Speicher erstellen
     */
    void createEmpty(){
        try {
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder parser = factory.newDocumentBuilder();
            String url = "http://example.org/test.xml";
            Document doc = parser.parse(url);
// Ab hier steht der Inhalt als DOM-Baum in "doc" zur Verfügung
// ...
        } catch (ParserConfigurationException | SAXException |
                 IOException | DOMException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Dokument aus einer Datei (mit Pfad filename) lesen:
     */
    void einlesen(File filename){
        /*DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document doc = parser.parse(new File(filename));*/
    }

    /**
     * Document aus URL erzeugen
     */

    void createDocumentFromURL(){
        try {
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();
            String url = "http://maps.googleapis.com/maps/api/geocode/xml?address=karlsruhe";
            Document doc = parser.parse(url);
            // Name des Wurzelelements ausgeben
            System.out.println(doc.getDocumentElement().getNodeName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
