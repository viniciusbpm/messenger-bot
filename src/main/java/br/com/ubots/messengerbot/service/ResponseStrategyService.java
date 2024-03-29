package br.com.ubots.messengerbot.service;

import br.com.ubots.messengerbot.responsehandler.*;
import br.com.ubots.messengerbot.utils.DetectIntentTexts;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Service
public class ResponseStrategyService {
    private static final String DEFAULT_RESPONSE = "Não sei como responder isso";
    private static List<ResponseHandler> RESPONSE_HANDLERS = new ArrayList<>();

    public ResponseStrategyService(){
        RESPONSE_HANDLERS = asList(
                new AgeResponseHandler(), new GreetingsResponseHandler(),
                new NameResponseHandler(), new PayRentResponseHandler(),
                new WeatherResponseHandler()
        );
    }

    public String chooseFromMessage(String message){
        return getResponse(message);
    }

    private String getResponse(String message) {
        String intent = getIntent(message);

        for (ResponseHandler handler : RESPONSE_HANDLERS){
            if(handler.intentEquals(intent)){
                return handler.getResponse();
            }
        }
        return DEFAULT_RESPONSE;
    }

    private String getIntent(String message){
        try {
            return DetectIntentTexts.getIntent(message).getDisplayName();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
