package br.com.ubots.messengerbot.service;

import br.com.ubots.messengerbot.controller.request.FulfillmentRequest;
import br.com.ubots.messengerbot.controller.response.CityResponse;
import br.com.ubots.messengerbot.controller.response.SendFulfillmentResponse;
import br.com.ubots.messengerbot.controller.response.WeatherResponse;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

import static br.com.ubots.messengerbot.builders.SendFulfillmentRequestBuilder.buildResponse;
import static br.com.ubots.messengerbot.utils.ConvertTemperature.convertTemperatureFromKelvinToCelsius;

@Service
public class SendFulfillmentService {
    private final WeatherRequestService weatherRequestService;

    public SendFulfillmentService(WeatherRequestService weatherRequestService) {
        this.weatherRequestService = weatherRequestService;
    }

    public SendFulfillmentResponse send(FulfillmentRequest request) {
        long time = getTimeFromRequest(request);
        CityResponse city = weatherRequestService.getCity(getCityFromRequest(request)).get(0);
        WeatherResponse weather = weatherRequestService.getWeather(city, time);
        String responseMessage = getResponseMessage(weather);
        return buildResponse(responseMessage);
    }

    private String getCityFromRequest(FulfillmentRequest request) {
        return request.getQueryResult().getParameters().getCity();
    }

    private long getTimeFromRequest(FulfillmentRequest request) {
        Timestamp date = request.getQueryResult().getParameters().getDate();
        return date != null ? date.toInstant().getEpochSecond() : Instant.now().getEpochSecond();
    }

    private String getResponseMessage(WeatherResponse weather) {
        double kelvinTemperature = weather.getData().get(0).getTemp();
        long celsiusTemperature = convertTemperatureFromKelvinToCelsius(kelvinTemperature);

        return "Está fazendo " + celsiusTemperature + "°C";
    }
}
