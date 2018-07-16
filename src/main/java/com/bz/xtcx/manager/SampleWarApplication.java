package com.bz.xtcx.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Sample WAR application
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.bz.xtcx.manager.*")
@ComponentScan({"com.bz.xtcx.manager.*"})
public class SampleWarApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) throws Exception{
		//System.out.println(SampleWarApplication.class.getResource("/").toString());
		//System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(SampleWarApplication.class, args);
	}
	
}
