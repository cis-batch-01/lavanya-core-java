package topicmain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.List;

import model.Topic;
import service.TopicService;
import service.TopicServiceImpl;

public class TopicTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char option = 'n';
		do {
			System.out.println(
					"1.Get all topic\n2.Get a particular topic\n3.Add a topic\n4.Update a topic\n5.Remove a topic");
			int choice = Integer.parseInt(br.readLine());
			TopicService topicService = new TopicServiceImpl();
			switch (choice) {
			case 1:
				List<Topic> topicList = topicService.getAllTopic();
				for (Topic topic : topicList) {
					System.out.println(topic);
				}
				break;
			case 2:
				System.out.println("Enter the id to search");
				int searchId = Integer.parseInt(br.readLine());
				Topic topic = topicService.getTopic(searchId);
				System.out.println(topic);
				break;
			case 3:
				System.out.println("Enter the Topic details");
				String topicDetails = br.readLine();
				Topic newTopic = Topic.createTopic(topicDetails);
				Topic resTopic = topicService.saveTopic(newTopic);
				System.out.println(resTopic != null ? "Topic inserted\n" + newTopic : "Topic not inserted");
				break;
			case 4:
				System.out.println("Enter the id to be updated");
				int updateId = Integer.parseInt(br.readLine());
				Topic oldTopic = topicService.getTopic(updateId);
				System.out.println(oldTopic);
				System.out.println("Enter the topic details ");
				String updateDetails = br.readLine();

				Topic updatedTopic = Topic.createTopic(updateDetails);
				Topic resultTopic = topicService.updateTopic(updateId, updatedTopic);
				System.out.println(resultTopic != null ? "Topic updated" : "Topic not updated");
				break;
			case 5:
				System.out.println("Enter the topic id to be removed");
				int removeId = Integer.parseInt(br.readLine());
				Topic removeTopic = topicService.deleteTopic(removeId);
				System.out.println(removeTopic != null ? "topic removed" : "topic not removed");
				break;
			default:
				System.out.println("invalid choice");
				break;
			}
			System.out.println("Do you want to continue (y/n)");
			option = br.readLine().charAt(0);
		} while (option == 'y' || option == 'Y');
	}
}
