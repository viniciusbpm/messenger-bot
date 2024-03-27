package br.com.ubots.messengerbot.botresponse;

public interface ResponseHandler {
    boolean matches(String message);
    String getResponse();
}
