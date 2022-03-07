package corejava.workout.ropomodel;

import java.util.List;

public interface TopicRepo {

	public List<Topic> getAll();

	public Topic get(int id);

	public Boolean add(Topic topic);

	public Boolean remove(int id);

	public Boolean update(int id, Topic topic);

}
