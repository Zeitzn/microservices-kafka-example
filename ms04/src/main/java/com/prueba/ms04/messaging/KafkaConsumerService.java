package com.prueba.ms04.messaging;

import com.ms.commons.model.XmlModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "json_topic", groupId = "group04")
    public void consumerEvent(XmlModel message) {
        log.info("Mensaje recibido -> {}", message);
    }
}
