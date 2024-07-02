package com.arturocode.aluraforo.persistence.repository;

import com.arturocode.aluraforo.persistence.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findById(int id);
}
