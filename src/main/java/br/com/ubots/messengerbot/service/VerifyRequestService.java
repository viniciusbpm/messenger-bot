package br.com.ubots.messengerbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class VerifyRequestService {
    @Value("${verify.token}")
    private String verifyToken;
    private static final String MODE_EXPECTED_VALUE = "subscribe";
    private static final String FAIL_MESSAGE = "Error: unable to verify token/mode";

    public String verify(String mode, String token, String challenge){
        if (MODE_EXPECTED_VALUE.equals(mode) && token.equals(verifyToken)) {
            return challenge;
        }
        throw new ResponseStatusException(BAD_REQUEST, FAIL_MESSAGE);
    }
}
