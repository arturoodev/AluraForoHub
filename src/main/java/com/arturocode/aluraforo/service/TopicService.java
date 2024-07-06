package com.arturocode.aluraforo.service;

import com.arturocode.aluraforo.entity.course.Course;
import com.arturocode.aluraforo.entity.topic.*;
import com.arturocode.aluraforo.entity.user.User;
import com.arturocode.aluraforo.repository.CourseRepository;
import com.arturocode.aluraforo.repository.TopicRepository;
import com.arturocode.aluraforo.repository.UserRepository;
import com.arturocode.aluraforo.util.ValidateTopic;
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
        if (courseRepository.findByName(dataRegisterTopic.nameCourse()).isEmpty()) {
            throw new RuntimeException("El curso ingresado no existe en la basde de datos!");
        }

        if (userRepository.findById(dataRegisterTopic.user_id()).isEmpty()) {
            throw new RuntimeException("Usuario no registrado en la base de datos!");
        }

        var topic = new Topic(dataRegisterTopic);
        topic.setCourse(courseRepository.findByName(dataRegisterTopic.nameCourse()).get());
        topic.setUser(userRepository.findById(dataRegisterTopic.user_id()).get());

        Topic topic1 = topicRepository.save(topic);

        DataResponseTopic dataResponseTopic = new DataResponseTopic(topic1.getId(), topic1.getTitle(), topic1.getMessage(),
                topic1.getCreationDate().toString(), topic1.getStatus().toString(), topic1.getCourse().getId(),
                topic1.getUser().getId());

        URI url = uriComponentsBuilder.path("/api/topics/{id}").buildAndExpand(topic1.getId()).toUri();

        return ResponseEntity.created(url).body(dataResponseTopic);
    }

    public ResponseEntity<DataResponseTopic> updateTopic(DataUpdateTopic dataUpdateTopic, Long id, UriComponentsBuilder uriComponentsBuilder) {

        Course course = null;
        User user = null;

        if (topicRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Topico no encontrado favor revisar el id.");
        }

        if (dataUpdateTopic.nameCourse() != null) {
            if (courseRepository.findByName(dataUpdateTopic.nameCourse()).isEmpty()) {
                throw new RuntimeException("El curso no existe en la base de datos");
            }
            course = courseRepository.findByName(dataUpdateTopic.nameCourse()).get();
        }

        if (dataUpdateTopic.user_id() != null) {
            if (courseRepository.findById(dataUpdateTopic.user_id()).isEmpty()) {
                throw new RuntimeException("Usuario no encontrado verificar el id");
            }
            user = userRepository.findById(dataUpdateTopic.user_id()).get();
        }

        Topic topic = topicRepository.getReferenceById(id);

        DataRegisterTopic dataRegisterTopic = new DataRegisterTopic(
                dataUpdateTopic.title(),
                dataUpdateTopic.message(),
                dataUpdateTopic.nameCourse(),
                dataUpdateTopic.user_id()
        );

        topic.updateTopic(dataUpdateTopic, course, user);

        DataResponseTopic dataResponseTopic = new DataResponseTopic(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate().toString(),
                topic.getStatus().toString(),
                topic.getCourse().getId(),
                topic.getUser().getId()
        );

        URI url = uriComponentsBuilder.path("/api/topics/{id}").buildAndExpand(topic.getId()).toUri();

        return ResponseEntity.created(url).body(dataResponseTopic);
    }

    public ResponseEntity deleteTopic(Long id) {
        if (topicRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Topico no encontrado verificar el id.");
        }
        topicRepository.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }
}
