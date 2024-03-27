package br.com.ubots.messengerbot.controller;

import br.com.ubots.messengerbot.controller.request.FulfillmentRequest;
import br.com.ubots.messengerbot.controller.response.SendFulfillmentResponse;
import br.com.ubots.messengerbot.service.SendFulfillmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dialogflow")
public class DialogflowController {
    private final SendFulfillmentService sendFulfillmentService;

    public DialogflowController(SendFulfillmentService sendFulfillmentService) {
        this.sendFulfillmentService = sendFulfillmentService;
    }

    @PostMapping
    public SendFulfillmentResponse intent(@RequestBody FulfillmentRequest request){
        return sendFulfillmentService.send(request);
    }
}
