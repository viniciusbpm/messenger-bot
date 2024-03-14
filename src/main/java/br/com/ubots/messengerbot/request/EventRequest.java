package br.com.ubots.messengerbot.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EventRequest {
    private String object;
    private List<MessageEventRequest> entry;
}
