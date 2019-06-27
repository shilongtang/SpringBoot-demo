package com.example.demo;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	StringEncryptor encryptor;

	/**
	 * 删除卡券
	 */
	@Test
	public void deleteCard() {
	//	ENC(
		String url = encryptor.encrypt("jdbc:mysql://rm-wz9qa53m3xbn8hiujo.mysql.rds.aliyuncs.com:3306/st_agent?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true");
		String name = encryptor.encrypt("st_test");
		String password = encryptor.encrypt("@stTest!1103#St$");
		System.out.println(url+"----------------");
		System.out.println(name+"----------------");
		System.out.println(password+"----------------");
		Assert.assertTrue(name.length() > 0);
		Assert.assertTrue(password.length() > 0);

	}


	@Test
	public void getHello() throws Exception {
       System.out.println("xxx");
	}

}
