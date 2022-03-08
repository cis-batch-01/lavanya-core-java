package com.technocis.LMS.main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.technocis.LMS.Topic;
import com.technocis.LMS.User;
import com.technocis.LMS.impl.TopicRepoImpl;
import com.technocis.LMS.impl.UserRepoImpl;

public class TestMain {
	public static void main(String[] args) throws ParseException {
		List<Topic> topicList = new ArrayList<Topic>();

		Scanner scan = new Scanner(System.in);
		UserRepoImpl userRepoImpl = new UserRepoImpl(); // object created to access UserRepoImpl
		TopicRepoImpl topicRepoImpl = new TopicRepoImpl(); // object created to access TopicRepoImpl

		// for registered user
		System.out.println("enter email id");
		String email = scan.nextLine();
		// UserFind userFind=new UserFind();
		 User currentUser= userRepoImpl.FindUser(email);
		

		System.out.println("Enter user details (id,name,email,ph no)");
		String details = scan.nextLine();
		User user = User.createUser(details);
		System.out.println(user);

		System.out.println("Select a topic which matches your area of interest");
		System.out.println("1.Java \n2.frontend \n3.database");
		int option = Integer.parseInt(scan.nextLine());
		switch (option) {
		case 1:// for java
			System.out.println("list of Java courses");
			System.out.println("1.Java Full Stack \n2.Java Enterprise \n3.Java Web Development");
			int javaChoice = Integer.parseInt(scan.nextLine());
			switch (javaChoice) {
			case 1:
				System.out.println("Java full stack page");
				break;
			case 2:
				System.out.println("Java Enterprise page");
				break;
			case 3:
				System.out.println("Java Web Development page");
				//currentUser.getTopicList().
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			break;

		case 2:
			System.out.println("list of Frontend courses"); // frontend
			System.out.println("1.HTML \n2.CSS \n3.Bootstrap");
			int frontendChoice = Integer.parseInt(scan.nextLine());
			switch (frontendChoice) {
			case 1:
				System.out.println("HTML page");
				break;
			case 2:
				System.out.println("CSS page");
				break;
			case 3:
				System.out.println("Bootstrap page");
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			break;
		case 3:
			System.out.println("list of database courses");
			System.out.println("1.Mysql \n2.Oracle \n3.mongodb"); // database
			int backendChoice = Integer.parseInt(scan.nextLine());
			switch (backendChoice) {
			case 1:
				System.out.println("MySql page");
				break;
			case 2:
				System.out.println("Oracle page");
				break;
			case 3:
				System.out.println("Mongodb page");
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			break;

		default:
			System.out.println("Invalid choice");
			break;
		}

		System.out.println();

///////////////
		char options = 'n';
		do {
			System.out.println(
					"1.to get all user\n2.to get a particular user \n3.to add a user \n4.to remove a user \n5.to update a user");
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				List<User> userList = userRepoImpl.getAllUser();
				for (User users : userList) {
					System.out.println(users);
				}
				break;
			case 2:
				System.out.println("Enter the user id"); // to find a particular user by id
				int userId = Integer.parseInt(scan.nextLine());
				User findUser = userRepoImpl.getUser(userId);
				System.out.println(findUser);
				break;
			case 3:
				System.out.println("Enter the user to be added");
				String addUser = scan.nextLine();
				User adduser = user.createUser(addUser);
				userRepoImpl.addUser(adduser);
				System.out.println("user added successfully");
				break;
			case 4:
				System.out.println("enter the user id to be removed");
				int removeUser = Integer.parseInt(scan.nextLine());
				userRepoImpl.removeUser(removeUser);
				System.out.println("user removed successfully");
				break;
			case 5:
				System.out.println("Enter the user id to be upated");
				int updateId = Integer.parseInt(scan.nextLine());
				System.out.println("Enter the user details to be updated");
				String updateDetails = scan.nextLine();
				User users = User.createUser(updateDetails);
				Boolean result = userRepoImpl.updateUser(updateId, users);
				System.out.println(result ? "updated" : "not updated");
				break;
			default:
				System.out.println("invalid choice");
				break;
			}
			System.out.println("do you want to continue (y/n)");
			options = scan.nextLine().charAt(0);
		} while (options == 'y' || options == 'Y');
//	
//	System.out.println("Enter topic details (id,name,description,created Date)");
//	String tDetails=scan.nextLine();
//	Topic topic=Topic.createTopic(tDetails);
//	topicList.add(topic);

	}
}
