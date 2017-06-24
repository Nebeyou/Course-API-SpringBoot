package org.neba;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neba.course.Course;
import org.neba.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseAPiTest.class)
public class CourseAPiTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	TopicService topicService;
	
	
	@Test
	public void getCourse() throws Exception{
		Topic topic=new Topic();
		topic.setDescription("My best course");
		topic.setName("EA");
		topic.setId("EA-123");
		
		final String id="EA-123";
		
		when(topicService.getTopicById(id)).thenReturn(topic);
		
		
		mockMvc.perform(get("/topics/{id}",id).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(jsonPath("$.id",is(id)));
		
		verify(topicService,times(1)).getTopicById(id);
	}

}
