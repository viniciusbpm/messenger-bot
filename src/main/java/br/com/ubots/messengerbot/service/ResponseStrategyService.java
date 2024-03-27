package br.com.ubots.messengerbot.service;

import br.com.ubots.messengerbot.botresponse.ResponseHandler;
import org.springframework.stereotype.Service;

import static br.com.ubots.messengerbot.constants.BotResponseHandlers.RESPONSE_HANDLER_LIST;

@Service
public class ResponseStrategyService {
    private static final String DEFAULT_MESSAGE = "Ainda não sei responder esta mensagem";

    public String chooseFromMessage(String message){
        return getResponseMatchFromMessage(message);
    }

    private String getResponseMatchFromMessage(String message) {
        for(ResponseHandler handler : RESPONSE_HANDLER_LIST){
            if(handler.matches(message)){
                return handler.getResponse();
            }
        }
        return DEFAULT_MESSAGE;
    }
}
