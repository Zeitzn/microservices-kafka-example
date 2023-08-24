package com.prueba.ms05.sheduler;

import com.prueba.ms05.messaging.KafkaProducerService;
import com.prueba.ms05.service.IXmlService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class XmlProcessingScheduler {

    private static final String CRON_VALUE = "0 */1 * * * *";//3 min
    @Autowired
    private IXmlService xmlProcessingService;

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostConstruct
    public void scheduleXmlProcessingTasks() {
        List<String> xmlFileNames = xmlProcessingService.getXmlFileNames();
        xmlFileNames.parallelStream().forEach(xmlFileName -> {
            Runnable task = new XmlProcessorTask(xmlFileName, xmlProcessingService, kafkaProducerService);
            taskScheduler.schedule(task, new CronTrigger(CRON_VALUE));
        });
    }
}