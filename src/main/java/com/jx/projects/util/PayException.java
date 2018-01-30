package com.jx.projects.util;

public class PayException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PayException() {
		super();
	}

	public PayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PayException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PayException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PayException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
