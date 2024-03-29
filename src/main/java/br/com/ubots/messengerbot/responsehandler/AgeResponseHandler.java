package br.com.ubots.messengerbot.responsehandler;

public class AgeResponseHandler implements ResponseHandler{
    private static final String INTENT = "AGE";
    private static final String RESPONSE = "Tenho 40 e poucos anos";
    @Override
    public boolean intentEquals(String messageIntent) {
        return messageIntent.equals(INTENT);
    }

    @Override
    public String getResponse() {
        return RESPONSE;
    }
}
