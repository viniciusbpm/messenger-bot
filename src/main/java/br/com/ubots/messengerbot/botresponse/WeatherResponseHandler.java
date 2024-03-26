//package br.com.ubots.messengerbot.botresponse;
//
//import br.com.ubots.messengerbot.controller.response.CityResponse;
//import br.com.ubots.messengerbot.controller.response.CurrentWeatherResponse;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//import static br.com.ubots.messengerbot.utils.RegularExpressionMatch.doesRegularExpressionMatchValue;
//import static br.com.ubots.messengerbot.utils.RegularExpressionMatch.getValueSubstringFromRegularExpression;
//import static java.lang.System.getenv;
//
//public class WeatherResponseHandler implements ResponseHandler{
//    private static final String WEATHER_REGEX = "\\b(clima|tempo)\\b.*\\bem\\b.*-[a-zA-z]+";
//    private static final String GET_CITY_SUBSTRING_REGEX = "(?<=em ).*-[a-z]{2}";
//    private String weatherResponse;
//
//    @Override
//    public boolean matches(String message) {
//        return doesRegularExpressionMatchValue(WEATHER_REGEX, message);
//    }
//
//    @Override
//    public String getResponse() {
//        return weatherResponse;
//    }
//
//    public CurrentWeatherResponse getWeather(String city){
//        Long cityId = getCityId(city);
//        String url = WEATHER_API_BASE_URL + "weather/locale/"
//                + cityId
//                + "/current?token=" + System.getenv("CLIMATEMPO_TOKEN");
//        return sendGetWeatherRequestToUrl(url);
//    }
//
//    private Long getCityId(String city) {
//        String url = WEATHER_API_BASE_URL + "locale/city?name=CityName"
//                + city
//                + "state="
//                + city
//                + "token=" + System.getenv("CLIMATEMPO_TOKEN");
//
//        CityResponse cityResponseObject = sendGetCityRequestToUrl(url);
//
//        return cityResponseObject.getId();
//    }
//
//    private CityResponse sendGetCityRequestToUrl(String url){
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, CityResponse.class);
//    }
//
//    private CurrentWeatherResponse sendGetWeatherRequestToUrl(String url){
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, CurrentWeatherResponse.class);
//    }
//
//}
