package br.com.ubots.messengerbot.builders;

import br.com.ubots.messengerbot.controller.request.EventRequest;
import br.com.ubots.messengerbot.controller.request.EventRequestShortened;
import br.com.ubots.messengerbot.controller.request.ReceivedMessageRequest;

public class EventRequestShortenedBuilder {
    public static EventRequestShortened build(EventRequest request){
        ReceivedMessageRequest receivedMessageRequest = request.getEntry().get(0).getMessaging().get(0);

        String receiverId = receivedMessageRequest.getSender().getId();
        String receivedMessage = receivedMessageRequest.getMessage().getText();
        String pageId = receivedMessageRequest.getRecipient().getId();

        return new EventRequestShortened(receiverId, receivedMessage, pageId);
    }
}
