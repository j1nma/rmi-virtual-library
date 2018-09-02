package tp4.server;

import tp4.Author;
import tp4.Book;
import tp4.ISBNNotFoundException;
import tp4.LibraryService;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FictionalLibrary implements LibraryService {
	
	private Map<String, Book> books;
	private volatile Map<String, Integer> stocks;
	
	FictionalLibrary(final Collection<String[]> books) {
		initializeLibrary(books);
	}
	
	private void initializeLibrary(Collection<String[]> newBooks) {
		
		this.books = new HashMap<>();
		this.stocks = new HashMap<>();
		
		for (String[] book : newBooks) {
			
			int stock = Integer.parseInt(book[0]);
			
			books.put(book[1], new Book(book[1], book[2], LocalDate.parse(book[3]), new Author(book[5], book[4])));
			stocks.put(book[1], stock);
			
		}
		
	}
	
	@Override
	public List<String> listBooks() {
		
		return books.values().stream().map(book -> book.getIsbn() + "-" + book.getTitle()).collect(Collectors.toList());
	}
	
	@Override
	public Book lendBook(String isbn) throws ISBNNotFoundException {
		
		if (!books.containsKey(isbn)) {
			throw new ISBNNotFoundException(isbn);
		}
		
		Book lendBook = stocks.get(isbn) > 0 ? books.get(isbn) : null;
		
		if (lendBook != null) {
			stocks.put(isbn, stocks.get(isbn) - 1);
		}
		
		return lendBook;
		
	}
	
	@Override
	public void returnBook(Book bookToReturn) throws ISBNNotFoundException {
		
		System.out.println("Book " + bookToReturn + " returned.");
		
		if (!books.containsKey(bookToReturn.getIsbn())) {
			throw new ISBNNotFoundException(bookToReturn.getIsbn());
		}
		
		stocks.put(bookToReturn.getIsbn(), stocks.get(bookToReturn.getIsbn()) + 1);
		
	}
}
