package br.com.ubots.messengerbot.responsehandler;

public class NameResponseHandler implements ResponseHandler{
    private static final String INTENT = "NAME";
    private static final String RESPONSE = "Meu nome é Don Ramón, mas me chamam de Seu Madruga";

    @Override
    public boolean intentEquals(String messageIntent) {
        return messageIntent.equals(INTENT);
    }

    @Override
    public String getResponse() {
        return RESPONSE;
    }
}
