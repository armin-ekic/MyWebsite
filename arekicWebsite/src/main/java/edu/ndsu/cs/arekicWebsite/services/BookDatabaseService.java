package edu.ndsu.cs.arekicWebsite.services;

import java.util.List;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;

public interface BookDatabaseService {

	List<Book> getAllBooks();
	Book getBook(int PK);
	void updateBook(Book book);
	void deleteBook(int PK);
	Book getNewBook(Book book);	
}
