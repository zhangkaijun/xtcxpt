package com.bz.xtcx.mamager.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.xtcx.manager.SampleWarApplication;
import com.bz.xtcx.manager.service.IEmailService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleWarApplication.class)
public class EmailServiceTest {

	@Autowired
	private IEmailService emailService;
	
	@Test
	public void sendSimpleMail() throws Exception {
	    emailService.sendSimpleEmail("116762952@qq.com","协同创新平台-注册验证","666666");
	}
}
