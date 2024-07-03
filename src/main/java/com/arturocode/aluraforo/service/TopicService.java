package com.arturocode.aluraforo.service;

import com.arturocode.aluraforo.entity.topic.DataListTopicWithResponse;
import com.arturocode.aluraforo.entity.topic.Topic;
import com.arturocode.aluraforo.repository.TopicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TopicService {


    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public ResponseEntity<Page> listAllTopics(Pageable pageable){
        return ResponseEntity.ok(topicRepository.findAll(pageable)
                .map(DataListTopicWithResponse::new));

    }

    public ResponseEntity<DataListTopicWithResponse> listOneTopic(Long id){
        if(topicRepository.findById(id).isEmpty()){
            throw new RuntimeException("Topico con id: " +id+" no encontrado, verificar el id.");
        }

        Topic topic = topicRepository.getReferenceById(id);
        var topicData = new DataListTopicWithResponse(topic);

        return ResponseEntity.ok(topicData);
    }
}
