package com.technocis.corejava.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

	static List<Course> courseList = new ArrayList<Course>();
	static {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			courseList.add(
					new Course(1, "C", "Complete C Syllabus", "beginner", "English", 4.0, sdf.parse("22-07-1987")));
			courseList.add(
					new Course(2, "C++", "Complete C++ Syllabus", "beginner", "English", 4.3, sdf.parse("12-09-1990")));
			courseList.add(new Course(3, "Java", "Complete Java Syllabus", "intermediate", "English", 4.2,
					sdf.parse("09-05-1996")));
			courseList.add(new Course(4, "HTML", "Complete HTML Syllabus", "advance", "English", 4.5,
					sdf.parse("19-07-1982")));

		} catch (ParseException e) {

			System.out.println("date format is wrong");
		}
	}

	public List<Course> getAll() {

		return courseList;
	}

	public Boolean add(Course course) {

		return courseList.add(course);
	}

	public Course get(int id) {
		Course resCourse = null;
		for (Course course : courseList) {
			if (course.getId().equals(id)) {
				resCourse = course;
			}
		}

		return resCourse;
	}

	public Boolean remove(int id) {
		Course course = get(id);
		return courseList.remove(course);
	}

	public Boolean update(int id, Course course) {
		courseList.remove(id - 1);

		return courseList.add(course);
	}

}
