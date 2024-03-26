package br.com.ubots.messengerbot.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceivedMessageRequest {
    private IdRequest sender;
    private IdRequest recipient;
    private MessageTextRequest message;
}
