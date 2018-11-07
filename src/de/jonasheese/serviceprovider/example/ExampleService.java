package de.jonasheese.serviceprovider.example;

import java.util.prefs.Preferences;

import de.jonasheese.serviceprovider.AbstractService;
import de.jonasheese.serviceprovider.Service;

public class ExampleService extends AbstractService implements Service
{

	public static final String SERVICE_EXAMPLE = null;

	private int test = 0;
	
	public ExampleService(Preferences preferences) 
	{
		super(preferences);
	}

	@Override
	public String getName() 
	{
		return SERVICE_EXAMPLE;
	}
	
	public void increase() 
	{
		test++;
	}
	
	public int read()
	{
		return test;
	}

}
