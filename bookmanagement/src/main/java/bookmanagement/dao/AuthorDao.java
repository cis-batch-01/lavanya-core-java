package bookmanagement.dao;

import java.util.List;

import bookmanagement.model.Author;

public interface AuthorDao {

	public List<Author> getAllAuthors();

	public Author insertAuthor(Author author);

	public List<Author> getAllAuthorList(String bookId);

	public Author getAuthor(String authorId);

	public Author updateAuthor(int authorId, Author author);

	public Author deleteAuthor(int authorIid);
}
