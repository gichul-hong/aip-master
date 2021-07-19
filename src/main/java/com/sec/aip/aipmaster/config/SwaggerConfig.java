package com.sec.aip.aipmaster.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
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

    private ApiInfo apiInfoV1() {

    	String apiVersion = "v1";
    	
        return new ApiInfoBuilder()
                    .title("AI Platform")
                    .description("AI Platform API List - " + apiVersion )
                    .version(apiVersion)
                    .build();
    }
    
    private Set<String> getProduceContentType() {
        
        Set<String> produce = new HashSet<>();
        produce.add("application/json;charset=UTF-8");
       
        return produce;
    }
    
    @Bean
    public Docket apiV1() {
    	
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder()
                .code(200)
                .message("OK")
                .build());
        responseMessages.add(new ResponseMessageBuilder()
                .code(400)
                .message("Bad Request")
                .build());
        responseMessages.add(new ResponseMessageBuilder()
                .code(500)
                .message("Internal Server Error")
                .build());
        
        
        return new Docket(DocumentationType.SWAGGER_2)
        		    .useDefaultResponseMessages(false)
                    .consumes(getProduceContentType())
                    .produces(getProduceContentType())
                    .apiInfo(apiInfoV1())
                    .select()
//                    .apis(RequestHandlerSelectors.any())
                    .apis(RequestHandlerSelectors.basePackage("com.sec.aip.aipmaster.v1.api"))
//                    .paths(PathSelectors.ant("/**"))
                    .build()
                    .globalResponseMessage(RequestMethod.GET, responseMessages);
    }
    
}