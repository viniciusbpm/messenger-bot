package br.com.ubots.messengerbot.responsehandler;

import br.com.ubots.messengerbot.controller.response.CityResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.*;
import java.util.Objects;

import static java.util.Objects.isNull;

public class WeatherResponseHandler implements ResponseHandler {
    private static final String INTENT = "WEATHER";
    private static final String UNKNOWN_CITY_RESPONSE = "Tá me achando com cara de besta? " +
            "Me pergunta sobre uma cidade que existe, burro";

    @Getter
    @Setter
    private static CityResponse city;
    @Setter
    private static long weather = 0L;
    @Getter
    @Setter
    private static long time = 0L;


    @Override
    public boolean intentEquals(String messageIntent) {
        return messageIntent.equals(INTENT);
    }

    @Override
    public String getResponse() {
        if(isNull(city)){
            return UNKNOWN_CITY_RESPONSE;
        }
        return getVerbTense() + " fazendo " + weather + "°C em " + city.getName();
    }

    private String getVerbTense(){
        if(queryDateDayIsToday()){
            return "Está";
        } else {
            return "Estava";
        }
    }

    private boolean queryDateDayIsToday(){
        LocalDate queryDate = getQueryDate();
        LocalDate today = LocalDate.now();
        return queryDate.isEqual(today);
    }

    private LocalDate getQueryDate(){
        Instant instant = Instant.ofEpochSecond(time);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        return zonedDateTime.toLocalDate();
    }
}
