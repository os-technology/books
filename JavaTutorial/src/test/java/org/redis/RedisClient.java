package org.redis;

import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
		String val = "redis value is "+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
		// 添加数据
		jedis.set("hello", val);
		// 拼接数据
		// jedis.append("hello", " SUCCESS");
		// jedis.del("hello");
		Assert.assertEquals(val,jedis.get("hello"));
	}

	@Test
	public void addNum() {
		jedis.del("count");
//		jedis.set("count", "1");
		jedis.incr("count");
		jedis.incr("count");
		jedis.incr("count");
		String count = jedis.get("count");
		System.out.println(count);
		Assert.assertEquals(3,Long.valueOf(count).longValue());
	}
	@Test
	 public void multValues(){
		String time = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");

		jedis.del("name","age","time");
		 jedis.mset("name","yujinshui","age","28","time",time);
		 System.out.println(jedis.get("name"));
		System.out.println(jedis.keys("*"));
		Assert.assertEquals(time,jedis.get("time"));
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
