package edu.ndsu.cs.arekicWebsite.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Genre;
import edu.ndsu.cs.arekicWebsite.entities.implementations.BookImpl;

public class MockDatabase implements BookDatabaseService{
	
	HashMap<Integer, Book> BookHash = new HashMap();
	
	Genre Fantasy = Genre.Fantasy;
	Genre Fiction = Genre.Fiction;
	Genre NonFiction = Genre.NonFiction;
	Genre Horror = Genre.Horror;
	Genre SciFi = Genre.SciFi;
	Genre Romance = Genre.Romance;
	
	int nextPK;

	public MockDatabase() {
		
		Date MDRD = new Date(-49, 10, 18);
		Date TKAMRD = new Date(60, 7, 11);
		Date MiseryRD = new Date(90, 11, 30);
		Date AGOTRD = new Date(90, 7, 29);
		Date TGRD = new Date(82, 6, 10);
		Date NFTURD = new Date(-36, 7, 1);
		Date TPRD = new Date(47, 6, 1);
		Date ASORD = new Date(68, 6, 12);
		Date EragonRD = new Date(102, 8, 26);
		Date MagykRD = new Date(105, 3, 15);

		Book MobyDick = (Book) new BookImpl(1, "Moby Dick", 206052, MDRD, Fiction, "Herman Melville", "Richard Bentley");
		Book ToKillAMockingbird = (Book) new BookImpl(2, "To Kill a Mockingbird", 100388, TKAMRD, NonFiction, "Harper Lee", "J. B. Lippincott & Co.");
		Book Misery = (Book) new BookImpl(3, "Misery", 106140, MiseryRD, Horror, "Stephen King", "Viking Press");
		Book AGameOfThrones = (Book) new BookImpl(4, "A Game of Thrones", 292727, AGOTRD, Fantasy, "George RR Martin", "Bantam Spectra (US)");
		Book TheGunslinger = (Book) new BookImpl(5, "The Gunslinger", 55376, TGRD, Fantasy, "Stephen King", "Donald M. Grant");
		Book NotesFromTheUnderground = (Book) new BookImpl(6, "Notes From the Underground", 43935, NFTURD, Fiction, "Fyodor Dostoevsky", "Epoch");
		Book ThePlague = (Book) new BookImpl(7, "The Plague", 94540, TPRD, Fiction, "Albert Camus", "Gallimard (France)");
		Book ASpaceOdyssey = (Book) new BookImpl(8, "2001 A Space Odyssey", 58290, ASORD, SciFi, "Arthur C Clarke", "New American Library (US)");
		Book Eragon = (Book) new BookImpl(9, "Eragon", 157220, EragonRD, Fantasy, "Christopher Paolini", "Knopf");
		Book Magyk = (Book) new BookImpl(10, "Magyk", 112921, MagykRD, Fantasy, "Angie Sage", "Bloomsbury Publishing");
		
		BookHash.put(1, MobyDick);
		BookHash.put(2, ToKillAMockingbird);
		BookHash.put(3, Misery);
		BookHash.put(4, AGameOfThrones);
		BookHash.put(5, TheGunslinger);
		BookHash.put(6, NotesFromTheUnderground);
		BookHash.put(7, ThePlague);
		BookHash.put(8, ASpaceOdyssey);
		BookHash.put(9, Eragon);
		BookHash.put(10, Magyk);
		
		nextPK = 10;
	}
	
	@Override
	public List<Book> getAllBooks() {
		Collection BookColl = BookHash.values();
		List<Book> BookList = new ArrayList<Book>(BookColl);
		return BookList;
	}

	@Override
	public Book getBook(int PK) {
		return BookHash.get(PK);
	}

	@Override
	public void updateBook(Book book) {
		BookHash.put(book.getPK(), book);
	}

	@Override
	public void deleteBook(int PK) {
		BookHash.remove(PK);
	}

	@Override
	public Book getNewBook(Book book) {
		nextPK++;
		//book.setPK(nextPK);
		BookHash.put(nextPK, book);
		return book;
	}
}
