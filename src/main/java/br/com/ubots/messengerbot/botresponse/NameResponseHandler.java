package br.com.ubots.messengerbot.botresponse;

import static br.com.ubots.messengerbot.utils.RegularExpressionMatch.doesRegularExpressionMatchValue;

public class NameResponseHandler implements ResponseHandler{
    private static final String NAME_REGEX = "\\b(qual (seu|teu) nome|como (você|vc) se chama|me (?:diga|diz|fala) (?:teu|seu) nome).*";
    public static final String NAME_MESSAGE = "Meu nome é Don Ramón, mas alguns me chamam de Madruguinha";

    @Override
    public boolean matches(String message) {
        return doesRegularExpressionMatchValue(NAME_REGEX, message);
    }

    @Override
    public String getResponse() {
        return NAME_MESSAGE;
    }
}
