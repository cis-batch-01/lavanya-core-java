package bookmanagement.model;

import java.util.Date;
import java.util.List;

public class Author {

	private String authorId;
	private String name;
	private String description;
	private String gender;
	private Date firstBookReleasedDate;
	List<Book> books;

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getFirstBookReleaseDate() {
		return firstBookReleasedDate;
	}

	public void setFirstBookReleaseDate(Date firstBookReleaseDate) {
		this.firstBookReleasedDate = firstBookReleaseDate;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Author() {
		super();
	}

	public Author(String authorId, String name, String description, String gender, Date firstBookReleasedDate,
			List<Book> books) {
		super();
		this.authorId = authorId;
		this.name = name;
		this.description = description;
		this.gender = gender;
		this.firstBookReleasedDate = firstBookReleasedDate;
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author \nauthorId=" + authorId + "\nname=" + name + "\ndescription=" + description + "\ngender="
				+ gender + "\nfirstBookReleaseDate=" + firstBookReleasedDate + "\nbooks=" + books + "\n";
	}

}
