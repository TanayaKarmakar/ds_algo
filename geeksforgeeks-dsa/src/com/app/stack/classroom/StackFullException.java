package com.app.stack.classroom;

public class StackFullException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	public StackFullException(String message) {
		this.message = message;
	}

}
