package bookmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookAuthorRelDaoImpl implements BookAuthorRelDao {

	private static final String INSERTRELATION = "insert into book_author (book_id,author_id) values(?,?)";

	public int insertBookAuthorRel(String book_id, String author_id) {

		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
			pstmt = con.prepareStatement(INSERTRELATION);
			pstmt.setString(1, book_id);
			pstmt.setString(2, author_id);
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rows;
	}

}
