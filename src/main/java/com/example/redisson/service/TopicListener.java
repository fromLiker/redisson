package com.example.redisson.service;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicListener {
    private static final Logger logger = LoggerFactory.getLogger(TopicListener.class);

    @Autowired
    private RedisConnector redisConnector;

    public void redisTopicListener(RedissonClient client) {
        RTopic subscribeTopic = client.getTopic("REDIS_NOTICE");
        subscribeTopic.addListener(String.class,
                (channel, message) -> {
                    logger.info("Redisson监听器收到消息 >> {}", message);
                    String SChannel = channel.toString();
                    logger.info("Channel >> {}", SChannel);
                });
    }
}