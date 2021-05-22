package edu.ndsu.cs.arekicWebsite.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;

import edu.ndsu.cs.arekicWebsite.cayenne.persistent.Cayenne_Book;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Genre;

public class CayenneBookDatabaseServiceImpl implements BookDatabaseService{

	private CayenneService cayenneService;
	
	Genre Fiction = Genre.Fiction;

	public CayenneBookDatabaseServiceImpl(CayenneService cayenneService) {
		ObjectContext context = cayenneService.newContext();
		this.cayenneService = cayenneService;
		
		Date MDRD = new Date(-49, 10, 18);
		Book mobyDick = context.newObject(Cayenne_Book.class);
		mobyDick.setTitle("Moby Dick");
		mobyDick.setAuthor("Herman Melville");
		mobyDick.setGenre(Fiction);
		mobyDick.setNumWords(206052);
		mobyDick.setPublisher("Richard Bentley");
		mobyDick.setReleaseDate(MDRD);
		context.commitChanges();
	}

	@Override
	public List<Book> getAllBooks() {
		ObjectContext context = cayenneService.newContext();
		return new ArrayList<Book>(ObjectSelect.query(Cayenne_Book.class).select(context));
	}

	@Override
	public Book getBook(int PK) {
		return (Book) Cayenne.objectForPK(cayenneService.newContext(), Cayenne_Book.class, PK);
	}

	@Override
	public void updateBook(Book entity) {
		((Cayenne_Book)entity).getObjectContext().commitChanges();
	}

	@Override
	public void deleteBook(int PK) {
		ObjectContext context = cayenneService.newContext();
		Cayenne_Book entity = (Cayenne_Book) Cayenne.objectForPK(context, Cayenne_Book.class, PK);
		context.deleteObject(entity);
		context.commitChanges();
	}

	@Override
	public Book getNewBook(Book book) {
		ObjectContext context = cayenneService.newContext();
		Book entity = context.newObject(Cayenne_Book.class);
		entity.setTitle(book.getTitle());
		entity.setAuthor(book.getAuthor());
		entity.setGenre(book.getGenre());
		entity.setNumWords(book.getNumWords());
		entity.setPublisher(book.getPublisher());
		entity.setReleaseDate(book.getReleaseDate());
		context.commitChanges();
		return entity; 
	}
}

