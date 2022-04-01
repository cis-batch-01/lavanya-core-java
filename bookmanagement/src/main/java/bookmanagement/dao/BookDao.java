package bookmanagement.dao;

import java.util.List;

import bookmanagement.model.Book;

public interface BookDao {

	public List<Book> getAllBooks();

	public Book insertBook(Book book);

	public List<Book> getAllBookList(String authorId); 
}
