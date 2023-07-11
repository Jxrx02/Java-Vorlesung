package A_29_XML.Exercise_Standort_Gazetter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;


public class Gazetter {

    /**
     * Lesen Sie den Namen (formatted_address, long_name des address_componentElements mit type="locality") und die Lage (location und bounds) aus und geben Sie
     * diese auf der Konsole aus. bounds liefert die Begrenzungspunkte im Südwesten und Nordosten, die
     * ein passendes Rechteck aufspannen, z.B. um die Kartenansicht auf diesen Bereich zu zoomen.
     */

    public static void main(String[] args) {
        String url= "https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml";
/*
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = null;
        try {
            parser = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document doc = null;
        try {
            doc = parser.parse(url);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Status auslesen
        Node status = wurzel.getElementsByTagName("status").item(0);
        System.out.println("Status: " + status.getTextContent());
        */


        // XML-Parser initialisieren
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = null;
        try {
            parser = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document doc = null;
        try {
            doc = parser.parse(url);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Lesen des Wurzelelements des DOM-Dokuments doc
        Element root = doc.getDocumentElement();

        // Name und Lage auslesen
        // Hole alle address_components
        NodeList addressComponents = root.getElementsByTagName("address_component");
        for (int i = 0; i < addressComponents.getLength(); i++) {
            Element addressComponent = (Element) addressComponents.item(i);
            //System.out.println(addressComponent.getTextContent());

            //Hole alle types_components
            NodeList types = addressComponent.getElementsByTagName("type");

            for (int j = 0; j < types.getLength(); j++) {
                //address_component -> type
                Element type = (Element) types.item(j);
                //value of type
                String typeValue = type.getTextContent();

                //Hole Formatted Address und Long Name
                if (typeValue.equals("locality")) {
                    String formattedAddress = root.getElementsByTagName("formatted_address")
                            .item(0).getTextContent();

                    String longName = addressComponent.getElementsByTagName("long_name")
                            .item(0).getTextContent();

                    System.out.println("Formatted Address: " + formattedAddress);
                    System.out.println("Long Name: " + longName);
                }
            }
        }
        //Latitude, Longitude herauslesen
        Element location = (Element) root.getElementsByTagName("location").item(0);
        String latitude = location.getElementsByTagName("lat").item(0).getTextContent();
        String longitude = location.getElementsByTagName("lng").item(0).getTextContent();
        System.out.println("Location - Latitude: " + latitude + ", Longitude: " + longitude);

        //Bounds parents
        Element bounds = (Element) root.getElementsByTagName("bounds").item(0);
        Element southwest = (Element) bounds.getElementsByTagName("southwest").item(0);
        Element northeast = (Element) bounds.getElementsByTagName("northeast").item(0);

        //Bounds child
        String southwestLat = southwest.getElementsByTagName("lat").item(0).getTextContent();
        String southwestLng = southwest.getElementsByTagName("lng").item(0).getTextContent();
        String northeastLat = northeast.getElementsByTagName("lat").item(0).getTextContent();
        String northeastLng = northeast.getElementsByTagName("lng").item(0).getTextContent();
        System.out.println("Bounds - Southwest: (" + southwestLat + ", " + southwestLng + ")");
        System.out.println("Bounds - Northeast: (" + northeastLat + ", " + northeastLng + ")");
    }
}


