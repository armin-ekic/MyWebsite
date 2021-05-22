package edu.ndsu.cs.arekicWebsite.cayenne.persistent;

import edu.ndsu.cs.arekicWebsite.cayenne.persistent.auto._Cayenne_Book;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;

public class Cayenne_Book extends _Cayenne_Book implements Book {

    private static final long serialVersionUID = 1L;
    
    public Integer getPK()
    {
    	if(getObjectId() != null && !getObjectId().isTemporary())
    	{
    		return (Integer) getObjectId().getIdSnapshot().get(PK_PK_COLUMN);
    	}
    	return null; 
    }

}
