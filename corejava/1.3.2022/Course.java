package com.technocis.corejava.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Course {
	private Integer id;
	private String title;
	private String description;
	private String skillLevel;
	private String language;
	private Double rating;
	private Date createdDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Course() {
		super();

	}
	public Course(Integer id, String title, String description, String skillLevel, String language, Double rating,
			Date createdDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.skillLevel = skillLevel;
		this.language = language;
		this.rating = rating;
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf=  new SimpleDateFormat("dd-MM-yyyy");
	//	return "Id=" + id + "\tTitle=" + title + "\tDescription=" + description + "\tSkillLevel=" + skillLevel
		//		+ "\tLanguage=" + language + "\tRating=" + rating + "\tCreatedDate=" + createdDate;
		return String.format("%-15s%-30s%-15s%-20s%-10.2f%-20s\n",title,description,skillLevel,language, rating,sdf.format(createdDate));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public static Course createCourse(String detail) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String[] coursedetails=detail.split(",");
		Integer id = Integer.parseInt(coursedetails[0]);
		String title = coursedetails[1];
		String description = coursedetails[2];
		String skillLevel = coursedetails[3];
		String language = coursedetails[4];
		Double rating = Double.parseDouble(coursedetails[5]);
		Date createdDate = sdf.parse(coursedetails[6]);
		Course course=new Course(id, title, description, skillLevel, language, rating, createdDate);
		return course;
		
	}
}
