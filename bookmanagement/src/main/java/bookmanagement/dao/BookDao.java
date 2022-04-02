package bookmanagement.dao;

import java.util.List;
import bookmanagement.model.Book;

public interface BookDao {

	public List<Book> getAllBooks();

	public Book insertBook(Book book);

	public Book getBook(String bookId);

	public Book updateBook(String bookId, Book book);

	public Book deleteBook(String bookId);

	public List<Book> getAllBookList(String authorId);
}
