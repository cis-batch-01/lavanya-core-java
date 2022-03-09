package com.technocis.lms.main;

import java.util.List;
import java.util.Scanner;

import com.technocis.lms.Topic;
import com.technocis.lms.User;
import com.technocis.lms.exception.UserNotFoundException;
import com.technocis.lms.impl.TopicRepoImpl;
import com.technocis.lms.impl.UserRepoImpl;
import com.technocis.lms.methods.AreaOfInterest;

public class TopicMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TopicRepoImpl topicRepoImpl = new TopicRepoImpl();
		UserRepoImpl userRepoImpl = new UserRepoImpl();
		AreaOfInterest areaOfInterest = new AreaOfInterest();
		char option = 'n';
		do {
			System.out.println("1.Login \n2.Admin \n3.Guest \n4.Show all users");
			int choice = Integer.parseInt(scan.nextLine());
			boolean isLogged = false;
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter your email id");
					String email = scan.nextLine();
					User currentUser = userRepoImpl.FindUser(email);
					if (currentUser != null) {
						isLogged = true;
						System.out.println("Logged in successfully");

					} else {
						throw new UserNotFoundException("user not found");
					}
				} catch (UserNotFoundException e) {
					System.out.println("user not found");
				}
				System.out.println();
//				System.out.println("List of topics:");
//			 List<Topic> allTopicList1=topicRepoImpl.getAllTopic();		//to show list
//			 for(Topic topic:allTopicList1)
//			 {
//				 System.out.print(topic);
//			 } 				
				break;
			case 2:
				System.out.println("Enter user details (id,name,email,phone number)");
				String detail = scan.nextLine();
				User detailUser = User.createUser(detail);
				if (userRepoImpl.addUser(detailUser)) {
					isLogged = true;
				}
				System.out.println("successfully registered");

				System.out.println();
				System.out.println("List of topics:");
				List<Topic> allTopicList2 = topicRepoImpl.getAllTopic();
				for (Topic topic : allTopicList2) {
					System.out.print(topic);
				}
				System.out.println("enter the topic that matches your area of interest");
				String interestedArea = scan.nextLine();
				List<Topic> interestedTopic = areaOfInterest.findAreaOfInterest(allTopicList2, interestedArea);
				for (Topic topic1 : interestedTopic) {
					System.out.println(topic1);
				}
				System.out.println("enter the topic id");
				int selectedTopicId=Integer.parseInt(scan.nextLine());
				topicRepoImpl.addTopic(topicRepoImpl.getTopic(selectedTopicId), detailUser);
				//System.out.println("selected topic is subscribed successfully");
				System.out.println(detailUser);
				break;
			case 3:
				System.out.println("Welcome Guest user");
				isLogged = false;
				List<Topic> allTopicList3 = topicRepoImpl.getAllTopic();
				for (Topic topic : allTopicList3) {
					System.out.print(topic);
				}
				break;
			case 4:
				List<User>userList=userRepoImpl.getAllUser();
				for(User user:userList)
					System.out.println(user);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			
			System.out.println("do you want to continue (y/n)");
			option = scan.nextLine().charAt(0);
		} while (option == 'y' || option == 'Y');

	}
}
