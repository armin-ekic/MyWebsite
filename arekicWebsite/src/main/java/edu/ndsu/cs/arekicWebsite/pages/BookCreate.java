package edu.ndsu.cs.arekicWebsite.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.ioc.annotations.Inject;

import edu.ndsu.cs.arekicWebsite.entities.implementations.BookImpl;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;
import edu.ndsu.cs.arekicWebsite.services.BookDatabaseService;

public class BookCreate {

	   @Inject
	    private BookDatabaseService databaseService; 
	  
	    @Property
	    private int PK;

	    @Property
	    private Book book;

	    @InjectComponent
	    private BeanEditForm form;
	    
	    @InjectPage
	    private ListBooks indexpage;

	    void onActivate(int PK) { 
	        this.PK = PK; 
	    }

	    int onPassivate() { 
	        return PK;
	    }

	    void setupRender() {
	        book = databaseService.getBook(PK); 
	    }

	    void onPrepareForRender() throws Exception {

	        if (form.isValid()) {
	            book = new BookImpl();
	        }
	    }

	    void onPrepareForSubmit() throws Exception {
	        book = new BookImpl();
	    }


	    Object onSuccess() {
	        book = databaseService.getNewBook(book);
	        return indexpage;
	    }
}
