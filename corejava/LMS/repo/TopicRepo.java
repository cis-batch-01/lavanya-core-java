package com.technocis.LMS.repo;

import java.util.List;

import com.technocis.LMS.Topic;
import com.technocis.LMS.User;

public interface TopicRepo {

	public List<Topic> getAllTopic();

	public Topic getTopic(int id);

	public boolean addTopic(Topic topic);

	public boolean removeTopic(int id);

	public boolean updateTopic(int id, Topic topic);

}
