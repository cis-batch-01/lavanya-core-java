package com.technocis.attendence.test;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;

public class AttendenceTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		char option = 'n';
		do {
			System.out.println(
					"1.To add a data in Attendence\n2.To select a data from Attendence\n3.To edit a data in Attendence");
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				System.out.println("Enter the Attendence details");
				String details = scan.nextLine();
				String[] splitted = details.split(",");

				PreparedStatement pstmt = null;
				Connection con = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendence", "root", "root@12345");
					pstmt = con.prepareStatement("insert into Attendence (username,status,date) values (?,?,?)");
					pstmt.setString(1, splitted[0]); // username
					pstmt.setString(2, splitted[1]); // present or absent
					pstmt.setDate(3, new java.sql.Date(sdf.parse(splitted[2]).getTime()));
					int res = pstmt.executeUpdate();
					System.out.println(res > 0 ? "Data inserted Successfully" : "Date not inserted");

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				} finally {
					try {
						pstmt.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
				break;
			case 2:
				System.out.println("Enter the id to be selected");
				int selectedId = Integer.parseInt(scan.nextLine());
				PreparedStatement pstmts = null;
				Connection conn = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendence", "root", "root@12345");
					pstmts = conn.prepareStatement("select username,status,date from Attendence where id=?");
					pstmts.setInt(1, selectedId);
					ResultSet rs = pstmts.executeQuery();
					if (rs.next()) {
						System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getDate(3));
					}
					System.out.println(rs != null ? "Data displayed" : "Data will not be displayed");

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						pstmts.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
				break;
			case 3:
				System.out.println("Enter the id to be updated from the Attendence");
				int userId = Integer.parseInt(scan.nextLine());
				System.out.println("Enter the details");
				String userDetails = scan.nextLine();

				String[] split = userDetails.split(",");
				PreparedStatement pstm = null;
				Connection connect = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendence", "root",
							"root@12345");
					pstm = connect.prepareStatement("update Attendence set username=?,status=?,date=? where id=?");
					pstm.setString(1, split[0]);
					// pstm.setBoolean(2, Boolean.parseBoolean(split[1]));
					pstm.setString(2, split[1]);
					pstm.setDate(3, new java.sql.Date(sdf.parse(split[2]).getTime()));
					pstm.setInt(4, userId);
					int res = pstm.executeUpdate();
					System.out.println(res > 0 ? "User data updated successfully" : "User data is not updated");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}

				break;

			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want to continue (y/n)");
			option = scan.nextLine().charAt(0);

		} while (option == 'y' || option == 'Y');
		scan.close();
	}
}
