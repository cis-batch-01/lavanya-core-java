package com.courseManagement.DAO;

import java.util.List;

import com.courseManagement.model.Topic;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicDAOImpl implements TopicDAO {

public List<Topic>getAllTopics()   {
List<Topic> topicList=new ArrayList<Topic>();
Connection con=ConnectionUtil.getDbConnection();
try  {
PreparedStatement pstmt=con.prepareStatement("select id,name,description,content from topic");
ResultSet rs=pstmt.executeQuery();
while(rs.next())
{
//topicList.add(new topic(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
	topicList.add(new Topic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
}

}catch(SQLException e)  {
e.printStackTrace();
}
return topicList;
}

public Topic getTopic(int id)  {
Connection con=ConnectionUtil.getDbConnection();
Topic topic=null;
try {
PreparedStatement pstmt=con.prepareStatement("select name,description,content from topic where id=?");
pstmt.setInt(1,id);
ResultSet rs=pstmt.executeQuery();
if(rs.next())
{
//topic=rs.getString(1),rs.getString(2),rs.getString(3);
topic=new Topic(rs.getString(1), rs.getString(2), rs.getString(3));
}

}catch(SQLException e)  {
 e.printStackTrace();
}
return topic;
}

	public Topic addTopic(Topic topic) {
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into topic (name,description,content) values (?,?,?)");
			pstmt.setString(1, topic.getName());
			pstmt.setString(2, topic.getDescription());
			pstmt.setString(3, topic.getContent());
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return topic;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Topic updateTopic(int id, Topic topic) {
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("update topic set name=?,description=?,content=? where id=?");
			pstmt.setString(1, topic.getName());
			pstmt.setString(2, topic.getDescription());
			pstmt.setString(3, topic.getContent());
			pstmt.setInt(4, id);
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return topic;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Topic removeTopic(int id) {
		Connection con = ConnectionUtil.getDbConnection();
		Topic topic = getTopic(id);
		try {
			PreparedStatement pstmt = con.prepareStatement("delete from topic where id=?");
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return topic;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
