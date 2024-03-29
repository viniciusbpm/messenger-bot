package br.com.ubots.messengerbot.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {
    private List<WeatherDataResponse> data;

    public double getTemperature(){
        return data.get(0).getTemp();
    }
}
