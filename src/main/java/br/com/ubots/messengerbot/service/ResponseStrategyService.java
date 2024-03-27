package br.com.ubots.messengerbot.service;

import br.com.ubots.messengerbot.controller.request.QueryInputDialogflowRequest;
import br.com.ubots.messengerbot.controller.request.QueryInputTextDialogflowRequest;
import br.com.ubots.messengerbot.controller.response.SendFulfillmentResponse;
import br.com.ubots.messengerbot.utils.DetectIntentTexts;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@Service
public class ResponseStrategyService {
    public String chooseFromMessage(String message){
        return getResponse(message);
    }

    private String getResponse(String message) {
        try{
            return DetectIntentTexts.getResponse(message);
        } catch (IOException e){
            return "Deu faia";
        }
    }
}
