package org.n11_bootcamp.weather_forecast_app.general;

import java.time.LocalDateTime;

public record GeneralErrorMessages(LocalDateTime date, String message, String description) {
}
