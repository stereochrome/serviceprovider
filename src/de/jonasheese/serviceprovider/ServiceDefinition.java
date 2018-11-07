package de.jonasheese.serviceprovider;

import java.util.prefs.Preferences;

/**
 * Definiert einen Service welcher beim ServiceProvider angemeldet werden kann.
 * 
 * @author jonas
 *
 */
public class ServiceDefinition {

	private Class<Service> serviceClass;
	private Preferences preferences;
	
	public ServiceDefinition(String string, Preferences preferences) throws ServiceException
	{
		try {
			this.serviceClass = (Class<Service>) Class.forName( string );
		} catch (ClassNotFoundException e) {
			throw new ServiceException( e );
		}
		
		this.preferences = preferences;
	}

	public Class<Service> getServiceClass() {
		return serviceClass;
	}

	public Preferences getPreferences() {
		return preferences;
	}

	public boolean isAutoStarted() {
		
		return preferences.getBoolean( "autostart", false );
		
	}
}
