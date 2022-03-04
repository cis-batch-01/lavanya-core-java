package corejava.workout.ropomodel;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepoImpl implements QuestionRepo {
	
	static List<Question>questionList=new ArrayList<Question>();  //topic id 1 ==>pf
	static {
		questionList.add(new Question(1, 1, "what is datatype?", "type of the varaiable"));
		questionList.add(new Question(2, 1, "what is operator?", "it is a symbol to perform mathematical operations"));
		questionList.add(new Question(3, 1, "which datatype is universal?", "String"));
		questionList.add(new Question(4, 1, "what is Array?", "Collection of data in a single varaible name with continuous memory allocation."));
	}

	public List<Question> getAll() {
		
		return questionList;
	}

	public Question get(int id) {
		Question resQues=null;
	for(Question question:questionList)
	{
		if(question.getId()==id) {
			resQues=question;
		}
	}
		return resQues;
	}

	public Boolean add(Question question) {
	
		return questionList.add(question);
	}

	public Boolean remove(int id) {
		Question question=get(id);
		return questionList.remove(question);
	}

	public Boolean update(int id, Question question) {
		questionList.remove(id-1);
		return questionList.add(question);
	}

}
