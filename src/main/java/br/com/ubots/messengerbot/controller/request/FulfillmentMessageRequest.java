package br.com.ubots.messengerbot.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FulfillmentMessageRequest {
    private FulfillmentTextRequest text;
}
