package com.courseManagement.DAO;

import java.util.List;

import com.courseManagement.model.Question;

public interface QuestionDAO {

	public List<Question> getAllQuestions();

	public Question getQuestion(int id);

	public Question addQuestion(Question question);

	public Question updateQuestion(int id, Question question);

	public Question removeQuestion(int id);

}