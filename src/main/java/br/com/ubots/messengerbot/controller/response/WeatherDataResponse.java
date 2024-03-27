package br.com.ubots.messengerbot.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDataResponse {
    private double temp;
    private double feels_like;
}
