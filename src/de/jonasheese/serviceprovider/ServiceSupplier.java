package de.jonasheese.serviceprovider;

/**
 * Beschreibt eine Klasse welche einen einzelnen Service nutzt und macht diesen mit dem gewünschten typ zugänglich.
 * @author jonas
 *
 * @param <T>
 */
public interface ServiceSupplier<T extends AbstractService> {

	/**
	 * Liefert einen Service vom Typ T mit dem Namem {@link getServiceName()}
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public default T getService() throws ServiceException {
		return (T) ServiceProvider.getService( getServiceName() );
	}
	
	/**
	 * Gibt den Namen des Services vom Typ T wie er im {@link ServiceProvider} definiert ist, zurück.
	 * 
	 * @return
	 */
	public String getServiceName();
	
}
