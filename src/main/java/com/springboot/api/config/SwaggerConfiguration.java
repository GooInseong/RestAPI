package com.springboot.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /* API 를 개발하면 명세를 관리해야 한다. 명세란 해당 API 가 어떤 로직을 수행하는지 설명하고
    * 이 로직을 수행하기 위해 어떤 값을 요청하며 응답값으로는 무엇을 받을 수 있는지 정리한 자료이다.
    * 명세를 위해 Swagger 라는 오픈소스 프로젝트를 사용한다. 본 클래스는 Swagger 
    * Configuration 을 위한 클래스이다.*/

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.api"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot Open API Test With Swagger")
                .description("설명부분")
                .version("1.0.0")
                .build();
    }
}
