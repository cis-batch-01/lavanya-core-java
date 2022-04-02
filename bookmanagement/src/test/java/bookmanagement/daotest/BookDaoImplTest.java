package bookmanagement.daotest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bookmanagement.dao.AuthorDao;
import bookmanagement.dao.AuthorDaoImpl;
import bookmanagement.dao.BookAuthorRelDao;
import bookmanagement.dao.BookAuthorRelDaoImpl;
import bookmanagement.dao.BookDao;
import bookmanagement.dao.BookDaoImpl;
import bookmanagement.model.Author;
import bookmanagement.model.Book;

public class BookDaoImplTest {
	public static void main(String[] args) {

		//bookList();
		 //bookListByAuthorId("A002");
		// authorList();
		authorListByBookId("b008");

		//insertBook("b008,J2ee,OOPS prog language,18-12-2021,Manoj publication,1500,A001-A004");
		 
//'b004','crime novel','It contains crime stories','SK_publication','2020-01-21',900
	}

	

	private static void insertBook(String bookDetails) {
		BookDao bookDao = new BookDaoImpl();
		AuthorDao authorDao = new AuthorDaoImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			String[] splitted = bookDetails.split(",");
			String book_id = splitted[0];
			String title = splitted[1];
			String description = splitted[2];
			Date published_date = sdf.parse(splitted[3]);
			String publication = splitted[4];
			Double price = Double.parseDouble(splitted[5]);
			
			String authorData = splitted[6];
			String[] authorsArray = authorData.split("-");
			List<Author> authorList = new ArrayList<Author>();
			for (int i = 0; i < authorsArray.length; i++) {
				Author author = authorDao.getAuthor(authorsArray[i]);
				if (author != null) {
					authorList.add(author);
				}
			}

			Book book = new Book(book_id, title, description, publication, published_date, price, authorList);
			// System.out.println(book);
			if (bookDao.insertBook(book) != null) {
				System.out.println("Inserted " + book);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void insertAuthor(String authorDetails) {
		AuthorDao authorDao = new AuthorDaoImpl();
		String[] spitted = authorDetails.split(",");
	}

	private static void authorListByBookId(String bookId) {
		AuthorDao authorDao = new AuthorDaoImpl();
		System.out.println(authorDao.getAllAuthorList(bookId));
	}

	private static void authorList() {
		AuthorDao authorDao = new AuthorDaoImpl();
		System.out.println(authorDao.getAllAuthors());
	}

	private static void bookListByAuthorId(String authorId) {
		BookDao bookDao = new BookDaoImpl();
		System.out.println(bookDao.getAllBookList(authorId));
	}

	private static void bookList() {
		BookDao bookDao = new BookDaoImpl();
		System.out.println(bookDao.getAllBooks());
	}

}
