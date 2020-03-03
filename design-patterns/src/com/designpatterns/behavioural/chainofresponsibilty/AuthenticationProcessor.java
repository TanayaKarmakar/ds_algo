package com.designpatterns.behavioural.chainofresponsibilty;

public abstract class AuthenticationProcessor {
	protected AuthenticationProcessor nextProcessor;
	
	public AuthenticationProcessor(AuthenticationProcessor nextProcessor) {
		this.nextProcessor = nextProcessor;
	}
	
	//child classes should 
	public abstract boolean isAuthorized(AuthenticationProvider provider);

}
