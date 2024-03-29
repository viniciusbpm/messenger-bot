package br.com.ubots.messengerbot.service;

import br.com.ubots.messengerbot.controller.response.CityResponse;
import br.com.ubots.messengerbot.controller.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherRequestService {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private static final String WEATHER_API_BASE_URL = "http://api.openweathermap.org/";
    @Value("${openweather.key}")
    private String apiKey;

    public List<CityResponse> getCity(String city) {
        String url = getCityUrl(city);
        try{
            ResponseEntity<List<CityResponse>> cityListResponse =
                    REST_TEMPLATE.exchange(
                            url, HttpMethod.GET, null,
                            new ParameterizedTypeReference<>() {}
                    );
            return cityListResponse.getBody();
        } catch (HttpClientErrorException exception){
            return new ArrayList<>();
        }
    }

    public WeatherResponse getWeather(CityResponse city, long time) {
        String url = getWeatherUrl(city, time);
        return REST_TEMPLATE.getForObject(url, WeatherResponse.class);
    }

    private String getCityUrl(String city){
        return WEATHER_API_BASE_URL + "geo/1.0/direct?"
                + "q=" + city
                + "&appid=" + apiKey;
    }

    private String getWeatherUrl(CityResponse city, long time){
        return WEATHER_API_BASE_URL + "data/3.0/onecall/timemachine?"
                + "lat=" + city.getLat()
                + "&lon=" + city.getLon()
                + "&dt=" + time
                + "&appid=" + apiKey;
    }
}
