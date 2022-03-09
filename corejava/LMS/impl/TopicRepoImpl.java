package com.technocis.lms.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.technocis.lms.Topic;
import com.technocis.lms.User;
import com.technocis.lms.repo.TopicRepo;

public class TopicRepoImpl implements TopicRepo {

	static List<Topic> topicList = new ArrayList<Topic>();
	static {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			topicList.add(new Topic(1, "Java", "full stack", sdf.parse("21-12-2000")));
			topicList.add(new Topic(2, "HTML", "front end", sdf.parse("12-02-1990")));
		} catch (ParseException e) {

			System.out.println("date format is wrong");
		}
	}

	public List<Topic> getAllTopic() {
		return topicList; // to get all topics from the list
	}

	public Topic getTopic(int id) {
		Topic resTopic = null;
		for (Topic topic : topicList) // to get a particular topic that matches with user's id
		{
			if (topic.gettId() == id) {
				resTopic = topic;
			}
		}
		return resTopic;
	}

	public boolean addTopic(Topic topic) { // to add a particular topic
		return topicList.add(topic);
	}
	public boolean addTopic(Topic topic,User user) { // to add a particular topic
		return user.getTopicList().add(topic);
	}

	public boolean removeTopic(int id) { // to remove a particular topic
		Topic topic = getTopic(id);
		return topicList.remove(topic);
	}

	public boolean updateTopic(int id, Topic topic) { // to remove a particular topic by id and edit it
		topicList.remove(id);
		return topicList.add(topic);
	}

}