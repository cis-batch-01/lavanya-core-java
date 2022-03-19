package com.courseManagement.DAO;

import java.util.List;

import com.courseManagement.model.Topic;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicDAOImpl implements TopicDAO {

	public List<Topic> getAllTopics() {
		List<Topic> topicList = new ArrayList<Topic>();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select id,name,description,content from topic");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				topicList.add(new Topic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (pstmt != null) {
					rs.close();
					pstmt.close();
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return topicList;
	}

	public Topic getTopic(int id) {
		Connection con = ConnectionUtil.getDbConnection();
		Topic topic = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select name,description,content from topic where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				topic = new Topic(id, rs.getString(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				if (pstmt != null) {
					pstmt.close();
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return topic;
	}

	public Topic addTopic(Topic topic) {
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("insert into topic (name,description,content) values (?,?,?)");
			pstmt.setString(1, topic.getName());
			pstmt.setString(2, topic.getDescription());
			pstmt.setString(3, topic.getContent());
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return topic;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Topic updateTopic(int id, Topic topic) {
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("update topic set name=?,description=?,content=? where id=?");
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
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Topic removeTopic(int id) {
		Connection con = ConnectionUtil.getDbConnection();
		Topic topic = getTopic(id);
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("delete from topic where id=?");
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return topic;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
