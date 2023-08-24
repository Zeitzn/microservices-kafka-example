package com.prueba.ms05.service;

import com.prueba.ms05.model.XmlData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);

    public static final String TOPIC = "xml_topic";

    private final KafkaTemplate<String, XmlData> kafkaTemplate;

    KafkaProducerService(KafkaTemplate<String, XmlData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void send(XmlData message){
        try{
            kafkaTemplate.send(TOPIC, message.getFileName(), message);
            log.info("Payload enviado: {}", message);
        } catch(Exception e) {
            e.getStackTrace();
        }
    }
}
