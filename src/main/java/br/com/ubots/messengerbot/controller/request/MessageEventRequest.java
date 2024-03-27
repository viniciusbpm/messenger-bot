package br.com.ubots.messengerbot.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MessageEventRequest {
    private String id;
    private Long time;
    private List<ReceivedMessageRequest> messaging;
}
