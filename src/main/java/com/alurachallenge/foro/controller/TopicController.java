package com.alurachallenge.foro.controller;

import com.alurachallenge.foro.domain.mapper.TopicDTO;
import com.alurachallenge.foro.domain.model.Topic;
import com.alurachallenge.foro.infrastructure.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    @Transactional
    public TopicDTO saveTopic (@RequestBody @Valid TopicDTO topicDTO){
        topicService.saveTopic(topicDTO);
        return topicDTO;
    }

    @GetMapping("/{id}")
    @Transactional
    public TopicDTO findById(@PathVariable Long id){
        Optional<Topic> topic = topicService.findById(id);
        if(topic.isPresent()){
            TopicDTO topicDTO = new TopicDTO(topic.get().getTitle(),
                    topic.get().getMessage(),
                    topic.get().getStatus(),
                    topic.get().getRelatedCourse(),
                    topic.get().getCreatedDate());
            return topicDTO;
        }else{
            return null;
        }

    }

    @PutMapping("/{id}")
    @Transactional
    public void updateById(@PathVariable Long id,@RequestBody TopicDTO topicDTO){
        Optional<Topic> updateTopic = topicService.findById(id);
        if(updateTopic.isPresent()){
            Topic topicToUpdate = updateTopic.get();
            topicToUpdate.setTitle(topicDTO.title());
            topicToUpdate.setMessage(topicDTO.message());
            topicToUpdate.setRelatedCourse(topicDTO.relatedCourse());

            topicService.updateTopic(topicToUpdate);
        }
    }

    @GetMapping
    @Transactional
    public List<TopicDTO> findAll() {
        List<Topic> topicList = topicService.findAll();
        List<TopicDTO> topicDTOList = new ArrayList<>();

        for (Topic topic : topicList) {
            TopicDTO topicDTO = new TopicDTO(
                    topic.getTitle(),
                    topic.getMessage(),
                    topic.getStatus(),
                    topic.getRelatedCourse(),
                    topic.getCreatedDate()
            );
            topicDTOList.add(topicDTO);
        }
        return topicDTOList;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteTopicById(@PathVariable Long id){
        Optional<Topic> findDeleteTopic = topicService.findById(id);
        if(findDeleteTopic.isPresent()){
            topicService.deleteById(id);
        }
    }
}
