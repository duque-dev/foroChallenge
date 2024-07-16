package com.alurachallenge.foro.service;

import com.alurachallenge.foro.model.Topic;
import com.alurachallenge.foro.mapper.TopicDTO;
import com.alurachallenge.foro.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public void saveTopic(TopicDTO topicDTO){
        Topic topic = new Topic(topicDTO.title(),topicDTO.message(),topicDTO.status(),topicDTO.relatedCourse(),topicDTO.createdDate());
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic){
        topicRepository.save(topic);
    }
    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public void deleteById(Long id){
        topicRepository.deleteById(id);
    }
}
