package br.com.ubots.messengerbot.controller;

import br.com.ubots.messengerbot.controller.request.EventRequest;
import br.com.ubots.messengerbot.controller.response.SendMessageResponse;
import br.com.ubots.messengerbot.service.SendMessageService;
import br.com.ubots.messengerbot.service.VerifyRequestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("webhook")
public class MessageController {
    private final SendMessageService sendMessageService;
    private final VerifyRequestService verifyRequestService;

    public MessageController(SendMessageService sendMessageService, VerifyRequestService verifyRequestService) {
        this.sendMessageService = sendMessageService;
        this.verifyRequestService = verifyRequestService;
    }

    @PostMapping
    public SendMessageResponse sendMessage(@RequestBody EventRequest request){
        return sendMessageService.send(request);
    }

    @GetMapping
    public String verify(@RequestParam("hub.mode") String mode, @RequestParam("hub.verify_token")  String token,
                         @RequestParam("hub.challenge") String challenge){
        return verifyRequestService.verify(mode, token, challenge);
    }
}

