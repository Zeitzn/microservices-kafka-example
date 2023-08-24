package com.prueba.ms05.sheduler;

import com.ms.commons.model.XmlModel;
import com.prueba.ms05.messaging.KafkaProducerService;
import com.prueba.ms05.service.IXmlService;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class XmlProcessorTask implements Runnable{
    private String xmlFileName;
    private IXmlService xmlService;

    private KafkaProducerService kafkaProducerService;

    public XmlProcessorTask(String xmlFileName, IXmlService xmlService, KafkaProducerService kafkaProducerService) {
        this.xmlFileName = xmlFileName;
        this.xmlService = xmlService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Override
    public void run() {
        try {
            log.info("Inicia lectura de {} a las {}", xmlFileName, LocalDateTime.now());
            XmlModel xmlData = xmlService.read(xmlFileName);
            kafkaProducerService.send(xmlData);
        } catch (Exception ex) {
            log.error("{}:{}", xmlFileName, ex.getMessage());
            ex.getStackTrace();
        }
    }
}
