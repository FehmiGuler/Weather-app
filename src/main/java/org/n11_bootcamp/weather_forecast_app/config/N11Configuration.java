package org.n11_bootcamp.weather_forecast_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class N11Configuration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
