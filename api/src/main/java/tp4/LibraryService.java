package tp4;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LibraryService extends Remote {
	
	List<String> listBooks() throws RemoteException;
	
	Book lendBook(String isbn) throws RemoteException, ISBNNotFoundException;
	
	void returnBook(Book bookToReturn) throws RemoteException, ISBNNotFoundException;
}
