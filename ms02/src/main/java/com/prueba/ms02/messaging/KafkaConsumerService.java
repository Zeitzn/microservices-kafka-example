package com.prueba.ms02.messaging;

import com.ms.commons.model.XmlModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    private final KafkaProducerService producerService;

    public KafkaConsumerService(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @KafkaListener(topics = "xml_topic", groupId = "group02")
    public void consumerEvent(XmlModel message) {
        log.info("Mensaje recibido -> {}", message);
        producerService.send(message);
    }
}
