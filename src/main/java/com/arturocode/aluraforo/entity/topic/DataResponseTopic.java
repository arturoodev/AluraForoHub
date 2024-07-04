package com.arturocode.aluraforo.entity.topic;

public record DataResponseTopic(
        Long id,
        String title,
        String message,
        String creationDate,
        String status,
        Long course_id,
        Long user_id
) {
}
