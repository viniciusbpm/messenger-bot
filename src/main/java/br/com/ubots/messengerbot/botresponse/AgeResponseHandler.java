package br.com.ubots.messengerbot.botresponse;

import static br.com.ubots.messengerbot.utils.RegularExpressionMatch.doesRegularExpressionMatchValue;

public class AgeResponseHandler implements ResponseHandler{
    private static final String AGE_REGEX = "\\b((quantos|qnts) anos|qual (sua|tua) idade|me (diga|diz|fala) (sua|tua) idade).*\n";
    public static final String AGE_MESSAGE = "Tenho 40 e poucos anos";

    @Override
    public boolean matches(String message) {
        return doesRegularExpressionMatchValue(AGE_REGEX, message);
    }

    @Override
    public String getResponse() {
        return AGE_MESSAGE;
    }
}
