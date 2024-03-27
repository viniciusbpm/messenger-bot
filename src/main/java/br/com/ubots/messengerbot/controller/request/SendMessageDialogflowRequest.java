package br.com.ubots.messengerbot.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageDialogflowRequest {
    private QueryInputDialogflowRequest query_input;
}
