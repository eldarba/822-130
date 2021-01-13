package c.dao.books;

import java.time.LocalDate;
import java.util.Objects;

// create a class based on a database table
public class Book {

	// fields
	private int id; // identifier (the field by which we identify a book)
	private String title;
	private String author;
	private double price;
	private LocalDate publication;

	// CTORs
	public Book() {
	}

	public Book(int id) {
		super();
		this.id = id;
	}

	public Book(int id, String title, String author, double price, LocalDate publication) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publication = publication;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPublication() {
		return publication;
	}

	public void setPublication(LocalDate publication) {
		this.publication = publication;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", publication="
				+ publication + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		return id == other.id;
	}

}
