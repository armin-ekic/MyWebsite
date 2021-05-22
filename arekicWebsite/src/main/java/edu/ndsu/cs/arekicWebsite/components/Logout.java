package edu.ndsu.cs.arekicWebsite.components;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.tynamo.security.services.SecurityService;

import edu.ndsu.cs.arekicWebsite.pages.Index;

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

