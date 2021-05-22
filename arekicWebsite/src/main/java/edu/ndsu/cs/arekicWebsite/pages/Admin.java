package edu.ndsu.cs.arekicWebsite.pages;

import org.apache.shiro.authz.annotation.RequiresRoles;

@RequiresRoles("Admin")
public class Admin 
{
  //username and password are in LocalSecurityRealm.java
}

