package br.com.ubots.messengerbot.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class FulfillmentRequest {
    private QueryResultRequest queryResult;

    public String getCity(){
        return queryResult.getParameters().getCity();
    }

    public long getTime(){
        Timestamp date = queryResult.getParameters().getDate();
        return dateIsValid(date) ? date.toInstant().getEpochSecond() : Instant.now().getEpochSecond();
    }

    private boolean dateIsValid(Timestamp date){
        return date != null && date.toLocalDateTime().isBefore(LocalDateTime.now().plusDays(4));
    }
}
