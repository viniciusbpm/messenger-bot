package br.com.ubots.messengerbot.responsehandler;

public class GreetingsResponseHandler implements ResponseHandler{
    private static final String INTENT = "GREETINGS";
    private static final String RESPONSE = "Olá, vizinho!";
    @Override
    public boolean intentEquals(String messageIntent) {
        return messageIntent.equals(INTENT);
    }

    @Override
    public String getResponse() {
        return RESPONSE;
    }
}
