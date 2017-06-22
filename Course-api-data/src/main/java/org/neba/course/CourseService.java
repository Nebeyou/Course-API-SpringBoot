package org.neba.course;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourse(String topicId){
		//return topics;
		List<Course> couses=new ArrayList<>();
		
		courseRepository.findByTopicId(topicId ).forEach(couses::add);
		return couses;
	}
	public Course getCourseById(String id){
		
		return courseRepository.findOne(id);
	}
	public void addCourse(Course course){
//		topics.add(topic);
		courseRepository.save(course);
	}
	public void updateCourse(Course course){
		courseRepository.save(course);
	}
	public void delete(String id){
		courseRepository.delete(id);
	}
}
