package com.arturocode.aluraforo.controller;

import com.arturocode.aluraforo.persistence.entity.Topic;
import com.arturocode.aluraforo.persistence.repository.TopicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicRepository topicRepository;

    public TopicController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @GetMapping("/{id}")
    public Optional<Topic> getTopicById(@PathVariable Integer id) {
        return topicRepository.findById(id);
    }

    @GetMapping({"", "/"})
    public Page<Topic> getAllTopics(@PageableDefault Pageable pagination) {
        return topicRepository.findAll(pagination);
    }
}