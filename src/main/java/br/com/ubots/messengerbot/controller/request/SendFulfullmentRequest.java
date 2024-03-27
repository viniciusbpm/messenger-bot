package br.com.ubots.messengerbot.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendFulfullmentRequest {
    private List<FulfillmentMessageRequest> fulfillmentMessages;
}
