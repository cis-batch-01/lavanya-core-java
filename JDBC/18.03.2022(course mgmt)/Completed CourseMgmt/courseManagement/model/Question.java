package com.courseManagement.model;

public class Question {

	private Integer id;
	private Integer topicId;
	private String content;
	private String answer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question() {
		super();
	}

	public Question(Integer topicId, String content, String answer) {
		super();
		this.topicId = topicId;
		this.content = content;
		this.answer = answer;
	}

	public Question(Integer id, Integer topicId, String content, String answer) {
		super();
		this.id = id;
		this.topicId = topicId;
		this.content = content;
		this.answer = answer;
	}

	public String toString() {
		return "Question id: " + id + "\nTopic Id: " + topicId + "\nContent: " + content + "\nAnswer: " + answer;
	}

public static Question createQuestion(String detail) {
String[] split=detail.split(",");
	//Integer id = Integer.parseInt(split[0]);	//will be auto incremented 
Integer topicId = Integer.parseInt(split[0]);
String content = split[1];
String answer = split[2];
Question question=new Question(topicId,content,answer);
return question;
}
}
