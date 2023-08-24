package com.prueba.ms05.sheduler;

import com.ms.commons.model.XmlModel;
import com.prueba.ms05.service.KafkaProducerService;
import com.prueba.ms05.service.XmlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class XmlScheduler {
    private static final Logger log = LoggerFactory.getLogger(XmlScheduler.class);
    private final XmlService xmlProcessingService;
    private final KafkaProducerService kafkaProducerService;
    public XmlScheduler(XmlService xmlProcessingService, KafkaProducerService kafkaProducerService) {
        this.xmlProcessingService = xmlProcessingService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Scheduled(cron = "*/180 * * * * *")
    public void readXmlFiles() {
        List<String> xmlFileNames = xmlProcessingService.getXmlFileNames();
        xmlFileNames.stream().parallel().forEach(xmlFileName -> {
            try{
                XmlModel xmlData = xmlProcessingService.read(xmlFileName);

                kafkaProducerService.send(xmlData);
            } catch(Exception ex) {
                log.error(xmlFileName + ": " +ex.getMessage());
                ex.getStackTrace();
            }
        });

    }
}
