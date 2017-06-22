package org.neba;

import org.springframework.data.repository.CrudRepository;

public interface TopicRespository extends CrudRepository<Topic, String> {
	//no need to add any method unless you want specifc implementation 
}
