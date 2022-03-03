package corejava.workout;

import java.util.List;

public interface TopicRepository {

	List<Topic>getAll();
	public Topic get(int id);
	public Boolean add(Topic topic);
	public Boolean remove(int id);
	public Boolean update(int id, Topic topic);
}
