package bookmanagement.dao;

import java.util.List;

import bookmanagement.model.Author;

public interface AuthorDao {

	public List<Author> getAllAuthors();

	public Author insertAuthor();
	
	public List<Author> getAllAuthorList(String bookId);
}
