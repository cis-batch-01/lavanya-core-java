package com.technocis.corejava.practice;S

import java.util.List;

public interface CourseRepository {

	public List<Course> getAll();
	public Boolean add(Course course);
	public Course get(int id);
	public Boolean remove(int id);
	public Boolean update(int id, Course course);
	
}
