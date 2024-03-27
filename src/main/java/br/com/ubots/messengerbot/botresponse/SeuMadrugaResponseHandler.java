package br.com.ubots.messengerbot.botresponse;

import java.util.Random;

import static br.com.ubots.messengerbot.constants.SeuMadruga.SEU_MADRUGA_PHRASES;
import static br.com.ubots.messengerbot.utils.RegularExpressionMatch.doesRegularExpressionMatchValue;

public class SeuMadrugaResponseHandler implements ResponseHandler{
    private static final String SEU_MADRUGA_REGEX = ".?(pague o aluguel).?";

    @Override
    public boolean matches(String message) {
        return doesRegularExpressionMatchValue(SEU_MADRUGA_REGEX, message);
    }

    @Override
    public String getResponse() {
        return getSeuMadrugaResponse();
    }

    private String getSeuMadrugaResponse(){
        Random random = new Random();
        int randomIndex = random.nextInt(SEU_MADRUGA_PHRASES.size());
        return SEU_MADRUGA_PHRASES.get(randomIndex);
    }
}
