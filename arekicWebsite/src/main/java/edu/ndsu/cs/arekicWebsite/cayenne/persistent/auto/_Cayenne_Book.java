package edu.ndsu.cs.arekicWebsite.cayenne.persistent.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

import edu.ndsu.cs.arekicWebsite.entities.interfaces.Genre;

/**
 * Class _Cayenne_Book was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Cayenne_Book extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String PK_PK_COLUMN = "PK";

    public static final Property<String> AUTHOR = Property.create("author", String.class);
    public static final Property<Genre> GENRE = Property.create("genre", Genre.class);
    public static final Property<Integer> NUM_WORDS = Property.create("numWords", Integer.class);
    public static final Property<String> PUBLISHER = Property.create("publisher", String.class);
    public static final Property<Date> RELEASE_DATE = Property.create("releaseDate", Date.class);
    public static final Property<String> TITLE = Property.create("title", String.class);

    protected String author;
    protected Genre genre;
    protected Integer numWords;
    protected String publisher;
    protected Date releaseDate;
    protected String title;


    public void setAuthor(String author) {
        beforePropertyWrite("author", this.author, author);
        this.author = author;
    }

    public String getAuthor() {
        beforePropertyRead("author");
        return this.author;
    }

    public void setGenre(Genre genre) {
        beforePropertyWrite("genre", this.genre, genre);
        this.genre = genre;
    }

    public Genre getGenre() {
        beforePropertyRead("genre");
        return this.genre;
    }

    public void setNumWords(int numWords) {
        beforePropertyWrite("numWords", this.numWords, numWords);
        this.numWords = numWords;
    }

    public int getNumWords() {
        beforePropertyRead("numWords");
        if(this.numWords == null) {
            return 0;
        }
        return this.numWords;
    }

    public void setPublisher(String publisher) {
        beforePropertyWrite("publisher", this.publisher, publisher);
        this.publisher = publisher;
    }

    public String getPublisher() {
        beforePropertyRead("publisher");
        return this.publisher;
    }

    public void setReleaseDate(Date releaseDate) {
        beforePropertyWrite("releaseDate", this.releaseDate, releaseDate);
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() {
        beforePropertyRead("releaseDate");
        return this.releaseDate;
    }

    public void setTitle(String title) {
        beforePropertyWrite("title", this.title, title);
        this.title = title;
    }

    public String getTitle() {
        beforePropertyRead("title");
        return this.title;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "author":
                return this.author;
            case "genre":
                return this.genre;
            case "numWords":
                return this.numWords;
            case "publisher":
                return this.publisher;
            case "releaseDate":
                return this.releaseDate;
            case "title":
                return this.title;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "author":
                this.author = (String)val;
                break;
            case "genre":
                this.genre = (Genre)val;
                break;
            case "numWords":
                this.numWords = (Integer)val;
                break;
            case "publisher":
                this.publisher = (String)val;
                break;
            case "releaseDate":
                this.releaseDate = (Date)val;
                break;
            case "title":
                this.title = (String)val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.author);
        out.writeObject(this.genre);
        out.writeObject(this.numWords);
        out.writeObject(this.publisher);
        out.writeObject(this.releaseDate);
        out.writeObject(this.title);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.author = (String)in.readObject();
        this.genre = (Genre)in.readObject();
        this.numWords = (Integer)in.readObject();
        this.publisher = (String)in.readObject();
        this.releaseDate = (Date)in.readObject();
        this.title = (String)in.readObject();
    }

}
