package com.prueba.ms05.sheduler;

import com.ms.commons.model.XmlModel;
import com.prueba.ms05.messaging.KafkaProducerService;
import com.prueba.ms05.service.IXmlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class XmlScheduler {
    private final IXmlService xmlProcessingService;
    private final KafkaProducerService kafkaProducerService;
    public XmlScheduler(IXmlService xmlProcessingService, KafkaProducerService kafkaProducerService) {
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
                log.error("{}:{}", xmlFileName, ex.getMessage());
                ex.getStackTrace();
            }
        });

    }
}
