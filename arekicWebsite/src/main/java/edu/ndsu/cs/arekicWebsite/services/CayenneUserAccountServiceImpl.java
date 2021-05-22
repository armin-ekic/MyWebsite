package edu.ndsu.cs.arekicWebsite.services;

import org.apache.cayenne.CayenneRuntimeException;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import edu.ndsu.cs.arekicWebsite.cayenne.persistent.Cayenne_UserAccount;
import edu.ndsu.cs.arekicWebsite.entities.interfaces.UserAccount;

public class CayenneUserAccountServiceImpl implements UserAccountService {

	private CayenneService 	cayenneSerivce;
	
	public CayenneUserAccountServiceImpl(CayenneService cayenneService) 
{
		this.cayenneSerivce = cayenneService;
	}

	@Override
	public UserAccount getUserAccountByUserID(String userID) 
{
		ObjectContext context = cayenneSerivce.newContext();
		try {
			// Query to select a UserAccount where the UserID matches the parameter userID
			UserAccount userAccount = ObjectSelect.query(Cayenne_UserAccount.class)
				.where(Cayenne_UserAccount.USER_ID.eq(userID)).selectOne(context);
			return userAccount;
		}
		catch (CayenneRuntimeException e) {
			// If something has gone wrong we won’t get a UserAccount so return null
			return null; 
		}
	}

	@Override
	public UserAccount createNewUserAccount() 
	{
		ObjectContext context = cayenneSerivce.newContext();	
		Cayenne_UserAccount userAccount = context.newObject(Cayenne_UserAccount.class);
		// Generate a random salt for any new users
		userAccount.setPasswordSalt(new SecureRandomNumberGenerator().nextBytes().toHex());
		return userAccount;
	}

	@Override
	public void updateUserAccount(UserAccount userAccount) 
{
		((Cayenne_UserAccount)userAccount).getObjectContext().commitChanges();
	}
}

