package com.pruebaTwitter.pruebaTecnica.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.pruebaTwitter.pruebaTecnica.ws.controller",
        "com.pruebaTwitter.pruebaTecnica.model",
        "com.pruebaTwitter.pruebaTecnica.model.mapper",
        "com.pruebaTwitter.pruebaTecnica.model.service"})
@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.pruebaTwitter")
@EntityScan(basePackages = "com.pruebaTwitter")

public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
