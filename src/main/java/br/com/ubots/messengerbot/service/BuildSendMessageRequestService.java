package br.com.ubots.messengerbot.service;

import br.com.ubots.messengerbot.controller.request.EventRequest;
import br.com.ubots.messengerbot.controller.request.IdRequest;
import br.com.ubots.messengerbot.controller.request.MessageTextRequest;
import br.com.ubots.messengerbot.controller.request.SendMessageRequest;
import org.springframework.stereotype.Service;

@Service
public class BuildSendMessageRequestService {
    private final ResponseStrategyService responseStrategyService;

    public BuildSendMessageRequestService(ResponseStrategyService responseStrategyService) {
        this.responseStrategyService = responseStrategyService;
    }

    public SendMessageRequest build(EventRequest request){
        String receivedMessage = request.getReceivedMessage();

        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setRecipient(new IdRequest(request.getReceiverId()));
        sendMessageRequest.setMessage(new MessageTextRequest(getResponseFromReceivedMessage(receivedMessage)));

        return sendMessageRequest;
    }

    private String getResponseFromReceivedMessage(String message){
        return responseStrategyService.chooseFromMessage(message);
    }
}
