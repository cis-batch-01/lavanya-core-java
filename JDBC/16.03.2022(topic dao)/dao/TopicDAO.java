package dao;

import java.util.List;

import model.Topic;

public interface TopicDAO {

	public List<Topic> getAllTopic();

	public Topic getTopic(int id);

	public Topic saveTopic(Topic topic);

	public Topic updateTopic(int id, Topic topic);

	public Topic deleteTopic(int id);

}
