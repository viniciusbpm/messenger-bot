package br.com.ubots.messengerbot.constants;

import br.com.ubots.messengerbot.botresponse.*;

import java.util.Arrays;
import java.util.List;

public class BotResponseHandlers {
    public static final List<ResponseHandler> RESPONSE_HANDLER_LIST = Arrays.asList(
            new NameResponseHandler(),
            new AgeResponseHandler(),
            new SeuMadrugaResponseHandler()
    );
}
