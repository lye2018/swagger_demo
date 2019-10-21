package com.lye.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 // 开启swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的swagger的Docket的bean实例
        Profiles profiles = Profiles.of("dev", "test");

        // 通过enviroment.acceptsProfiles判断是否处于设置的环境
        Boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                // 是否开启swagger
                .enable(flag)
                .groupName("helloModel")
                .apiInfo(apiInfo())
                .select()
                // RequestHandlerSelectors，配置要扫描接口的方式
                // basePackage：指定扫描路径
                // any()：扫描全部
                // none()：不扫描
                // withClassAnnotation：扫描类上注解，参数是一个注解的反射对象
                // withMethodAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.lye.swagger.controller"))
                // paths()：过滤什么路径
                // any()：
                // none()：
                // ant()：
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 其他人的接口模块
     * @return
     */
    @Bean
    public Docket docketA() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docketB() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docketC() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    // 配置swagger信息 ApiInfo
    public ApiInfo apiInfo() {

        // 作者信息
        Contact contact = new Contact("lye","www.baidu.com","1415484224@qq.com");
        return new ApiInfo(
                "Swagger API日记",
                "fighting",
                "v1.0",
                "www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
