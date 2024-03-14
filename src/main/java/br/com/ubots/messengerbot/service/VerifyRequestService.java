package br.com.ubots.messengerbot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class VerifyRequestService {
    public String verify(String mode, String token, String challenge){
        String env = System.getenv("VERIFY_TOKEN");

        if(mode.equals("subscribe") && token.equals(env)){
            System.out.println("VERIFIED!");
            return challenge;
        } else {
            throw new ResponseStatusException(BAD_REQUEST, "Fail");
        }
    }
}
