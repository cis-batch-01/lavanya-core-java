package corejava.workout.ropomodel;

import java.util.List;

public interface QuestionRepo {

	public List<Question> getAll();

	public Question get(int id);

	public Boolean add(Question question);

	public Boolean remove(int id);

	public Boolean update(int id, Question question);

}
