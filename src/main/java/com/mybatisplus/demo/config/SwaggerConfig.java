package com.mybatisplus.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = {"com.mybatisplus.demo.controller"})
public class SwaggerConfig {
    @Bean
    public Docket customDocket () {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        Contact contact = new Contact("ZED", "http://www.ly058.cn" ,"877058128@qq.com");
        return new ApiInfoBuilder()
                .title("项目接口")
                .description("API接口")
                .contact(contact)
                .version("1.1.0")
                .build();
    }
}
