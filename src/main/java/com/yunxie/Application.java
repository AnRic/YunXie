package com.yunxie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@ServletComponentScan
@Configuration
@EnableAutoConfiguration
//@ComponentScan
public class Application {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}
}
