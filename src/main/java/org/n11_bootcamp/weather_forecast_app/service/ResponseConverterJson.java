package org.n11_bootcamp.weather_forecast_app.service;

import org.springframework.stereotype.Component;

@Component
public class ResponseConverterJson implements ResponseConverter{
    public String convert(){
        return "JSON";
    }
}
