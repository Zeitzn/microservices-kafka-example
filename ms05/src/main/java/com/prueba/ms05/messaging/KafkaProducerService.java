package com.prueba.ms05.messaging;
import com.ms.commons.model.XmlModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducerService {
    public static final String TOPIC = "xml_topic";

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
