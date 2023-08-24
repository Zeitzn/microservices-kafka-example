package com.prueba.ms01.messaging;

import com.ms.commons.model.XmlModel;
import com.prueba.ms01.entity.PersonEntity;
import com.prueba.ms01.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    private final IPersonService personService;

    public KafkaConsumerService(IPersonService personService) {
        this.personService = personService;
    }

    @KafkaListener(topics = "xml_topic", groupId = "group01")
    public void consumerEvent(XmlModel message) {
        log.info("Datos recibidos -> {}", message);
        PersonEntity person = PersonEntity.fromModel(message);
        personService.save(person);
    }
}
