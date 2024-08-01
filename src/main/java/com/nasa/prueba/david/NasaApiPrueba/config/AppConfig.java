package com.nasa.prueba.david.NasaApiPrueba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
@EnableJpaAuditing
public class AppConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
