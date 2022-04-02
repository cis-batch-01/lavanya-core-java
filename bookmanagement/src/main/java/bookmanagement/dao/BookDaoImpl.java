package bookmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmanagement.model.Author;
import bookmanagement.model.Book;

public class BookDaoImpl implements BookDao {

	public static final String SELECTALLBOOKS = "select book_id,title,description,publication,published_date,price from books";
	public static final String SELECTALLBOOKAUTHORS = "select books.Book_id,books.title,books.description,books.publication,books.published_date,books.price from books join book_author as ba on books.Book_id=ba.Book_id join Author on ba.Author_id=Author.author_id where Author.Author_id=?";
	public static final String INSERTBOOK = "insert into books (book_id,title,description,publication,published_date,price) values (?,?,?,?,?,?)";
	public static final String UPDATEBOOK = "update books set title=?,description=?,publication=?,published_date=?,price=? where book_id=?";
	public static final String DELETEBOOK = "delete from books where book_id=?";

	public List<Book> getAllBooks() {
		AuthorDao authorDao = new AuthorDaoImpl();
		List<Book> bookList = new ArrayList<Book>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(SELECTALLBOOKS);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				bookList.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getDouble(6), authorDao.getAllAuthorList(rs.getString(1))));
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
		return bookList;
	}

	public Book insertBook(Book book) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(INSERTBOOK);
			pstmt.setString(1, book.getBookId());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getDescription());
			pstmt.setString(4, book.getPublication());
			pstmt.setDate(5, new java.sql.Date(book.getPublishedDate().getTime()));
			pstmt.setDouble(6, book.getPrice());
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				BookAuthorRelDao bookAuthorRelDao = new BookAuthorRelDaoImpl();
				for (Author author : book.getAuthors()) {
					bookAuthorRelDao.insertBookAuthorRel(book.getBookId(), author.getAuthorId());

				}
				return book;
			}
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
		return null;
	}

	public List<Book> getAllBookList(String authorId) {
		List<Book> booksList = new ArrayList<Book>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(SELECTALLBOOKAUTHORS);
			pstmt.setString(1, authorId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				booksList.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getDouble(6), null));
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
		return booksList;
	}

	public Book getBook(String bookId) {

		return null;
	}

	public Book updateBook(int id, Book book) {

		return null;
	}

	public Book deleteBook(int id) {

		return null;
	}

	public Book updateBook(String bookId, Book book) {

		return null;
	}

	public Book deleteBook(String bookId) {

		return null;
	}

}
