package de.jonasheese.serviceprovider;

import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class ServiceProvider {

	private Map<String, Service> runningServices;
	private Map<String, ServiceDefinition> definedServices;
	
	private static ServiceProvider serviceProvider = new ServiceProvider();
	
	protected ServiceProvider() 
	{
		runningServices = new HashMap<String, Service>();
		definedServices = new HashMap<String, ServiceDefinition>();
	}
	
	public static void defineService(String name, ServiceDefinition definition) throws ServiceException
	{
		serviceProvider._defineService( name, definition );
	}
	
	private void _defineService( String name, ServiceDefinition definition ) throws ServiceException
	{
		definedServices.put(name,  definition);
		
		if( definition.isAutoStarted() )
		{
			getService( name );
		}
	}
	
	public static Service getService( String serviceName ) throws ServiceException
	{
		return serviceProvider._getService(serviceName);
	}
	
	private Service _getService( String serviceName ) throws ServiceException {

		if( runningServices.containsKey( serviceName ) )
		{
			return runningServices.get( serviceName );
		}
		
		Service startedService = startService( serviceName );
		
		runningServices.put( serviceName, startedService );
		
		return startedService;
	}

	

	protected Service startService(String serviceName) throws ServiceException {
		
		ServiceDefinition definition = definedServices.get( serviceName );
		
		if( definition == null )
		{
			throw new ServiceNotFoundException( "Service `" + serviceName + "` was not found." );
		}
		
		try {
			return (Service) definition.getServiceClass().getConstructor( Preferences.class ).newInstance( definition.getPreferences() );
		}
		catch( NoSuchMethodException e )
		{
			throw new ServiceException( "Service " + serviceName + " could not be instantiated: no constructor was found.", e);
		} catch (Exception e) {
			throw new ServiceException( "Service " + serviceName + " could not be instantiated:", e);
		}
		
	}
	
}
