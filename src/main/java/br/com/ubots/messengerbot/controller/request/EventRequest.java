package br.com.ubots.messengerbot.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EventRequest {
    private String object;
    private List<MessageEventRequest> entry;

    public String getReceiverId(){
        return getReceivedMessageRequest().getSender().getId();
    }

    public String getReceivedMessage(){
        return getReceivedMessageRequest().getMessage().getText();
    }

    public String getPageId(){
        return getReceivedMessageRequest().getRecipient().getId();
    }

    private ReceivedMessageRequest getReceivedMessageRequest(){
        return entry.get(0).getMessaging().get(0);
    }
}

