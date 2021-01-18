package com.example.redisson.service;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RedisConnector {
    private static final Logger logger = LoggerFactory.getLogger(RedisConnector.class);

    private static final String SINGLE_NODE_CONFIG_FILE= "/singleNodeConfig.json";

    public static RedissonClient singleNodeRedisConnector() {
        Config config = new Config();
        try {
            String singleNodeConfigPath = RedisConnector.class.getResource(SINGLE_NODE_CONFIG_FILE).getPath();
            config = Config.fromJSON(new File(singleNodeConfigPath));
        } catch (IOException e) {
            System.out.println(e);
        }
        RedissonClient client = Redisson.create(config);
        logger.info("Redisson client created !");
        return client;
    }
}
