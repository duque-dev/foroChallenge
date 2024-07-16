package com.alurachallenge.foro.domain.repository;

import com.alurachallenge.foro.domain.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
