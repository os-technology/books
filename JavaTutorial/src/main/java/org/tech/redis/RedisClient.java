package org.tech.redis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisClient {
	Jedis jedis = null;

	public RedisClient() {

	}

	@Before
	public void setConnect() {
		jedis = new Jedis("127.0.0.1", 6379);
		// 选择数据库
		jedis.select(1);
	}

	@Test
	public void redis() {

		// 添加数据
		jedis.set("hello", "redis 1");
		// 拼接数据
		// jedis.append("hello", " SUCCESS");
		// jedis.del("hello");
		System.out.println(jedis.get("hello"));

	}

	@Test
	public void addNum() {
//		jedis.set("count", "1");
		jedis.incr("count");
		jedis.incr("count");
		jedis.incr("count");
		System.out.println(jedis.get("count"));
	}
	@Test
	 public void multValues(){
		 jedis.mset("name","yujinshui","age","28");
		 System.out.println(jedis.get("name"));
	 }
	@Test
	public void testMap(){
		Map<String,String> map =new HashMap<String,String>();
		map.put("job", "IT");
		map.put("time", "3");
		map.put("user", "shui");
		jedis.hmset("info", map);
		
	}
	
	

}
