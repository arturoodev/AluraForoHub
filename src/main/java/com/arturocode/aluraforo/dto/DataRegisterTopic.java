package com.arturocode.aluraforo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegisterTopic(
        @NotBlank(message = "El titulo es obligatorio")
        String title,

        @NotBlank(message = "El mensaje es obligatorio")
        String message,

        @NotBlank(message = "El nombre del curso es obligatorio")
        String nameCourse,

        @NotNull
        Long user_id
) {
        public DataRegisterTopic(String title, String message, String nameCourse, Long user_id){
                this.title = title;
                this.message = message;
                this.nameCourse = nameCourse;
                this.user_id = user_id;
        }
}
