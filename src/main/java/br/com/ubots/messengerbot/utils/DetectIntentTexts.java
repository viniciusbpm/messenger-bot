package br.com.ubots.messengerbot.utils;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.v2.*;

import java.io.IOException;

public class DetectIntentTexts {
    private static final String PROJECT_ID = "seu-madruga-uii9";
    private static final String SESSION_ID = "123456789";
    public static Intent getIntent(String message)
            throws IOException, ApiException {
        QueryResult queryResult = getQueryResult(message);
        return queryResult.getIntent();
    }

    private static QueryResult getQueryResult(String message) throws IOException, ApiException {
        try (SessionsClient sessionsClient = SessionsClient.create()) {
            SessionName session = SessionName.of(PROJECT_ID, SESSION_ID);

                TextInput.Builder textInput =
                        TextInput.newBuilder().setText(message).setLanguageCode("pt-BR");

                QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

                DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

            return response.getQueryResult();
        }
    }
}
