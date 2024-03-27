package br.com.ubots.messengerbot.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryInputTextDialogflowRequest {
    private String text;
    private final String language_code = "pt-BR";
}
