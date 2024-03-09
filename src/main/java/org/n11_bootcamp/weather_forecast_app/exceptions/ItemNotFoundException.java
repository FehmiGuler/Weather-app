package org.n11_bootcamp.weather_forecast_app.exceptions;

import org.n11_bootcamp.weather_forecast_app.general.BaseErrorMessage;
import org.n11_bootcamp.weather_forecast_app.general.N11BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends N11BusinessException {
    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
