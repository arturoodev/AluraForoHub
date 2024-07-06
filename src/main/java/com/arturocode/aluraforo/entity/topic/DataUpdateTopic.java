package com.arturocode.aluraforo.entity.topic;

public record DataUpdateTopic(
        String title,
        String message,
        String nameCourse,
        Long user_id,
        String status
) {

}
