package com.airline.rest.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@MultipartConfig
@ComponentScan (basePackages = {"com.airline.rest"})
public class AppConfig {

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
		multipartConfigFactory.setMaxFileSize("128KB");
		multipartConfigFactory.setMaxRequestSize("128KB");
		return multipartConfigFactory.createMultipartConfig();
	}
}