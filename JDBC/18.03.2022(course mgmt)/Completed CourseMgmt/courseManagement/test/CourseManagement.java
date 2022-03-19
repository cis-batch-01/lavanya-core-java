package com.courseManagement.test;

import java.util.Scanner;

import com.courseManagement.methods.QuestionManagement;
import com.courseManagement.methods.TopicManagement;

public class CourseManagement {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		char option = 'n';
		do {
			System.out.println("1.Topic Management\n 2.Question Management");
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				try {
				TopicManagement.topicManager();
				}catch(NumberFormatException e) {
					//System.out.println(e.getMessage());
					System.out.println("id should be in integer");
				}
				
				break;
			case 2:
				try {
				QuestionManagement.questionManager();
				}catch(NumberFormatException e) {
					//System.out.println(e.getMessage());
					System.out.println("id should be in integer");
				}
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want to continue with Course Management (y/n)");
			option = scan.nextLine().charAt(0);
		} while (option == 'y' || option == 'Y');

	}
}
