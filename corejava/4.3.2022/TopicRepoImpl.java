package corejava.workout.ropomodel;

import java.util.ArrayList;
import java.util.List;

public class TopicRepoImpl implements TopicRepo {

	static List<Topic> topicList = new ArrayList<Topic>();
	
	static
	{
		topicList.add(new Topic(1, "pf","pgm fundamentals", "aaa"));
		topicList.add(new Topic(2, "pf","pgm fundamentals", "bbb"));
		topicList.add(new Topic(3, "pf","pgm fundamentals", "ccc"));
		topicList.add(new Topic(4, "pf","pgm fundamentals", "ddd"));
		
	}

	public List<Topic> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Topic get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean add(Topic topic) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean remove(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean update(int id, Topic topic) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
