package tp4.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tp4.Book;
import tp4.ISBNNotFoundException;
import tp4.LibraryService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Client {
	private static Logger logger = LoggerFactory.getLogger(Client.class);
	
	public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
		logger.info("ex1 Client Starting ...");
		
		
		LibraryService library = (LibraryService) Naming.lookup("//localhost:1099/service/library");
		
		library.listBooks().forEach(System.out::println);
		
		List<Book> arr = new ArrayList<>();
		try {
			arr.add(library.lendBook("978-0307292063"));
			arr.add(library.lendBook("978-0307292063"));
			arr.add(library.lendBook("978-0307292063"));
			arr.add(library.lendBook("978-0307292063"));
			arr.add(library.lendBook("978-0307292063"));
		} catch (ISBNNotFoundException e) {
			e.printStackTrace();
		}
		
		for (Book book : arr) {
			try {
				library.returnBook(book);
			} catch (ISBNNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
