package br.com.ubots.messengerbot.controller.response;

import br.com.ubots.messengerbot.controller.request.FulfillmentMessageRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendFulfillmentResponse {
    private List<FulfillmentMessageRequest> fulfillmentMessages;
}
