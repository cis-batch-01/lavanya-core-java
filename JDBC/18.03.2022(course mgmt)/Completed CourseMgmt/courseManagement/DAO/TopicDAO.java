package com.courseManagement.DAO;

import java.util.List;

import com.courseManagement.model.Topic;

public interface TopicDAO {

	public List<Topic> getAllTopics();

	public Topic getTopic(int id);

	public Topic addTopic(Topic topic);

	public Topic updateTopic(int id, Topic topic);

	public Topic removeTopic(int id);

}