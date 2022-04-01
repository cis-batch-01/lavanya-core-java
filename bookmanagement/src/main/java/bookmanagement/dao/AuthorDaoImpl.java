package bookmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmanagement.model.Author;

public class AuthorDaoImpl implements AuthorDao {

	public static final String SELECTALLAUTHORS = "select author_id,name,description,gender,first_book_released_date from Author";
	public static final String INSERTAUTHOR = "insert into Author (author_id,name,description,gender,first_book_released_date) values (?,?,?,?,?)";
	public static final String SELECTALLAUTHORBOOKS = "select Author.author_id,Author.name,Author.description,Author.gender,Author.first_book_released_date from books "
			+ "join book_author as ba on books.Book_id=ba.Book_id "
			+ "join Author on ba.Author_id=Author.author_id "
			+ " where books.book_id=?";

	public List<Author> getAllAuthors() {
		List<Author> authorList = new ArrayList<Author>();
		BookDao bookDao = new BookDaoImpl();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(SELECTALLAUTHORS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				authorList.add(new Author(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), bookDao.getAllBookList(rs.getString(1))));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return authorList;
	}

	public Author insertAuthor() {
		return null;
	}

	public List<Author> getAllAuthorList(String bookId) {
		List<Author> authorsList = new ArrayList<Author>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(SELECTALLAUTHORBOOKS);
			pstmt.setString(1, bookId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("execute");
				authorsList.add(
						new Author(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), null));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return authorsList;
	}

}
