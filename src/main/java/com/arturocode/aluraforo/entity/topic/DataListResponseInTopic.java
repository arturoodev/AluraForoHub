package com.arturocode.aluraforo.entity.topic;

import com.arturocode.aluraforo.entity.response.Response;

import java.time.LocalDateTime;

public record DataListResponseInTopic(
        Long id,
        String message,
        LocalDateTime creationDate,
        String user,
        String solution
) {
    public DataListResponseInTopic(Response response){
        this(response.getId(), response.getMessage(), response.getTopic().getCreationDate(),
                response.getUser().getName(), response.getSolution());
    }
}
