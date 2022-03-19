package com.courseManagement.methods;

import java.util.List;
import java.util.Scanner;

import com.courseManagement.DAO.TopicDAO;
import com.courseManagement.DAO.TopicDAOImpl;
import com.courseManagement.model.Topic;

public class TopicManagement {
	public static void topicManager() {

		Scanner scan = new Scanner(System.in);
		TopicDAO topicDAO = new TopicDAOImpl();
		char option = 'n';
		do {
			System.out.println(
					"1.List of all the Topics \n2.Show a particular Topic \n3.Add a Topic \n4.Update a Topic \n5.Remove a Topic");
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				System.out.println("List of topics");
				List<Topic> resTopicList = topicDAO.getAllTopics();
				if (resTopicList == null) {
					System.out.println("Record not found");
				} else {
					for (Topic top : resTopicList) {
						System.out.println(top);
					}
				}
				break;
			case 2:
				System.out.println("Enter the Topic id to be viewed");
				int topicId = Integer.parseInt(scan.nextLine());
				Topic showTopic = topicDAO.getTopic(topicId);
				System.out.println(showTopic != null ? showTopic : "Topic id not found");
				break;
			case 3:
				System.out.println("Enter the details");
				String details = scan.nextLine();
				Topic addedTopic = Topic.createTopic(details);
				Topic newTopic = topicDAO.addTopic(addedTopic);
				System.out.println(newTopic != null ? "Topic is inserted" : "Topic is not added");
				System.out.println(newTopic);
				break;
			case 4:
				System.out.println("Enter the id to be updated");
				int updatedId = Integer.parseInt(scan.nextLine());
				Topic oldTopic = topicDAO.getTopic(updatedId);
				// System.out.println(oldTopic!=null?"update topic"+oldTopic:"Topic id not
				// found");
				if (oldTopic == null) {
					System.out.println("Topic id not found");
				} else {
					System.out.println(oldTopic);
					System.out.println("Enter the details");
					String updateDetails = scan.nextLine();

					Topic updatedTopic = Topic.createTopic(updateDetails);
					Topic topicNew = topicDAO.updateTopic(updatedId, updatedTopic);
					System.out.println(topicNew != null ? "Topic is updated" : "Topic is not updated");
					System.out.println(topicNew);
				}
				break;
			case 5:
				System.out.println("Enter the id to be deleted");
				int deletedId = Integer.parseInt(scan.nextLine());
				Topic deletedTopic = topicDAO.removeTopic(deletedId);
				System.out.println(deletedTopic != null ? "Topic is deleted\n" + deletedTopic : "Topic not deleted");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want to continue with Topic Manager(y/n)");
			option = scan.nextLine().charAt(0);
		} while (option == 'y' || option == 'Y');

	}
}