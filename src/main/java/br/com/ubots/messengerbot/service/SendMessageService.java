package br.com.ubots.messengerbot.service;

import br.com.ubots.messengerbot.controller.request.EventRequestShortened;
import br.com.ubots.messengerbot.controller.request.SendMessageRequest;
import br.com.ubots.messengerbot.controller.response.SendMessageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class SendMessageService {
    @Value("${page.token}")
    private String pageAccessToken;

    private final BuildSendMessageRequestService buildSendMessageRequestService;

    private static final String BASE_URL = "https://graph.facebook.com/v19.0/";

    public SendMessageService(BuildSendMessageRequestService buildSendMessageRequestService) {
        this.buildSendMessageRequestService = buildSendMessageRequestService;
    }

    public SendMessageResponse send(EventRequestShortened request){
        SendMessageRequest sendMessageRequest = buildSendMessageRequestService.build(request);
        String url = getUrlWithPageId(request.getPageId());
        return sendPostRequestToUrl(sendMessageRequest, url);
    }

    private String getUrlWithPageId(String pageId) {
        return BASE_URL + pageId + "/messages?access_token=" + pageAccessToken;
    }

    private SendMessageResponse sendPostRequestToUrl(SendMessageRequest sendMessageRequest, String url){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<SendMessageRequest> postRequest = new HttpEntity<>(sendMessageRequest);

        return restTemplate
                .postForObject(url, postRequest, SendMessageResponse.class);
    }
}
