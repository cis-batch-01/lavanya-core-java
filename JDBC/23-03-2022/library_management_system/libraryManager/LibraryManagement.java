package com.technocis.library_management_system.libraryManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.technocis.library_management_system.model.Librarian;

public class LibraryManagement {

	public static Connection getDbConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_manager", "root", "root@12345");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Librarian insertLibrarian(Librarian librarian) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = LibraryManagement.getDbConnection();
			pstmt = con.prepareStatement(
					"insert into Librarian(name,phoneNo,email,password,joinDate,address,areaOfInterest)values(?,?,?,?,?,?,?)");
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
		}

		finally {
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

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out
					.println("Enter the details (Name,Phone number,Email,Password,Join Date,Address,Area of Interest");
			String details = br.readLine();
			Librarian newLibrarian = Librarian.createLibrarian(details);
			Librarian insertedLibrarian = LibraryManagement.insertLibrarian(newLibrarian);
			System.out.println(insertedLibrarian != null ?  "Librarian details is added\n"+insertedLibrarian
					: "Librarian details not added");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
