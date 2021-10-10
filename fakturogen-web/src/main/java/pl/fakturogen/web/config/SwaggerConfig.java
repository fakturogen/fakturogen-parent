package pl.fakturogen.web.config;

import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${fakturogen.application.version}")
    private String appVersion;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET, List.of(
                        new ResponseBuilder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                                .description(HttpStatus.BAD_REQUEST.getReasonPhrase())
                                .build()))
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("pl.fakturogen.web.controller"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Fakturogen - invoices automatization")
                .version(appVersion)
                .description("App gives you possibility to connect to external invoice application, get your invoices, "
                        + "automatically generates invoices propositions (templates) for next month, and "
                        + "upload batch of new similar invoices for new month. It will make easier life for people "
                        + "who has multiple similar invoices to be created every month.")
                .build();
    }

}
