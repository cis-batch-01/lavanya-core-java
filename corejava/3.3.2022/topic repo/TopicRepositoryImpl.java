package corejava.workout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TopicRepositoryImpl implements TopicRepository {

	static List<Topic> topicList = new ArrayList<Topic>();
	static {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			topicList.add(new Topic(1, "C", "C Courses", sdf.parse("24-02-1982")));
			topicList.add(new Topic(2, "C++", "C++ Courses", sdf.parse("09-05-1996")));
			topicList.add(new Topic(3, "Java", "JAVA Courses", sdf.parse("18-03-1985")));
			topicList.add(new Topic(4, "HTML", "HTML Courses", sdf.parse("09-04-1997")));

		} catch (ParseException e) {
			System.out.println("date format is wrong");
		}
	}

	public List<Topic> getAll() {

		return topicList;
	}
 
	public Topic get(int id) {                      
		Topic resList = null;
		for (Topic topic1 : topicList) {
			if (topic1.gettId() == id) {
				resList = topic1;
			}
		}
		return resList;
	}

	public Boolean add(Topic topic) {

		return topicList.add(topic);
	}

	public Boolean remove(int id) {
		Topic topic = get(id);
		return topicList.remove(topic);
	}

	public Boolean update(int id, Topic topic) {
		topicList.remove(id-1);
		return topicList.add(topic);
	}

}
