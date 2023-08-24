package com.prueba.ms02.service;
import com.ms.commons.model.XmlModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);

    public static final String TOPIC = "json_topic";

    private final KafkaTemplate<String, XmlModel> kafkaTemplate;

    KafkaProducerService(KafkaTemplate<String, XmlModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(XmlModel message){
        try{
            kafkaTemplate.send(TOPIC, message.getFileName(), message);
            log.info("Payload enviado: {}", message);
        } catch(Exception e) {
            e.getStackTrace();
        }
    }
}
