package com.technocis.corejava.practice;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class CourseMain {
	public static void main(String[] args) throws ParseException {
		CourseRepositoryImpl courseRepositoryImpl = new CourseRepositoryImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println("user implementation");
		char userChoice = 'n';
		do {
			System.out.println(
					"1.Get all course\n2.get a particular course\n3.add a particular course\n4.update a particular course\n5.remove a particular course");
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				List<Course> courseList = courseRepositoryImpl.getAll();
				System.out.println("elements from the storage");
				if (!courseList.isEmpty()) {
					for (Course course : courseList) {
						System.out.println(course);

					}
				} else {
					System.out.println("the storage list is empty");
				}
				break;
			case 2:
				System.out.println("enter the particular course id");
				int id = Integer.parseInt(scan.nextLine());
				Course course = courseRepositoryImpl.get(id);
				System.out.println(course != null ? course : "id not found");
				break;
			case 3:
				System.out.println("Enter the course Details");
				String detail = scan.nextLine();
				Course newCourse = Course.createCourse(detail);
				boolean res = courseRepositoryImpl.add(newCourse);
				System.out.println(res ? "Course Added successfully" : "storage is full");
				break;

			case 4:
				System.out.println("enter the particular course id to be updated");
				int updateId = Integer.parseInt(scan.nextLine());
				System.out.println("enter the details");
				String updateData = scan.nextLine();
				Course updateCourse = Course.createCourse(updateData);
				boolean result = courseRepositoryImpl.update(updateId, updateCourse);
				System.out.println(result ? "update" : "not updated");
				break;
			case 5:
				System.out.println("Enter the particular id to be removed");
				int newId = Integer.parseInt(scan.nextLine());
				System.out.println(courseRepositoryImpl.remove(newId) ? "Removed successfully" : "not removed");
				break;
			default:
				System.out.println("Invalid choice");
			}
			System.out.println("do you want to continue");
			userChoice = scan.nextLine().charAt(0);
		} while (userChoice == 'y' || userChoice == 'Y');

	}
}
