package com.arturocode.aluraforo.controller;

import com.arturocode.aluraforo.entity.topic.DataListTopicWithResponse;
import com.arturocode.aluraforo.entity.topic.DataRegisterTopic;
import com.arturocode.aluraforo.entity.topic.DataResponseTopic;
import com.arturocode.aluraforo.entity.topic.DataUpdateTopic;
import com.arturocode.aluraforo.repository.TopicRepository;
import com.arturocode.aluraforo.service.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/api/topics")
public class TopicController {


    @Autowired
    private TopicService topicService;

    @GetMapping({"", "/"})
    public ResponseEntity<Page> getAllTopics(@PageableDefault() Pageable pagination) {
        return topicService.listAllTopics(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataListTopicWithResponse> getTopicById(@PathVariable Long id) {
        return topicService.listOneTopic(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataResponseTopic> saveTopic(@RequestBody @Valid DataRegisterTopic dataRegisterTopic, UriComponentsBuilder uriComponentsBuilder) {
        return topicService.save(dataRegisterTopic, uriComponentsBuilder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponseTopic> updateTopic(@RequestBody @Valid DataUpdateTopic dataUpdateTopic, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder) {
        return topicService.updateTopic(dataUpdateTopic, id, uriComponentsBuilder);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        return topicService.deleteTopic(id);
    }
}