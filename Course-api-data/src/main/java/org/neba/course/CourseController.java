package org.neba.course;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.neba.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getTopics(@PathVariable String topicId) {
		return courseService.getAllCourse(topicId);
	}

	@RequestMapping("/topics/{topicId}/courses/{couserID}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourseById(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
			courseService.addCourse(course);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{Id}")
	public void updateTopic(@PathVariable String id,@RequestBody Course course,@PathVariable String Id,@PathVariable String topicId){
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
		
	}
	
	@RequestMapping(value="/topics/{topicid}/courses/{id}",method=RequestMethod.DELETE)
	public void delelteTopic(@PathVariable String id){
		courseService.delete(id);
	}
}
