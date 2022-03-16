package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Topic;

public class TopicDAOImpl implements TopicDAO {

	static String selectAllTopics = "select id,name,description,content from topic";
	static String selectTopic = "select id,name,description,content from topic where id=?";
	static String insertTopic = "insert into topic (name,description,content) values (?,?,?)";
	static String UpdateTopic = "update Topic set name=?,description=?,content=? where id=?";
	static String deleteTopic = "delete from Topic where id=?";

	public List<Topic> getAllTopic() {
		List<Topic> topicList = new ArrayList<Topic>();
		Connection con = ConnectionUtil.getDBConnect();
		try {
			PreparedStatement pstmt = con.prepareStatement(selectAllTopics);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				topicList.add(new Topic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topicList;
	}

	public Topic getTopic(int id) {
		Connection con = ConnectionUtil.getDBConnect();
		Topic topic = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(selectTopic);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				topic = new Topic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topic;
	}

	public Topic saveTopic(Topic topic) {
		Connection con = ConnectionUtil.getDBConnect();
		try {
			PreparedStatement pstmt = con.prepareStatement(insertTopic);
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
		Connection con = ConnectionUtil.getDBConnect();
		try {
			PreparedStatement pstmt = con.prepareStatement(UpdateTopic);
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

	public Topic deleteTopic(int id) {
		Connection con = ConnectionUtil.getDBConnect();
		Topic topic = getTopic(id);
		try {
			PreparedStatement pstmt = con.prepareStatement(deleteTopic);
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
