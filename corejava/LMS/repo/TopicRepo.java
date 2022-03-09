package com.technocis.lms.repo;

import java.util.List;

import com.technocis.lms.Topic;
import com.technocis.lms.User;

public interface TopicRepo {

	public List<Topic> getAllTopic();

	public Topic getTopic(int id);

	public boolean addTopic(Topic topic);

	public boolean removeTopic(int id);

	public boolean updateTopic(int id, Topic topic);

}
