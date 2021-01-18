//package com.example.redisson.service;
//
//import org.redisson.Redisson;
//import org.redisson.api.RTopic;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//import java.io.File;
//import java.io.IOException;
//
//@Service
//public class redisConnectionService {
//    private static final Logger logger = LoggerFactory.getLogger(redisConnectionService.class);
//
////    private static final String SINGLE_NODE_CONFIG_FILE= "/config-file.yaml";
//    private static final String SINGLE_NODE_CONFIG_FILE= "/singleNodeConfig.json";
//
//    public static void redisConnector() {
//        try {
//            System.out.println("redis test start !");
//
////            specify Redisson configurations in an instance of a Config object
////            Config config = new Config();
////            config.useSingleServer()
////                    .setAddress("redis://106.54.194.33:6379");
//
//
////            File Configuration, Redisson can load configurations from external JSON or YAML files
//            String singleNodeConfigPath = redisConnectionService.class.getResource(SINGLE_NODE_CONFIG_FILE).getPath();
////          Config config = Config.fromYAML(new File(singleNodeConfigPath));
//            Config config = Config.fromJSON(new File(singleNodeConfigPath));
//            RedissonClient client = Redisson.create(config);
//
//
////            addListener
//            RTopic subscribeTopic = client.getTopic("REDIS_NOTICE");
//            subscribeTopic.addListener(String.class,
//                (channel, message) -> {
//                    System.out.println("Redisson监听器收到消息:" + message);
//                    logger.info("Logger.info >> Redisson监听器收到消息:{}", message);
//                    String schannel = channel.toString();
//                    System.out.println("Channel toString:" + schannel);
//                });
//
//
////            publishTopic
//            RTopic publishTopic = client.getTopic("REDIS_NOTICE");
//            long clientsReceivedMessage
//                    = publishTopic.publish("This is a message");
//
//            client.shutdown();
//            System.out.println("redis test end !");
//
//        } catch (IOException e) {
//            System.out.println(e);;
//        }
//    }
//
//}
