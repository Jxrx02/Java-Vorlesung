package A_29_XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.*; import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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

    // Liefert das erste Kind-Element von n mit Namen name
    public static Element getNamedChildElement(Node n, String name) {
        return getNamedChildElement(n, name, 0);
    }
    // Liefert das n-te Kind-Element von n mit Namen name, Zählung beginnt bei 0
    public static Element getNamedChildElement(Node n, String name, int count) {
        for (int i = 0; i < n.getChildNodes().getLength(); i++) {
            Node ithChild = n.getChildNodes().item(i);
            if (ithChild.getNodeType() == Node.ELEMENT_NODE &&
                    ithChild.getNodeName().equals(name)) {
                if (count == 0) {
                    return (Element) ithChild;
                }
                count--;
            }
        }
        return null;
    }

    public static void createDomBaum(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = null;
        try {
            parser = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document doc = parser.newDocument();
        Element fib = doc.createElement("Fibonacci_Numbers");
        doc.appendChild(fib);
        int low = 1;
        int high = 1;
        // Erzeugen des DOM-Baumes
        for (int i = 1; i <= 10; i++) {
            Element fibonacci = doc.createElement("fibonacci");
            fibonacci.setAttribute("index", String.valueOf(i));
            fibonacci.setTextContent(String.valueOf(low));
            fib.appendChild(fibonacci);
            int temp = high;
            high += low;
            low = temp;
        }
        // XML-Datei speichern
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            // Speicherort und Dateiname der XML-Datei
            File file = new File("src/A_29_XML/fibonacci.xml");
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);

            System.out.println("XML-Datei erfolgreich erstellt: " + file.getAbsolutePath());
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
