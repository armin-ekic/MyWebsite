package edu.ndsu.cs.arekicWebsite.entities.implementations;

import java.util.Date;

import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Genre;
import org.apache.tapestry5.beaneditor.Validate;

public class BookImpl implements Book{
	
	private int PK;
	
	private String title;
	
	@Validate("required, regexp=^\\\\d{5}(-\\\\d{4})?$")
	private int numWords;
	
	private Date releaseDate;
	
	private Genre genre;
	
	@Validate("required, maxlength=40")
	private String author;
	
	private String publisher;
	
	public BookImpl() {
		
	}
	
	public BookImpl(int PK) {
		this.PK = PK;
	}

	public BookImpl(int PK, String title, int numWords, Date releaseDate, Genre genre, String author, String publisher) {
		this.PK = PK;
		this.title = title;
		this.numWords = numWords;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.author = author;
		this.publisher = publisher;
	}

	@Override
	public Integer getPK() {
		return PK;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getNumWords() {
		return numWords;
	}

	@Override
	public Date getReleaseDate() {
		return releaseDate;
	}

	@Override
	public Genre getGenre() {
		return genre;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public String getPublisher() {
		return publisher;
	}

	//@Override
	//public void setPK(int PK) {
		//this.PK = PK;
	//}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setNumWords(int numWords) {
		this.numWords = numWords;
	}

	@Override
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}

//hello
