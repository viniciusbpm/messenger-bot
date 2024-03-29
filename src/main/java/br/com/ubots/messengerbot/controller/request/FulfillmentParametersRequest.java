package br.com.ubots.messengerbot.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class FulfillmentParametersRequest {
    private Timestamp date;
    private String city;
}
