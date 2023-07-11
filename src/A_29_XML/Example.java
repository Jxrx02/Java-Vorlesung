package A_29_XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        // Erzeugen eines Dokuments anhand der Datei party.xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = null;
        try {
            parser = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document doc = null;
        try {
            doc = parser.parse("https://www.iai.kit.edu/javavl/data/static/party.xml");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Lesen des Wurzelelements des DOM-Dokuments doc
        org.w3c.dom.Element party = doc.getDocumentElement();
        // Den ersten Gast auf der Party holen:
        org.w3c.dom.Node albert = party.getElementsByTagName("gast").item(0);
        //Gast als Element
        Element albertAsElement = (Element) party.getElementsByTagName("gast").item(0);
// Wenn wir eine Gästeliste der Party haben wollen:
// getElementsByTagName nur für Knoten vom Typ Element
        NodeList gaeste = party.getElementsByTagName("gast");
        for (int i = 0; i < gaeste.getLength(); i++) {
            System.out.println( gaeste.item(i).getAttributes()
                    .getNamedItem("name").getNodeValue());
        }

        // Wenn wir wissen wollen, was Albert trinkt:
        Node getraenk = null;
        for (int i = 0; i < albert.getChildNodes().getLength(); i++) {
            if (albert.getChildNodes().item(i).getNodeName().equals("getraenk")) {
                getraenk = albert.getChildNodes().item(i);
                System.out.println(getraenk.getTextContent());
            }
        }
        addGetränk(doc);

        //remove getränk
        Node wine = null;
        for (int i = 0; i < albert.getChildNodes().getLength(); i++) {
            Node ithChild = albert.getChildNodes().item(i);
            if (ithChild.getNodeName().equals("getraenk")) {
                if (ithChild.getTextContent().equals("Wein")) {
                    wine = ithChild;
                }
            }
        }
        if (wine != null){
            albert.removeChild(wine);
        }

        //Lesen des Name-Attributs von Albert:
        party = doc.getDocumentElement();
        albert = party.getElementsByTagName("gast").item(0);
        System.out.println(albert.getAttributes().getNamedItem("name").getNodeValue());

        //Checke Ledig
        Node state = null;
        for (int i = 0; i < albert.getChildNodes().getLength(); i++) {
            if (albert.getChildNodes().item(i).getNodeName().equals("zustand")) {
                state = albert.getChildNodes().item(i);
            }
        }
        if (state != null) {
                // Attr. lesen
            String val = state.getAttributes().getNamedItem("ledig").getNodeValue();
            if ( "true".equals(val) ) {
                // Attr. setzen: entsprechend bei Martina!
                state.getAttributes().getNamedItem("ledig").setNodeValue("false");
            }
        }


        createDomBaum();

    }

    public static void addGetränk(Document doc){
        Element party = doc.getDocumentElement();
        Node albert = party.getElementsByTagName("gast").item(0);
        Node water = doc.createElement("getraenk");
        water.setTextContent("Wasser");
        albert.appendChild(water);
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
