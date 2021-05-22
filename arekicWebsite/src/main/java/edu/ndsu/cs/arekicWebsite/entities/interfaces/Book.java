package edu.ndsu.cs.arekicWebsite.entities.interfaces;

import java.util.Date;

public interface Book {

	public Integer getPK();
	
	public String getTitle();
	
	public int getNumWords();
	
	public Date getReleaseDate();
	
	public Genre getGenre();
	
	public String getAuthor();
	
	public String getPublisher();
	
	//public void setPK(int PK);
	
	public void setTitle(String title);
	
	public void setNumWords(int numWords);
	
	public void setReleaseDate(Date releaseDate);
	
	public void setGenre(Genre genre);
	
	public void setAuthor(String author);
	
	public void setPublisher(String publisher);
}
