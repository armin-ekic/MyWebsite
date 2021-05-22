package edu.ndsu.cs.arekicWebsite.pages;

import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import edu.ndsu.cs.arekicWebsite.services.BookDatabaseService;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;

public class ListBooks {

	@Inject
	private BookDatabaseService databaseService;
	@Property
	private List<Book> books; // For the source in a grid
	@Property
	private Book book; // For the row in a grid

	void setupRender() { //Method automatically called when page is loaded
		books = databaseService.getAllBooks(); }
	
	void onDelete(int PK) { //Method automatically called when page is loaded
		databaseService.deleteBook(PK); }
}
