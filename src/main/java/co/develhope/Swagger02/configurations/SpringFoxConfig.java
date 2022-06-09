package co.develhope.Swagger02.configurations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;


import java.util.Collections;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {

        ApiInfo apiInfo = new ApiInfo(
                "Math Api",
                "An API that provides services ",
                "1.0.0",
                "https://en.wikipedia.org/wiki/MIT_License",
                new Contact("John", "https://develhope.co", "john.doe@develhope.co"),
                "MIT",
                "https://en.wikipedia.org/wiki/MIT_License",
                Collections.emptyList()
        );

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo)
                .tags(
                        new Tag("default-controller", "The main initial controller for all the API features"),
                        new Tag("math-controller", "Controller dedicated just to API > math operations")
                );
    }

}
