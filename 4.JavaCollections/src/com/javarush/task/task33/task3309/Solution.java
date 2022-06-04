package com.javarush.task.task33.task3309;

import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import org.w3c.dom.*;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Комментарий внутри xml
*/

public class Solution {
    private static final String CDATA = "CDATA";

    public static String toXmlWithComment(Object obj, String tagName, String comment) {

        Document document = createNewDocument();
        marshalToXml(obj, document);

        NodeList matchedElementsList = document.getElementsByTagName(tagName);
            for (int i = 0; i < matchedElementsList.getLength(); i++) {
                Node node = matchedElementsList.item(i);
                node.getParentNode().insertBefore(document.createComment(comment), node);
                node.getParentNode().insertBefore(document.createTextNode("\n"), node);
        }

        return toString(document);
    }

    /**
     * Create new Document using builder
     * @return - new Document
     */
    private static Document createNewDocument() {
        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try {
            // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
            builder = dbf.newDocumentBuilder();
            // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
            Document document = builder.newDocument();
            return document;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Marshalint obj into Document
     * @param obj
     * @param document
     */
    private static void marshalToXml(Object obj, Document document) {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, document);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    /**
     * Convert Document format to String format
     * @param doc - Document type
     * @return - String type
     */
    private static String toString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();

        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }

    public static void main(String[] args) {

    }
}
