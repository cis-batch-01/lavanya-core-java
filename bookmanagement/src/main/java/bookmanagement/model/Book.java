package bookmanagement.model;

import java.util.Date;
import java.util.List;

public class Book {

	private String bookId;
	private String title;
	private String description;
	private String publication;
	private Date publishedDate;
	private Double price;
	List<Author> authors;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Book(String bookId, String title, String description, String publication, Date publishedDate, Double price,
			List<Author> authors) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.description = description;
		this.publication = publication;
		this.publishedDate = publishedDate;
		this.price = price;
		this.authors = authors;
	}

	public Book(String bookId, String title, String description, String publication, Date publishedDate, Double price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.description = description;
		this.publication = publication;
		this.publishedDate = publishedDate;
		this.price = price;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book \nid=" + bookId + "\ntitle=" + title + "\ndescription=" + description + "\npublication="
				+ publication + "\npublished_date=" + publishedDate + "\nprice=" + price + "\nauthors=" + authors
				+ "\n";
	}

}
