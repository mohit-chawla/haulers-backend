package edu.cornell.haulers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author mohitchawla
 * 
 * Main Configuration class for SpringBoot Application
 * All bean configurations here.
 */
@Configuration
@EnableSwagger2
public class HaulersConfiguration {
	
	/**
	 * Configuration for swagger
	 */
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("edu.cornell.haulers.controllers"))
                .build();
             
    }
}
