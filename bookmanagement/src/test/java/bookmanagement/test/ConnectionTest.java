package bookmanagement.test;

import java.sql.Connection;

import bookmanagement.dao.ConnectionUtil;

public class ConnectionTest {

	public static void main(String[] args) {
		
		Connection con=ConnectionUtil.getDbConnection();
	}
}
