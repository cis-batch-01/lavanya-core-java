package com.courseManagement.DAO;

import com.courseManagement.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDAOImpl implements QuestionDAO {

	public List<Question> getAllQuestions() {
		List<Question> questionList = new ArrayList<Question>();
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("select id,topicId,content,answer from Question");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				questionList.add(new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
			return questionList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionList;
	}

public Question getQuestion(int id)  {				
Connection con=ConnectionUtil.getDbConnection();
Question ques=null;
try {
PreparedStatement pstmt=con.prepareStatement("select topicId,content,answer from question where id=?");
pstmt.setInt(1,id);
ResultSet rs=pstmt.executeQuery();
if(rs.next())
{
//ques=id,rs.getInt(1),rs.getString(2),rs.getString(3);
	ques=new Question(rs.getInt(1), rs.getString(2), rs.getString(3));
}
return ques;
}catch(SQLException e) {
e.printStackTrace();
}
return null;
}

	public Question addQuestion(Question question) {
		Connection con = ConnectionUtil.getDbConnection();
		
		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into question(topicId,content,answer) values (?,?,?)");
			pstmt.setInt(1, question.getTopicId());
			pstmt.setString(2, question.getContent());
			pstmt.setString(3, question.getAnswer());
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return question;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Question updateQuestion(int id, Question question) {
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("update Question set topicId=?,content=?,answer=? where id=?");
			pstmt.setInt(1, question.getTopicId());
			pstmt.setString(2, question.getContent());
			pstmt.setString(3, question.getAnswer());
			pstmt.setInt(4, id);
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return question;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Question removeQuestion(int id) {
		Connection con = ConnectionUtil.getDbConnection();
		Question question = getQuestion(id);
		try {
			PreparedStatement pstmt = con.prepareStatement("delete from question where id=?");
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return question;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}