package tp4;

public class ISBNNotFoundException extends Exception {
	
	public ISBNNotFoundException(String isbn) {
		super("Book with isbn " + isbn + " not found.");
	}
}
