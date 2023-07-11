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
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
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




        //KML-Dokument erzeugen
        factory = DocumentBuilderFactory.newInstance();
        try {
             parser = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        doc = parser.newDocument();
        Element kml = doc.createElementNS("http://earth.google.com/kml/2.2", "kml");
        Element document = doc.createElement("Document");
        kml.appendChild(document);
        doc.appendChild(kml);
        // Die Placemark-Elemente können nun hier erzeugt und an das Dokument angehängt
        // werden.


        // Erzeugen der Placemark-Elemente für das Raster
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                double pointLat = Double.parseDouble(southwestLat + (row * 100));
                double pointLng = Double.parseDouble(southwestLng + (col * 100));

                Element placemark = doc.createElement("Placemark");

                Element point = doc.createElement("Point");
                placemark.appendChild(point);

                Element coordinates = doc.createElement("coordinates");
                coordinates.appendChild(doc.createTextNode(pointLng + "," + pointLat));
                point.appendChild(coordinates);

                document.appendChild(placemark);
            }
        }

        // Speichern der KML-Datei
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException ex) {
            throw new RuntimeException(ex);
        }
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);

        // Speicherort und Dateiname der KML-Datei
        File file = new File("src/A_29_XML/Exercise_Standort_Gazetter/raster.kml");
        StreamResult result = new StreamResult(file);

        try {
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("KML-Datei erfolgreich erstellt: " + file.getAbsolutePath());
    }



}


