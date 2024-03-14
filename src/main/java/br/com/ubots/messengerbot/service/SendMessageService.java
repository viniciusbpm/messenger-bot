package br.com.ubots.messengerbot.service;

import br.com.ubots.messengerbot.request.EventRequest;
import br.com.ubots.messengerbot.request.IdRequest;
import br.com.ubots.messengerbot.request.MessageRequest;
import br.com.ubots.messengerbot.request.SendMessageRequest;
import br.com.ubots.messengerbot.response.SendMessageResponse;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

import static br.com.ubots.messengerbot.constants.Age.AGE_QUESTIONS;
import static br.com.ubots.messengerbot.constants.Name.NAME_QUESTIONS;
import static br.com.ubots.messengerbot.constants.SeuMadruga.SEU_MADRUGA_PHRASES;

@Service
public class SendMessageService {
    public void send(EventRequest request){
        String pageId = System.getenv("PAGE_ID");
        String message = request
                .getEntry()
                .get(0)
                .getMessaging()
                .get(0)
                .getMessage()
                .getText();

        String receiver = request.getEntry()
                .get(0)
                .getMessaging()
                .get(0)
                .getSender()
                .getId();

        if(receiver.equals(pageId)){
            return;
        }

        String response = getResponse(message);

        sendPostRequest(response, receiver, pageId);
    }

    private String getResponse(String message){
        String response = "";

        if(message.equals("pague o aluguel")){
            Random random = new Random();
            int index = random.nextInt(SEU_MADRUGA_PHRASES.size());

            response = SEU_MADRUGA_PHRASES.get(index);
        }

        if(message.equals("pague o aluguel")){
            Random random = new Random();
            int index = random.nextInt(SEU_MADRUGA_PHRASES.size());

            response = SEU_MADRUGA_PHRASES.get(index);
        }

        for(int i = 0; i < AGE_QUESTIONS.size() && response.isEmpty(); i++){
            String messageLowerCase = message.toLowerCase();
            if(messageLowerCase.contains(NAME_QUESTIONS.get(i))){
                response = "Meu nome é Vinícius Machado Pacheco";
            } else if(messageLowerCase.contains(AGE_QUESTIONS.get(i))){
                response = "Tenho 20 anos de idade";
            }
        }

        if(response.isBlank()){
            response = "Ainda não sei responder este tipo de mensagem!";
        }

        return response;
    }

    private SendMessageResponse sendPostRequest(String message, String receiverId, String pageId){
        String pat = System.getenv("PAGE_ACCESS_TOKEN");
        String url = "https://graph.facebook.com/v19.0/" + pageId + "/messages?access_token=" + pat;

        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setRecipient(new IdRequest(receiverId));

        MessageRequest messageRequest = new MessageRequest();

        messageRequest.setText(message);
        sendMessageRequest.setMessage(messageRequest);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<SendMessageRequest> postRequest = new HttpEntity<>(sendMessageRequest);

        return restTemplate.postForObject(url, postRequest, SendMessageResponse.class);
    }
}
