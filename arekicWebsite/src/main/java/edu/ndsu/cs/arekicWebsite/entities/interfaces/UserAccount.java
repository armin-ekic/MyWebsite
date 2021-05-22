package edu.ndsu.cs.arekicWebsite.entities.interfaces;

import java.util.List;

public interface UserAccount {
	
	public Integer getPK();
	
	public String getName();
	public void setName(String name);
		
	public String getUserID();
	public void setUserID(String userID);
		
	public String getEmailAddress();
	public void setEmailAddress(String emailAddress);
		
	public String getPasswordHash();
	public void setPassword(String password);
		
	public String getPasswordSalt();
	public void setPasswordSalt(String passwordSalt);
		
	public void addRole(String role);
	public void deleteRole(String role);	
	public List<String> getRoles(); 
}
