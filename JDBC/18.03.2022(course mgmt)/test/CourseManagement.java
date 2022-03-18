package com.courseManagement.test;
import java.util.Scanner;

import com.courseManagement.methods.QuestionManagement;
import com.courseManagement.methods.TopicManagement;

public class CourseManagement {
public static void main(String[] args) {

Scanner scan=new Scanner(System.in);

System.out.println("1.Topic Management\n 2.Question Management");
int choice=Integer.parseInt(scan.nextLine());
switch(choice)
{
case 1:
 	TopicManagement.topicManager();
break;
case 2:
	QuestionManagement.questionManager();
break;
default:
System.out.println("Invalid choice");
break;
}


}
}

