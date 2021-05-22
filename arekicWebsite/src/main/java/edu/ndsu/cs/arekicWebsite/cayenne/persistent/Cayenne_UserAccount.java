package edu.ndsu.cs.arekicWebsite.cayenne.persistent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.Sha512Hash;

import edu.ndsu.cs.arekicWebsite.cayenne.persistent.auto._Cayenne_UserAccount;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Book;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.Genre;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.UserAccount;

public class Cayenne_UserAccount extends _Cayenne_UserAccount implements UserAccount{

    private static final long serialVersionUID = 1L;

    public Integer getPK()
    {
    	if(getObjectId() != null && !getObjectId().isTemporary())
    	{
    		return (Integer) getObjectId().getIdSnapshot().get(PK_PK_COLUMN);
    	}
    	return null; 
    }
        
    public void setPassword(String password)
    {
    	if(password != null && !password.isEmpty())
    	{
    		setPasswordHash(new Sha512Hash(password, this.getPasswordSalt()).toHex());
    	}
    }

    public void addRole(String role) 
    {		
    }

    public void deleteRole(String role) 
    {
    }
    	
    public List<String> getRoles()
    {
    	ArrayList<String> roles = new ArrayList<String>();
    	roles.add("Admin");
    		
    	return roles;		
    }
}
