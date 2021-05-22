package edu.ndsu.cs.arekicWebsite.pages;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.tynamo.security.services.SecurityService;

import edu.ndsu.cs.arekicWebsite.entities.interfaces.UserAccount;
import edu.ndsu.cs.arekicWebsite.services.UserAccountService;

@RequiresAuthentication
public class MyAccount 
{
	@Inject
	SecurityService securityService;
	
	@Inject
	UserAccountService userAccountService;
	
	@Property
	@Persist
	UserAccount userAccount;
	
	void setupRender()
	{
		String username = securityService.getSubject().getPrincipal().toString();
		userAccount = userAccountService.getUserAccountByUserID(username);
	}
}

