package com.arturocode.aluraforo.service;

import com.arturocode.aluraforo.entity.topic.DataListTopicWithResponse;
import com.arturocode.aluraforo.entity.topic.DataRegisterTopic;
import com.arturocode.aluraforo.entity.topic.DataResponseTopic;
import com.arturocode.aluraforo.entity.topic.Topic;
import com.arturocode.aluraforo.entity.user.User;
import com.arturocode.aluraforo.repository.CourseRepository;
import com.arturocode.aluraforo.repository.TopicRepository;
import com.arturocode.aluraforo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class TopicService {


    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;


    public ResponseEntity<Page> listAllTopics(Pageable pageable) {
        return ResponseEntity.ok(topicRepository.findAll(pageable)
                .map(DataListTopicWithResponse::new));

    }

    public ResponseEntity<DataListTopicWithResponse> listOneTopic(Long id) {
        if (topicRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Topico con id: " + id + " no encontrado, verificar el id.");
        }

        Topic topic = topicRepository.getReferenceById(id);
        var topicData = new DataListTopicWithResponse(topic);

        return ResponseEntity.ok(topicData);
    }

    public ResponseEntity<DataResponseTopic> save(DataRegisterTopic dataRegisterTopic, UriComponentsBuilder uriComponentsBuilder) {
        if (courseRepository.findByName(dataRegisterTopic.nameCourse()).isEmpty()){
            throw new RuntimeException("El curso ingresado no existe en la basde de datos!");
        }

        if (userRepository.findById(dataRegisterTopic.user_id()).isEmpty()){
            throw new RuntimeException("Usuario no registrado en la base de datos!");
        }

        var topic = new Topic(dataRegisterTopic);
        topic.setCourse(courseRepository.findByName(dataRegisterTopic.nameCourse()).get());
        topic.setUser(userRepository.findById(dataRegisterTopic.user_id()).get());

        Topic topic1 = topicRepository.save(topic);

        DataResponseTopic dataResponseTopic = new DataResponseTopic(topic1.getId(),topic1.getTitle(),topic1.getMessage(),
                topic1.getCreationDate().toString(),topic1.getStatus().toString(), topic1.getCourse().getId(),
                topic1.getUser().getId());

        URI url = uriComponentsBuilder.path("/api/topics/{id}").buildAndExpand(topic1.getId()).toUri();

        return ResponseEntity.created(url).body(dataResponseTopic);
    }
}
