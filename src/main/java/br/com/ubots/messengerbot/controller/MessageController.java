package br.com.ubots.messengerbot.controller;

import br.com.ubots.messengerbot.request.EventRequest;
import br.com.ubots.messengerbot.service.SendMessageService;
import br.com.ubots.messengerbot.service.VerifyRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class MessageController {
    @Autowired
    private SendMessageService sendMessageService;
    @Autowired
    private VerifyRequestService verifyRequestService;

    @PostMapping
    public void sendMessage(@RequestBody EventRequest request){
        sendMessageService.send(request);
    }

    @GetMapping
    public String verify(@RequestParam("hub.mode") String mode, @RequestParam("hub.verify_token")  String token,
                         @RequestParam("hub.challenge") String challenge){
        return verifyRequestService.verify(mode, token, challenge);
    }
}

