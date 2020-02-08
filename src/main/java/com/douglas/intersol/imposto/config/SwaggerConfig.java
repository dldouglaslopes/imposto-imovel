package com.douglas.intersol.imposto.config;



import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig extends WebMvcConfigurationSupport {
	 @Bean
	  public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        //.apiInfo(metaData())
	    		.select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(PathSelectors.any())
	            .build();
	  }
	
//	  private ApiInfo metaData() {
//	    return new ApiInfoBuilder()
//	        .title("Spring Boot REST API")
//	        .description("\"Spring Boot REST API para Cálculo de Imposto de Imóveis\"")
//	        .version("1.0.0")
//	        .license("Apache License Version 2.0")
//	        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//	        .build();
//	  }
//	
//	private Predicate<String> paths() {
//	    return Predicates.and( PathSelectors.regex("/customer.*"),
//	    						Predicates.not(PathSelectors.regex("/error.*")));
//	}
}
