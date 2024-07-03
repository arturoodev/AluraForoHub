package com.arturocode.aluraforo.entity.topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DataListTopicWithResponse(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String status,
        String course,
        String user,
        List<DataListResponseInTopic> responses

) {
    public DataListTopicWithResponse (Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(),
                topic.getStatus().toString(), topic.getCourse().getName(), topic.getUser().getName(),
                topic.getResponses().stream()
                        .map(DataListResponseInTopic::new)
                        .collect(Collectors.toList()));
    }
}
