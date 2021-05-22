package edu.ndsu.cs.arekicWebsite.pages;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.tynamo.security.services.SecurityService;

public class Logout 
{
	@Inject
	private SecurityService securityService;
	
	Object onActivate()
	{
		securityService.getSubject().logout();
		return Index.class;
	}
}

