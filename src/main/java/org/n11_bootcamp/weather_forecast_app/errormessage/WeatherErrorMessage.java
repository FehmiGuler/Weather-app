package org.n11_bootcamp.weather_forecast_app.errormessage;

import org.n11_bootcamp.weather_forecast_app.general.BaseErrorMessage;

/**
 * @author bahadirmemis
 */
public enum WeatherErrorMessage implements BaseErrorMessage {

    GEO_DATA_NOT_FOUND("Geo location data not found for the provided parameters."),
    WEATHER_DATA_NOT_FOUND("Weather data not found for the provided parameters.");

    private final String message;

    WeatherErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
