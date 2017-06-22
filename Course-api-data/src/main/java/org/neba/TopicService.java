package org.neba;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TopicService {
	@Autowired
	private TopicRespository topicRespository;
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topicp=new ArrayList<>();
		
		topicRespository.findAll().forEach(topicp::add);
		return topicp;
	}
	public Topic getTopicById(String id){
		
		return topicRespository.findOne(id);
	}
	public void addTopic(Topic topic){
//		topics.add(topic);
		topicRespository.save(topic);
	}
	public void updateTopic(String id,Topic topic){
		topicRespository.save(topic);
	}
	public void delete(String id){
		topicRespository.delete(id);
	}
}
