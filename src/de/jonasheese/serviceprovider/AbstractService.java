package de.jonasheese.serviceprovider;

import java.util.prefs.Preferences;

/**
 * Abstrakte Basisklasse für einen Service.
 * 
 * Dient zweierlei zwecken: Kann dafür sorgen, dass ein definierter Konstruktor bereitgestellt werden muss 
 * und dient im Interface {@link ServiceSupplier} der Möglichkeit dne Typ-Parameter per extends einzuschränken.
 * 
 * @author jonas
 */
public abstract class AbstractService implements Service {

	private Preferences preferences;
	
	public AbstractService( Preferences preferences )
	{
		this.preferences = preferences;
	}
	
	public Preferences getPreferences() {
		return preferences;
	}
}
