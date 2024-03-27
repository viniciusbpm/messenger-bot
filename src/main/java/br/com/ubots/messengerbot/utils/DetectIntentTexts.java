package br.com.ubots.messengerbot.utils;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;
import java.io.IOException;

public class DetectIntentTexts {
    public static String getResponse(String message)
            throws IOException, ApiException {
        try (SessionsClient sessionsClient = SessionsClient.create()) {
            SessionName session = SessionName.of("seu-madruga-uii9", "123456789");

                TextInput.Builder textInput =
                        TextInput.newBuilder().setText(message).setLanguageCode("pt-BR");

                QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

                DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

                QueryResult queryResult = response.getQueryResult();
                return queryResult.getFulfillmentMessages(0).getText().getText(0);
        }
    }
}
