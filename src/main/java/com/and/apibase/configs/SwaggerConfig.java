package com.and.apibase.configs;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.hibernate.boot.Metadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;

//import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
//import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class SwaggerConfig {


    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            //.apis(RequestHandlerSelectors.any()) //set basePackage to remove internal error documentation 
            .apis(RequestHandlerSelectors.basePackage("com.and.apibase.controller"))
            //.paths(PathSelectors.any())
            //.paths(PathSelectors.ant("/api/student/*"))
            .paths(PathSelectors.ant("/api/**"))
            .build()
            //.securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
            //.securityContexts(Arrays.asList(securityContext()))
            .apiInfo(metaData()); 
    }



        private ApiInfo metaData() {
            return new ApiInfoBuilder()
                    .title("Simple Spring Boot REST API")
                    .description("Um exemplo de aplicação Spring Boot REST API")
                    .version("1.0.0")
                    .license("Apache License Version 2.0")
                    .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                    .contact(new Contact("Wladimilson", "https://treinaweb.com.br", "contato@treinaweb.com.br"))
                    .build();
        }


        /*private SecurityContext securityContext() {
            return SecurityContext.builder()
                .securityReferences(defaultAuth())
                    .forPaths(PathSelectors.regex("/.*"))
                    //.forPaths(PathSelectors.ant("/pessoa/**"))
                .build();
        }*/


        List<SecurityReference> defaultAuth() {
            AuthorizationScope authorizationScope
                = new AuthorizationScope("ADMIN", "accessEverything");
            AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
            authorizationScopes[0] = authorizationScope;
            return Arrays.asList(
                new SecurityReference("Token Access", authorizationScopes));
        }
        

    /*public ApiInfo metaData(){
        
        ApiInfo apiInfo = new ApiInfo(
                "Spring Api Documentation",
                "Demo app Spring Boot (@Anebrev)",
                "1.0",
                "www...",
                new Contact("IT Cet", "meusite.com", "emailempresa@empresa.com.br"),        
                "Null",
                "Null",
                new ArrayList<VendorExtension>()
        );
        
        return apiInfo;


    }*/



    
     


}
