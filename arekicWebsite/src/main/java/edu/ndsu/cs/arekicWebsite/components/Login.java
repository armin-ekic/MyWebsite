package edu.ndsu.cs.arekicWebsite.components;

import org.apache.shiro.authz.annotation.RequiresAuthentication;

import edu.ndsu.cs.arekicWebsite.pages.Index;

@RequiresAuthentication
public class Login 
{  
	Object onActivate()
	{
		return Index.class;
	}
}

