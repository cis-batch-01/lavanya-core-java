package corejava.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseMain {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		List<Course> courseList = new ArrayList<Course>();
		courseList.add(new Course(1, "C", "beginner", "english", 4.5));
		courseList.add(new Course(2, "C++", "beginner", "english", 4.2));
		courseList.add(new Course(3, "HTML", "expert", "english", 4.0));
		courseList.add(new Course(4, "CSS", "intermediate", "english", 4.3));

		System.out.println("enter user id");
		int id = Integer.parseInt(scan.nextLine());
		Course resCourseId = null;
		for (Course course : courseList) {
			if (course.getId() == id) {           //== for integer
				resCourseId = course;
			}
		}
		try {
			if (resCourseId == null) {
				throw new CourseNotFoundException("user data for " + id + " is not found");	//CourseNotFound class is created to call here
			}
		} catch (CourseNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(resCourseId);

//for title
		System.out.println("enter the user title");
		String title = scan.nextLine();
		Course resCourseTitle = null;
		for (Course course : courseList) {
			if (course.getTitle().equals(title)) {		//equals method for string
				resCourseTitle = course;
			}
		}
		try {
			if (resCourseTitle == null) {
				throw new CourseNotFoundByTitle("user data for " + title + " is not found");
			}
		} catch (CourseNotFoundByTitle e) {
			System.out.println(e.getMessage());
		}
		System.out.println(resCourseTitle);
	}

}
