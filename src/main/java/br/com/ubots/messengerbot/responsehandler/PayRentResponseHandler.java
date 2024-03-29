package br.com.ubots.messengerbot.responsehandler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PayRentResponseHandler implements ResponseHandler{
    private static final String INTENT = "PAY_RENT";
    private static final List<String> RESPONSE_LIST = Arrays.asList(
            "Dá um descansinho pro madruguinha?",
            "No momento estou sem barriga senhor trabalho... digo, digo.. estou sem trabalho senhor barriga...",
            "No lo no conosco señor, yo no soy madruguita",
            "Tenha barriga, senhor dó... digo, digo.. tenha dó, senhor barriga! Ainda não é o quinto dia útil!"
    );

    @Override
    public boolean intentEquals(String messageIntent) {
        return messageIntent.equals(INTENT);
    }

    @Override
    public String getResponse() {
        return chooseRandomResponse();
    }

    public String chooseRandomResponse(){
        Random random = new Random();
        return RESPONSE_LIST.get(random.nextInt(RESPONSE_LIST.size() - 1));
    }
}
