package br.com.ubots.messengerbot.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryResultRequest {
    private FulfillmentParametersRequest parameters;
    private IntentRequest intent;
}
