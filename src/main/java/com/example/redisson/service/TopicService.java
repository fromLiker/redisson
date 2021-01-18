package com.example.redisson.service;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    private static final Logger logger = LoggerFactory.getLogger(TopicService.class);

    @Autowired
    private RedisConnector redisConnector;

    public void publishTopic(RedissonClient client) {
        RTopic publishTopic = client.getTopic("REDIS_NOTICE");
        String topicMessage = "This is a message !!";
        long clientsReceivedMessage
                = publishTopic.publish(topicMessage);
        logger.info("publishTopic >> {}", topicMessage);
        String SClientsReceivedMessage = Long.toString(clientsReceivedMessage);
        logger.info("clientsReceivedMessage return >> {}", SClientsReceivedMessage);
    }
}