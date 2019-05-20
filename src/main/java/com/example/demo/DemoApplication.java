package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
* @Author: 青菜
* @Date: 2019/4/30 下午3:02
* @Description: SpringBoot 启动类
* @Version 1.0
*/
@ServletComponentScan(basePackages = {"com.example.demo.filter"})
@EnableScheduling
@SpringBootApplication
//@EnableAutoConfiguration(exclude = )
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ClassPathResource("config.yml"));
		configurer.setProperties(yaml.getObject());
		return configurer;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
