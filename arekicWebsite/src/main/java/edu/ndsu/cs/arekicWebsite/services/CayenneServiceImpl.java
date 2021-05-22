package edu.ndsu.cs.arekicWebsite.services;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;

public class CayenneServiceImpl implements CayenneService
{
	private ServerRuntime cayenneRuntime; 
	
	public CayenneServiceImpl() {
		cayenneRuntime = ServerRuntime.builder().addConfig("cayenne-arekicWebsite.xml").build();
	}
	
	@Override
	public ObjectContext newContext() {
		return cayenneRuntime.newContext();
	}
}

