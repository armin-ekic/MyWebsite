package edu.ndsu.cs.arekicWebsite.pages;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;
import edu.ndsu.cs.arekicWebsite.services.BookDatabaseService;
import edu.ndsu.cs.arekicWebsite.services.CayenneBookDatabaseServiceImpl;

public class BookReview {

	// The activation context

    @Property
    private int PK;
    
    @Inject
    private BookDatabaseService databaseService;

    // Screen fields

    @Property
    private Book book;

    // The code

    void onActivate(int PK) {
        this.PK = PK;
    }

    int onPassivate() {
        return PK;
    }

    void setupRender() { //Method automatically called when page is loaded
		book = databaseService.getBook(PK); }
}
