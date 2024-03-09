package org.n11_bootcamp.weather_forecast_app.controller;

import org.n11_bootcamp.weather_forecast_app.controller.contract.WeatherControllerContract;
import org.n11_bootcamp.weather_forecast_app.general.RestResponse;
import org.n11_bootcamp.weather_forecast_app.response.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherController {

    private WeatherControllerContract weatherControllerContract;

    public WeatherController(WeatherControllerContract weatherControllerContract) {
        this.weatherControllerContract = weatherControllerContract;
    }

    @GetMapping
    public ResponseEntity<RestResponse<WeatherResponse>> getWeatherInfo(@RequestParam String city,
                                                                        @RequestParam String state,
                                                                        @RequestParam String country) {
        WeatherResponse weatherResponse = weatherControllerContract.getWeatherInfo(city, state, country);
        return ResponseEntity.ok(RestResponse.of(weatherResponse));
    }
}
