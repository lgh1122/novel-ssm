package com.novel.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SpringfoxConfig {

	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.novel.rest.controller")).build();

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("小说阅读平台 API").description("api描述").termsOfServiceUrl("http://localhost:9085")
				.version("1.0").contact(new Contact("lgh", "", "")).build();
	}
}