package corejava.workout.ropomodel;

import java.util.List;
import java.util.Scanner;

import corejava.workout.Topic;

public class QuestionMain {
public static void main(String[] args) {
	QuestionRepoImpl questionRepoImpl = new QuestionRepoImpl();     //for switch
	Scanner scan=new Scanner(System.in);
	char option='n';
	do
	{
	System.out.println("1.get all questions \n2.get a particular question \n3.add a question \n4.remove a question \n5.update a question");
	int choice=Integer.parseInt(scan.nextLine());
	switch(choice)
	{
	case 1:
		List<Question> question=questionRepoImpl.getAll();
		for(Question getQuestion: question) {
			System.out.println(getQuestion);
		}
		break;
	case 2:
		System.out.println("Enter the question id");
		int qId=Integer.parseInt(scan.nextLine());
		Question findQuestion=questionRepoImpl.get(qId);
		try {
		if(findQuestion==null)
		{
			throw new QuestionNotFoundException("question not found");
		}
		else
		{
			System.out.println(findQuestion);
		}
		}
		catch(QuestionNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		break;
	case 3:
		System.out.println("Enter the question to be added");
		String newQuestion=scan.nextLine();
		Question addQuestion=Question.createQuestion(newQuestion);
		questionRepoImpl.add(addQuestion);
		break;
	case 4:
		System.out.println("Enter the question id to be removed");
		int removeId=Integer.parseInt(scan.nextLine());
		questionRepoImpl.remove(removeId);
		System.out.println("removed successfully");
		break;
	case 5:
		System.out.println("Enter the question id to be updated");
		int updateId=Integer.parseInt(scan.nextLine());
		System.out.println("enter the details to be updated");
		String update = scan.nextLine();
		Question updateQuestion=Question.createQuestion(update);
		Boolean result = questionRepoImpl.update(updateId, updateQuestion);
		System.out.println((result) ? "updated" : "not updated");
		break;
	
		default:
			System.out.println("Invalid choice");
			break;
	}
	System.out.println("do you want to continue (y/n)");
	option = scan.nextLine().charAt(0);
	}while(option=='y'|| option=='Y');
}
}
