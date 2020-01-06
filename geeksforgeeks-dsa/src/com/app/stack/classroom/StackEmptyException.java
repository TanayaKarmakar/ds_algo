package com.app.stack.classroom;

public class StackEmptyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public StackEmptyException(String message) {
		this.message = message;
	}

}
