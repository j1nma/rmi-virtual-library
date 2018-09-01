package tp4;

import java.time.LocalDate;

public class Book {
	
	private final String isbn;
	private final String title;
	private final LocalDate publishDate;
	private final Author author;
	
	public Book(String isbn, String title, LocalDate publishDate, Author author) {
		this.isbn = isbn;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public LocalDate getPublishDate() {
		return publishDate;
	}
	
	public Author getAuthor() {
		return author;
	}
}
