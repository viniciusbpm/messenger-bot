package br.com.ubots.messengerbot.service;

import br.com.ubots.messengerbot.controller.request.FulfillmentMessageRequest;
import br.com.ubots.messengerbot.controller.request.FulfillmentRequest;
import br.com.ubots.messengerbot.controller.request.FulfillmentTextRequest;
import br.com.ubots.messengerbot.controller.request.SendFulfullmentRequest;
import br.com.ubots.messengerbot.controller.response.CityResponse;
import br.com.ubots.messengerbot.controller.response.CurrentWeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SendFulfillmentService {
    private static final String WEATHER_API_BASE_URL = "http://api.openweathermap.org/";
    @Value("${openweather.key}")
    private String apiKey;

    public SendFulfullmentRequest send(FulfillmentRequest request) {
        CityResponse city = getCity(request.getQueryResult().getParameters().getCity());
        CurrentWeatherResponse weather = getWeather(city, request);

        String response = "Está fazendo " +
                (Math.round(weather.getData().get(0).getTemp() - 273)) + "°C";

        List<String> weathers = new ArrayList<>();
        weathers.add(response);


        SendFulfullmentRequest request1 = new SendFulfullmentRequest();
        List<FulfillmentMessageRequest> request2 = new ArrayList<>();
        FulfillmentMessageRequest request4 = new FulfillmentMessageRequest();
        FulfillmentTextRequest request3 = new FulfillmentTextRequest();
        request3.setText(weathers);
        request2.add(request4);
        request4.setText(request3);
        request1.setFulfillmentMessages(request2);

        return request1;
    }

    public CurrentWeatherResponse getWeather(CityResponse city, FulfillmentRequest request){
        String url = WEATHER_API_BASE_URL + "data/3.0/onecall/timemachine?" +
                "lat=" +
                city.getLat() +
                "&lon=" +
                city.getLon() +
                "&dt=" +
                request.getQueryResult().getParameters().getDate().toInstant().getEpochSecond() +
                "&appid=" +
                apiKey;

        return sendGetWeatherRequestToUrl(url);
    }

    private CityResponse getCity(String city) {
        String url = WEATHER_API_BASE_URL + "geo/1.0/direct?q="
                + city
                + "&appid="
                + apiKey;

        return sendGetCityRequestToUrl(url).get(0);
    }

    private List<CityResponse> sendGetCityRequestToUrl(String url){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<CityResponse>> cityListResponse =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );

        List<CityResponse> a = cityListResponse.getBody();
        return a;
    }

    private CurrentWeatherResponse sendGetWeatherRequestToUrl(String url){
        RestTemplate restTemplate = new RestTemplate();
        CurrentWeatherResponse a = restTemplate.getForObject(url, CurrentWeatherResponse.class);
        return a;
    }
}
