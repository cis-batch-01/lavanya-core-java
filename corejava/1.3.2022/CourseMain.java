package com.technocis.corejava.practice;

import java.util.List;
import java.util.Scanner;

public class CourseMain {
public static void main(String[] args) {
	CourseRepositoryImpl courseRepositoryImpl=new CourseRepositoryImpl();
	Scanner scan= new Scanner(System.in);
	System.out.println("user implementation");
	char userChoice='n';
	do
	{
	System.out.println("1.Get all course\n2.get a particular course\n3.add a particular course\4.update a particular course\n5.remove a particular course");
	int choice=Integer.parseInt(scan.nextLine());
	switch(choice)
	{
	case 1:
		List<Course> courseList =courseRepositoryImpl.getAll();
		System.out.println(courseList);
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
			System.out.println("Invalid choice");
	}
	System.out.println("do you want to continue");
	userChoice= scan.nextLine().charAt(0);
	}while(userChoice=='y');
	
}
}
