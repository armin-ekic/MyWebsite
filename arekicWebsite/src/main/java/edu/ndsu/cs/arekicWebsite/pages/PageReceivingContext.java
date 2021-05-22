package edu.ndsu.cs.arekicWebsite.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;
import edu.ndsu.cs.arekicWebsite.services.BookDatabaseService;

public class PageReceivingContext {

	@Inject
	private BookDatabaseService databaseService; 
	@Property
	private int PK; // This will store the primary key 
	@Property
	private Book book; 

	void onActivate(int PK) { // Method to receive activation context 
		this.PK = PK; 
	}

	int onPassivate() { // Method to return activation context 
		return PK;
	}

	void setupRender() {
		book = databaseService.getBook(PK); 
	}

}
