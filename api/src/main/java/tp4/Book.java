package tp4;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Book implements Serializable {
	
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return Objects.equals(isbn, book.isbn);
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(isbn);
	}
	
	@Override
	public String toString() {
		return "Book{" +
				"isbn='" + isbn + '\'' +
				", title='" + title + '\'' +
				", publishDate=" + publishDate +
				", author=" + author +
				'}';
	}
}
