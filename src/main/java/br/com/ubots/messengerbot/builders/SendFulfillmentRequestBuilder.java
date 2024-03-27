package br.com.ubots.messengerbot.builders;

import br.com.ubots.messengerbot.controller.request.FulfillmentMessageRequest;
import br.com.ubots.messengerbot.controller.request.FulfillmentTextRequest;
import br.com.ubots.messengerbot.controller.response.SendFulfillmentResponse;

import java.util.ArrayList;
import java.util.List;

public class SendFulfillmentRequestBuilder {
    public static SendFulfillmentResponse buildResponse(String message){
        List<String> response = new ArrayList<>();
        response.add(message);

        SendFulfillmentResponse request1 = new SendFulfillmentResponse();

        FulfillmentTextRequest request4 = new FulfillmentTextRequest();
        request4.setText(response);

        List<FulfillmentMessageRequest> request2 = new ArrayList<>();
        FulfillmentMessageRequest request3 = new FulfillmentMessageRequest();
        request2.add(request3);
        request3.setText(request4);

        request1.setFulfillmentMessages(request2);

        return request1;
    }
}
