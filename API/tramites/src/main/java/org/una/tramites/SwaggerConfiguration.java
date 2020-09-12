/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites;

import static antlr.build.ANTLR.root;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author andre
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("org.una.tramites.controllers"))
                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag("Seguridad", "Metodos de Seguridad"),
                        new Tag("Usuarios", "Entidad de Usuarios"),
                        new Tag("Transacciones", "Entidad Transaccion"),
                        new Tag("Departamentos", "Entidad Departamentos"),
                        new Tag("Permisos", "Entidad Permisos"),
                        new Tag("Permisos_Otorgados", "Entidad Permisos Otorgados"),
                        new Tag("Tramites_Tipos", "Entidad Tipos de tramites"),
                        new Tag("Variaciones", "Entidad Tipos de variaciones"),
                        new Tag("Requisitos", "Entidad Tipos de requisitos")
                );
                

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Trámites Municipales",
                "Rest API sobre Trámites Municipales.",
                "Versión:2.1.0",
                "https://google.com",
        new Contact("UNA Sede Región Brunca", "https://srb.una.ac.cr/index.php/es/", "decanatosrb@una.cr") {
        }
        ,
                "Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList()
    

);
    }
}
