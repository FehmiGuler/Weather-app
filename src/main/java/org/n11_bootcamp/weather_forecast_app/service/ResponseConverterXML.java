package org.n11_bootcamp.weather_forecast_app.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ResponseConverterXML implements ResponseConverter{
    @Override
    public String convert() {
        return "XML";
    }
}
