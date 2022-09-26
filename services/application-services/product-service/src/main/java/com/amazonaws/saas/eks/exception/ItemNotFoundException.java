/*
infrateam and application team
 */
package com.amazonaws.saas.eks.exception;

public class ItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8915422612903998859L;

	public ItemNotFoundException() {
		super();
	}

	public ItemNotFoundException(final String message) {
		super(message);
	}

	public ItemNotFoundException(final Throwable cause) {
		super(cause);
	}

	public ItemNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

}