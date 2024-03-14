package br.com.ubots.messengerbot.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageResponse {
    private String recipient_id;
    private String message_id;
}
