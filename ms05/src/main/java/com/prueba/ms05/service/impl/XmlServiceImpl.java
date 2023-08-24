package com.prueba.ms05.service.impl;

import com.ms.commons.model.XmlModel;
import com.prueba.ms05.service.IXmlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class XmlServiceImpl implements IXmlService {
    private static final String BASE_XML = "https://todoprogramacion.dev/prueba-xml/";

    private static final Integer NUMBER_OF_FILES = 5000;

    @Override
    public List<String> getXmlFileNames() {
        return IntStream.range(0, NUMBER_OF_FILES)
                .mapToObj(i -> "myXMLFile" + i + ".xml")
                .toList();
    }

    @Override
    public XmlModel read(String xmlFileName) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL(BASE_XML + xmlFileName);
        InputStream inputStream = url.openStream();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        XmlModel xmlData = parseXml(document.getDocumentElement());
        xmlData.setFileName(xmlFileName);
        return xmlData;
    }
    private static XmlModel parseXml(Element root) {
        XmlModel.XmlModelBuilder xmlDataBuilder = XmlModel.builder();
        Element personElement = (Element) root.getElementsByTagName("person").item(0);
        String firstname2 = personElement.getAttribute("firstname2");
        xmlDataBuilder.firstName(personElement.getAttribute("firstname"));
        xmlDataBuilder.lastName(personElement.getAttribute("lastname"));
        xmlDataBuilder.city(personElement.getAttribute("city"));
        xmlDataBuilder.country(personElement.getAttribute("country"));
        xmlDataBuilder.firstName2(firstname2);
        xmlDataBuilder.lastName2(personElement.getAttribute("lastname2"));
        xmlDataBuilder.email(personElement.getAttribute("email"));

        Element daciaElement = (Element) root.getElementsByTagName(firstname2).item(0);
        xmlDataBuilder.age(Integer.parseInt(daciaElement.getElementsByTagName("age").item(0).getTextContent()));

        xmlDataBuilder.random(Integer.parseInt(root.getElementsByTagName("random").item(0).getTextContent()));
        xmlDataBuilder.randomFloat(Float.parseFloat(root.getElementsByTagName("random_float").item(0).getTextContent()));
        xmlDataBuilder.bool(Boolean.parseBoolean(root.getElementsByTagName("bool").item(0).getTextContent()));
        xmlDataBuilder.date(root.getElementsByTagName("date").item(0).getTextContent());
        xmlDataBuilder.regEx(root.getElementsByTagName("regEx").item(0).getTextContent());
        xmlDataBuilder.enumValue(root.getElementsByTagName("enum").item(0).getTextContent());


        NodeList eltList = root.getElementsByTagName("elt");
        List<String> elts = new ArrayList<>();
        for (int i = 0; i < eltList.getLength(); i++) {
            elts.add(eltList.item(i).getTextContent());
        }
        xmlDataBuilder.eltList(elts);

        return xmlDataBuilder.build();
    }
}
