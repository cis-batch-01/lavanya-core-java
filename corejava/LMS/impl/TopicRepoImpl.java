package com.technocis.LMS.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.technocis.LMS.Topic;
import com.technocis.LMS.User;
import com.technocis.LMS.repo.TopicRepo;

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

	public boolean addTopic(Topic topic) {
		return topicList.add(topic);
	}

	public boolean removeTopic(int id) {
		Topic topic = getTopic(id);
		return topicList.remove(topic);
	}

	public boolean updateTopic(int id, Topic topic) {
		topicList.remove(id);
		return topicList.add(topic);
	}

}