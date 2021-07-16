package com.sec.aip.aipmaster.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author mdipok
 *  https://velog.io/@tigger/API-%EB%AC%B8%EC%84%9C-%EC%9E%90%EB%8F%99%ED%99%94-Swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        
        return new ApiInfoBuilder()
                    .title("AI Platform")
                    .description("AI Platform API List")
                    .version("1.0")
                    .build();
    }
    
    private Set<String> getProduceContentType() {
        
        Set<String> produce = new HashSet<>();
        produce.add("application/json;charset=UTF-8");
       
        return produce;
    }
    
    @Bean
    public Docket commonApi() {
        
        return new Docket(DocumentationType.SWAGGER_2)
                    .consumes(getProduceContentType())
                    .produces(getProduceContentType())
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.ant("/**"))
                    .build();
    }
}
