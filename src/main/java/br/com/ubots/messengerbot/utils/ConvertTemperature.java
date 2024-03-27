package br.com.ubots.messengerbot.utils;

import static java.lang.Math.round;

public class ConvertTemperature {
    private static final int VALUE_FOR_CONVERSION_FROM_KELVIN_TO_CELSIUS = 273;

    public static long convertTemperatureFromKelvinToCelsius(double kelvinTemperature) {
        return round(kelvinTemperature - VALUE_FOR_CONVERSION_FROM_KELVIN_TO_CELSIUS);
    }
}
