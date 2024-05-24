package com.cons.consuming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    private final Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "Demo-1", groupId = "jt-group-1")
    public void consumePartition0(String message) {
        logger.info("Consumer for Partition 0 consumed the message: {}", message);
    }

    @KafkaListener(topics = "Demo-1", groupId = "jt-group-1")
    public void consumePartition1(String message) {
        logger.info("Consumer for Partition 1 consumed the message: {}", message);
    }

    @KafkaListener(topics = "Demo-1", groupId = "jt-group-1")
    public void consumePartition2(String message) {
        logger.info("Consumer for Partition 2 consumed the message: {}", message);
    }

    @KafkaListener(topics = "Demo-1", groupId = "jt-group-1")
    public void consumePartition3(String message) {
        logger.info("Consumer for Partition 3 consumed the message: {}", message);
    }
}
