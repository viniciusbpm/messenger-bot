package br.com.ubots.messengerbot.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityResponse {
    private String name;
    private double lat;
    private double lon;
    private String country;
    private String state;
}
