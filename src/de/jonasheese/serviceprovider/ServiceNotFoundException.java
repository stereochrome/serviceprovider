package de.jonasheese.serviceprovider;

public class ServiceNotFoundException extends ServiceException {

	private static final long serialVersionUID = -6078433628409495170L;

	public ServiceNotFoundException() {
		super();
	}

	public ServiceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceNotFoundException(String message) {
		super(message);
	}

	public ServiceNotFoundException(Throwable cause) {
		super(cause);
	}

}
