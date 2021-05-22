package edu.ndsu.cs.arekicWebsite.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.ioc.annotations.Inject;

import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;
import edu.ndsu.cs.arekicWebsite.services.BookDatabaseService;

public class BookUpdate {
	// The activation context

    @Property
    private int PK;

    @Property
    private Book book;

    @InjectPage
    private ListBooks indexPage;

    // Generally useful bits and pieces

    @InjectComponent
    private BeanEditForm form;

    @Inject
    private BookDatabaseService databaseService;

    void onActivate(int PK) {
        this.PK = PK;
    }

    int onPassivate() {
        return PK;
    }

    void setupRender() {
        if (form.isValid()) {
            book = databaseService.getBook(PK);
        }

    }

    void onPrepareForSubmit() {
        book = databaseService.getBook(PK);

        if (book == null) {
            form.recordError("Person has been deleted by another process.");
        }
    }

    Object onCanceled() {
        return indexPage;
    }

    void onValidateFromForm() {

        if (book.getTitle() == null) {
            form.recordError("Title must not be empty.");
        }

        if (form.getHasErrors()) {
            return;
        }
        
    }

    Object onSuccess() {
    	databaseService.updateBook(book);
        return indexPage;
    }
}
