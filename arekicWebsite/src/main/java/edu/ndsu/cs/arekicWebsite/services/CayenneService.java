package edu.ndsu.cs.arekicWebsite.services;

import org.apache.cayenne.ObjectContext;

public interface CayenneService 
{
	ObjectContext newContext();
}

