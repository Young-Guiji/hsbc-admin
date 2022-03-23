package com.hsbc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xieboyun
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //标题
                .title("HSBC接口文档")
                //简介
                .description("HSBC接口文档")
                //作者、网址http:localhost:8088/doc.html(这里注意端口号要与项目一致，如果你的端口号后面还加了前缀，就需要把前缀加上)、邮箱
                .contact(new Contact("xieboyun","http:localhost:8088/doc.html","*****@qq.com"))
                //版本
                .version("1.0")
                .build();
    }

//    @Bean
//    public Docket createApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                // 可扩展性机制，用于将servlet路径映射（如果有）添加到api基本路径
//                .pathMapping("/")
//                // 为api选择启动生成器
//                .select()
//                // 要生成api接口包的路径，这里指demo包下的所有api
//                .apis(RequestHandlerSelectors.basePackage("com.hsbc"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        Contact contact = new Contact("谢拨云", "", "xieboyun@gmail.com");
//        return new ApiInfoBuilder()
//                .title("HSBC接口文档")
//                .description("HSBC接口文档")
//                .contact(contact)
//                .version("1.0")
//                .build();
//    }

}
