package com.example.redisson;

//import com.example.redisson.service.redisConnectionService;
import com.example.redisson.service.RedisConnector;
import com.example.redisson.service.TopicListener;
import com.example.redisson.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedissonApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void testHello() {
		System.out.println("Hello Testcase !");
	}

//	@Test
//	public void redisTest() {
//		redisConnectionService.redisConnector();
//	}

	@Autowired
	RedisConnector redisConnector;
	@Autowired
	TopicListener topicListener;
	@Autowired
	TopicService topicService;
	@Test
	public void redisConnectTestcase(){
		System.out.println("redis connect test start !");
		RedissonClient client = redisConnector.singleNodeRedisConnector();
		topicListener.redisTopicListener(client);
		topicService.publishTopic(client);
		client.shutdown();
		System.out.println("redis connect test end !");
	}
}
