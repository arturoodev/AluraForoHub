package com.arturocode.aluraforo.repository;

import com.arturocode.aluraforo.entity.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findById(Long id);

    List<Topic> findByTitle(String title);
}
