package br.com.ubots.messengerbot.controller;

import br.com.ubots.messengerbot.controller.request.FulfillmentRequest;
import br.com.ubots.messengerbot.service.FulfillmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dialogflow")
public class DialogflowController {
    private final FulfillmentService fulfillmentService;

    public DialogflowController(FulfillmentService fulfillmentService) {
        this.fulfillmentService = fulfillmentService;
    }

    @PostMapping
    public void getDataFromFulfillment(@RequestBody FulfillmentRequest request){
        fulfillmentService.setWeatherVariables(request);
    }
}
