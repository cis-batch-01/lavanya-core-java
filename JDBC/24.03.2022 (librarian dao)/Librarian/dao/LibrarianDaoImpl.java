package com.technocis.Librarian.dao;

import java.util.List;
import com.technocis.Librarian.model.Librarian;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibrarianDaoImpl implements LibrarianDao {

	public List<Librarian> getAllLibrarian() {
		List<Librarian> librarianList = new ArrayList<Librarian>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(
					"select id,name,phoneNo,email,password,joinDate,address,areaOfInterest from librarian");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				librarianList.add(new Librarian(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			if (pstmt != null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return librarianList;

	}

	public Librarian getLibrarian(int id) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		Librarian librarian = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(
					"select name,phoneNo,email,password,joinDate,address,areaOfInterest from librarian where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				librarian = new Librarian(id, rs.getString(1), rs.getLong(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getString(6), rs.getString(7));
			}
			return librarian;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
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
		return null;

	}

	public Librarian addLibrarian(Librarian librarian) {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(
					"insert into librarian (name,phoneNo,email,password,joinDate,address,areaOfInterest) values (?,?,?,?,?,?,?)");
			pstmt.setString(1, librarian.getName());
			pstmt.setLong(2, librarian.getPhoneNo());
			pstmt.setString(3, librarian.getEmail());
			pstmt.setString(4, librarian.getPassword());
			pstmt.setDate(5, new java.sql.Date(librarian.getJoinDate().getTime()));
			pstmt.setString(6, librarian.getAddress());
			pstmt.setString(7, librarian.getAreaOfInterest());
			int noOfAffected = pstmt.executeUpdate();
			if (noOfAffected > 0) {
				return librarian;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
		}
		return null;
	}

	public Librarian updateLibrarian(int id, Librarian librarian) {
		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(
					"update librarian set name=?,phoneNo=?,email=?,password=?,joinDate=?,address=?,areaOfInterest=? where id=?");
			pstmt.setString(1, librarian.getName());
			pstmt.setLong(2, librarian.getPhoneNo());
			pstmt.setString(3, librarian.getEmail());
			pstmt.setString(4, librarian.getPassword());
			pstmt.setDate(5, new java.sql.Date(librarian.getJoinDate().getTime()));
			pstmt.setString(6, librarian.getAddress());
			pstmt.setString(7, librarian.getAreaOfInterest());
			pstmt.setInt(8, id);
			int noOfAffected = pstmt.executeUpdate();
			if (noOfAffected > 0) {
				return librarian;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return null;

	}

	public Librarian deleteLibrarian(int id) {
		PreparedStatement pstmt = null;
		Connection con = null;
		Librarian librarian = getLibrarian(id);
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement("delete from librarian where id=?");
			pstmt.setInt(1, id);
			int noOfAffected = pstmt.executeUpdate();
			if (noOfAffected > 0) {
				return librarian;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return null;

	}

}
