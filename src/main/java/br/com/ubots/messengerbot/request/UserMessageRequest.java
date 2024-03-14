package br.com.ubots.messengerbot.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMessageRequest {
    private IdRequest sender;
    private IdRequest recipient;
    private MessageRequest message;
}
