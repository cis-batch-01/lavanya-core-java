package service;

import java.util.List;

import dao.TopicDAO;
import dao.TopicDAOImpl;
import model.Topic;

public class TopicServiceImpl implements TopicService {

	static TopicDAO topicDAO = new TopicDAOImpl();

	public List<Topic> getAllTopic() {
		return topicDAO.getAllTopic();
	}

	public Topic getTopic(int id) {
		return topicDAO.getTopic(id);
	}

	public Topic saveTopic(Topic topic) {
		return topicDAO.saveTopic(topic);
	}

	public Topic updateTopic(int id, Topic topic) {
		return topicDAO.updateTopic(id, topic);
	}

	public Topic deleteTopic(int id) {
		return topicDAO.deleteTopic(id);
	}

}
