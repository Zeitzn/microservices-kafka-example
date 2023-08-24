package com.prueba.ms05.service;

import com.ms.commons.model.XmlModel;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface IXmlService {
    List<String> getXmlFileNames();
    XmlModel read(String xmlFileName) throws IOException, ParserConfigurationException, SAXException;
}
