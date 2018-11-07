package de.jonasheese.serviceprovider.example;

import java.util.prefs.Preferences;

import de.jonasheese.serviceprovider.ServiceDefinition;
import de.jonasheese.serviceprovider.ServiceException;
import de.jonasheese.serviceprovider.ServiceProvider;
import de.jonasheese.serviceprovider.ServiceSupplier;

public class Example implements ServiceSupplier<ExampleService>
{

	public static void main(String[] args) throws ServiceException {
	
		ServiceProvider.defineService( ExampleService.SERVICE_EXAMPLE, 
				new ServiceDefinition("de.jonasheese.serviceprovider.example.ExampleService.class", Preferences.userRoot().node("service.example") ) );
		
	
		Example ex = new Example();
		ex.run();
	
	
	
	}

	public void run() throws ServiceException {
		
		ExampleService s = getService();
		
		s.increase();
		s.increase();
		
		ExampleService s2 = (ExampleService) ServiceProvider.getService( ExampleService.SERVICE_EXAMPLE );
		
		s2.increase();
		s2.increase();
		
		System.out.println( s.read() );
	}


	@Override
	public String getServiceName() {
		return ExampleService.SERVICE_EXAMPLE;
	}

}
