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
	List<Topic>topicList=new ArrayList<Topic>();

	Scanner scan=new Scanner(System.in);
	
//	System.out.println("Enter user details");
//	String uDetails=scan.nextLine();
//	User user = User.createUser(uDetails);
//	System.out.println(user);
	System.out.println("1.to get all user\n2.to get a particular user \n3.to add a user \n4.to remove a user \n5.to update a user");
	int choice=Integer.parseInt(scan.nextLine());
	switch(choice)
	{
	case 1:
		
		
		break;
	case 2:
		break;
	case 3:
		break;
	case 4:
		break;
	case 5:
		break;
	default:
		System.out.println("invalid choice");
		break;
	}
	
	System.out.println("Enter topic details");
	String tDetails=scan.nextLine();
	Topic topic=Topic.createTopic(tDetails);
	topicList.add(topic);
	
}
}



//UserRepoImpl userRepoImpl=new UserRepoImpl();            //object created to access UserRepoImpl
//TopicRepoImpl topicRepoImpl=new TopicRepoImpl();		//object created to access TopicRepoImpl
