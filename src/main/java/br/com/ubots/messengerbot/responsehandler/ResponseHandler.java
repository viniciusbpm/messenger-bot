package br.com.ubots.messengerbot.responsehandler;

public interface ResponseHandler {
    boolean intentEquals(String messageIntent);
    String getResponse();
}
