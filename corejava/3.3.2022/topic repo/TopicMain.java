package corejava.workout;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class TopicMain {
	public static void main(String[] args) throws ParseException {
		TopicRepositoryImpl topicrepoImpl = new TopicRepositoryImpl(); // for switch
		Scanner scan = new Scanner(System.in);

		System.out.println("Topic Implementation Process");

		char choice = 'n';
		do {
			System.out.println(
					"1.get all topics \n2.get a particular topic \n3.add a topic \n4.remove a topic \n5.update a topic");
			int option = Integer.parseInt(scan.nextLine());
			switch (option) {
			case 1:
				List<Topic> topic = topicrepoImpl.getAll();
				System.out.println("List of Topics");
				for (Topic getTopic : topic) {
					System.out.println(getTopic);
				}
				break;
			case 2:
				System.out.println("enter the particular topic id");
				int id = Integer.parseInt(scan.nextLine());
				Topic findTopic = topicrepoImpl.get(id);
				System.out.println(findTopic);
				break;
			case 3:
				System.out.println("enter the topic to be added");
				String newTopic = scan.nextLine();
				Topic addTopic = Topic.createTopic(newTopic);
				topicrepoImpl.add(addTopic);
				break;
			case 4:
				System.out.println("enter the particular topic to be removed");
				int removeTopic = Integer.parseInt(scan.nextLine());
				topicrepoImpl.remove(removeTopic);
				System.out.println("particular topic is removed");
				break;
			case 5:
				System.out.println("enter the topic id to be updated");
				int updateId = Integer.parseInt(scan.nextLine());
				System.out.println("enter the details to be updated");
				String update = scan.nextLine();
				Topic updateTopic = Topic.createTopic(update);
				Boolean res = topicrepoImpl.update(updateId, updateTopic);
				System.out.println(res ? "updated" : "not updated");
				break;
			default:
				System.out.println("Invalid option");
			}
			System.out.println("do you want to continue (y/n)");
			choice = scan.nextLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');

	}
}
