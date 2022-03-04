package corejava.workout;

import java.util.List;

public interface TopicRepository {

	public List<Topic>getAll();
	public Topic get(int id); 		//particular id from Topic
	public Boolean add(Topic topic);   // whether the topic is added or not
	public Boolean remove(int id);		//whether the topic is removed or not
	public Boolean update(int id, Topic topic);     //whether the topic is updated or not
}
