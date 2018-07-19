package com.bz.xtcx.mamager.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.xtcx.manager.SampleWarApplication;
import com.bz.xtcx.manager.entity.SysUser;
import com.bz.xtcx.manager.service.IEmailService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleWarApplication.class)
public class EmailServiceTest {
	
	@Resource
    private RedisTemplate<String, SysUser> redisTemplate;

	@Autowired
	private IEmailService emailService;
	
	@Test
	public void sendSimpleMail() throws Exception {
	    emailService.sendSimpleEmail("116762952@qq.com","协同创新平台-注册验证","666666");
	}
	
	@Test
	public void testRedis() {
		ValueOperations<String, SysUser> operations = redisTemplate.opsForValue();
		SysUser user = new SysUser();
		user.setUserName("test-user");
		boolean hasKey = redisTemplate.hasKey("user1");
		System.out.println(hasKey);
		if(hasKey) {
			user = operations.get("user1");
		}else {
			operations.set("user1", user);
		}
		hasKey = redisTemplate.hasKey("user1");
		System.out.println(hasKey);
		System.out.println(redisTemplate.opsForValue().size("user1"));
		
	}
}
