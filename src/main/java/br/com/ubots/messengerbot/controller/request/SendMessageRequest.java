package br.com.ubots.messengerbot.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageRequest {
    private IdRequest recipient;
    private String messaging_type = "RESPONSE";
    private MessageTextRequest message;
}
