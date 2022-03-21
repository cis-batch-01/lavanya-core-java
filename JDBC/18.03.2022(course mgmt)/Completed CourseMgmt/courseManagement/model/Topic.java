package com.courseManagement.model;

public class Topic {
	private Integer id;
	private String name;
	private String description;
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Topic() {
		super();
	}

	public Topic(Integer id, String name, String description, String content) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.content = content;
	}

	public Topic(String name, String description, String content) {
		super();
		this.name = name;
		this.description = description;
		this.content = content;
	}

	public String toString() {
		return "Topic id: " + id + "\nName: " + name + "\nDescription: " + description + "\nContent: " + content;
	}

	public static Topic createTopic(String details) {
		String[] split = details.split(",");
		// Integer id=Integer.parseInt(split[0]); //because auto increment in mysql
		String name = split[0];
		String description = split[1];
		String content = split[2];
		Topic topic = new Topic(name, description, content);
		return topic;
	}

}
