package com.courseManagement.methods;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.courseManagement.DAO.TopicDAO;
import com.courseManagement.DAO.TopicDAOImpl;
import com.courseManagement.model.Topic;

public class TopicManagement {
public static void topicManager() {

Scanner scan=new Scanner(System.in);
TopicDAO topicDAO=new TopicDAOImpl();
char option='n';
do
{
System.out.println("1.List of all the Topics \n2.Show a particular Topic \n3.Add a Topic \n4.Update a Topic \n5.Remove a Topic");
int choice=Integer.parseInt(scan.nextLine());
switch(choice)
{
case 1:
	System.out.println("List of topics");
	List<Topic>resTopic=topicDAO.getAllTopics();
	for(Topic top:resTopic)
	{
	System.out.println(top);
	}
	
break;
case 2:
	System.out.println("Enter the id to be viewed");
	int id=Integer.parseInt(scan.nextLine());
	Topic showTopic=topicDAO.getTopic(id);
	System.out.println(showTopic!=null?"Topic viewed successfully":"Topic not found");
	System.out.println(showTopic);
break;
case 3:
	System.out.println("Enter the details");
	String details=scan.nextLine();
	Topic addedTopic=Topic.createTopic(details);
	Topic newTopic=topicDAO.addTopic(addedTopic);
	System.out.println(newTopic!=null?"Topic added successfully":"Topic is not added");
	System.out.println(newTopic);
break;
case 4:
	System.out.println("Enter the id to be updated");
	int updatedId=Integer.parseInt(scan.nextLine());

	System.out.println("Enter the details");
	String updateDetails=scan.nextLine();

	Topic updatedTopic =Topic.createTopic(updateDetails);
	Topic topicNew=topicDAO.updateTopic(updatedId,updatedTopic);
	System.out.println(topicNew!=null?"Topic updated successfully":"Topic is not updated");
	System.out.println(topicNew);

break;
case 5:
	System.out.println("Enter the id to be deleted");
	int deletedId=Integer.parseInt(scan.nextLine());
	Topic deletedTopic=topicDAO.removeTopic(deletedId);
	System.out.println(deletedTopic!=null?"Topic deleted successfully":"Topic not deleted");
	System.out.println(deletedTopic);
break;
default:
System.out.println("Invalid choice");
break;
}
System.out.println("Do you want to continue (y/n)");
option=scan.nextLine().charAt(0);
}while(option=='y' || option=='Y');
}
}