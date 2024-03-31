package br.com.ubots.messengerbot.service;

import br.com.ubots.messengerbot.controller.request.FulfillmentRequest;
import br.com.ubots.messengerbot.controller.response.CityResponse;
import br.com.ubots.messengerbot.controller.response.WeatherResponse;
import br.com.ubots.messengerbot.responsehandler.WeatherResponseHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

@Service
public class FulfillmentService {
    private final WeatherRequestService weatherRequestService;
    private List<CityResponse> cityResponseList = new ArrayList<>();

    public FulfillmentService(WeatherRequestService weatherRequestService) {
        this.weatherRequestService = weatherRequestService;
    }

    public void setWeatherVariables(FulfillmentRequest request) {
        cityResponseList = weatherRequestService.getCity(request.getCity());
        WeatherResponseHandler.setTime(request.getTime());
        setCityIfValid(request);
        setWeatherIfValid();
    }

    private void setCityIfValid(FulfillmentRequest request) {
        if(shouldSetCityAsNull(request.getCity())){
            WeatherResponseHandler.setCity(null);
        } else if(shouldSetCity()){
            setCity();
        }
    }

    private boolean shouldSetCityAsNull(String cityFromRequest){
        return cityResponseList.isEmpty() && !cityFromRequest.isBlank();
    }

    private boolean shouldSetCity(){
        return !cityResponseList.isEmpty();
    }

    private void setCity(){
        CityResponse cityResponse = cityResponseList.get(0);
        WeatherResponseHandler.setCity(cityResponse);
    }

    private void setWeatherIfValid(){
        if(shouldSetWeather()){
            WeatherResponse weatherResponse = weatherRequestService.getWeather(
                    WeatherResponseHandler.getCity(),
                    WeatherResponseHandler.getTime()
            );
            WeatherResponseHandler.setWeather(
                    round(weatherResponse.getTemperature())
            );
        }
    }

    private boolean shouldSetWeather(){
        return WeatherResponseHandler.getCity() != null;
    }
}

