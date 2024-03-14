package br.com.ubots.messengerbot.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageRequest {
    private IdRequest recipient;
    private String messaging_type = "RESPONSE";
    private MessageRequest message;
}
