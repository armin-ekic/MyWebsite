package edu.ndsu.cs.arekicWebsite.services;

import edu.ndsu.cs.arekicWebsite.entities.interfaces.UserAccount;

public interface UserAccountService 
{
	UserAccount getUserAccountByUserID(String userID);	
	UserAccount createNewUserAccount();	
	void updateUserAccount(UserAccount userAccount);
}

