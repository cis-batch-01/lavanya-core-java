package com.courseManagement.methods;
import java.util.Scanner;

import com.courseManagement.DAO.QuestionDAO;
import com.courseManagement.DAO.QuestionDAOImpl;
import com.courseManagement.model.Question;

import java.util.List;
import java.util.ArrayList;

public class QuestionManagement {
public static void questionManager() {

Scanner scan=new Scanner(System.in);
QuestionDAO questionDAO= new QuestionDAOImpl();
char option='n';
do
{
System.out.println("1.List of all the Questions \n2.Show a particular Question \n3.Add a Question \n4.Update a Question \n5.Remove a Question");
int choice=Integer.parseInt(scan.nextLine());
switch(choice)
{
case 1:
	System.out.println("List of Questions");
List<Question> resQuestion =questionDAO.getAllQuestions();
for(Question ques:resQuestion)
{
System.out.println(ques);
}
break;
case 2:
System.out.println("Enter the id to be viewed");
int id=Integer.parseInt(scan.nextLine());
Question getQuestion=questionDAO.getQuestion(id);
System.out.println(getQuestion!=null?"Question viewed successfully":"Question not found");
System.out.println(getQuestion);
break;

case 3:
	System.out.println("Enter the details");
	String details=scan.nextLine();
	Question addedQuestion=Question.createQuestion(details);
	Question newQuestion=questionDAO.addQuestion(addedQuestion);
	System.out.println(newQuestion!=null?"Question added successfully":"Question not added");
	System.out.println(newQuestion);
break;
case 4:
System.out.println("Enter the id to be updated");
int updateId=Integer.parseInt(scan.nextLine());
System.out.println("Enter the details");
String UpdateDetails=scan.nextLine();
Question splittedDetails=Question.createQuestion(UpdateDetails);
Question ques=questionDAO.updateQuestion(updateId,splittedDetails);
System.out.println(ques!=null?"Question updated successfully":"Question not updated");
System.out.println(ques);
break;
case 5:
System.out.println("Enter the id to be deleted");
int deleteId=Integer.parseInt(scan.nextLine());
Question delQuestion=questionDAO.removeQuestion(deleteId);
System.out.println(delQuestion!=null?"Question updated successfully":"Question not updated");
System.out.println(delQuestion);
break;
default:
System.out.println("Invalid choice");
break;
}
System.out.println("Do you want to continue (y/n)");
option=scan.nextLine().charAt(0);
}while(option=='y'||option=='Y');
}
}