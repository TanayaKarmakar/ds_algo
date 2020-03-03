package com.designpatterns.behavioural.chainofresponsibilty;

public class UserNamePasswordAuthenticationProcessor extends AuthenticationProcessor {

	public UserNamePasswordAuthenticationProcessor(AuthenticationProcessor nextProcessor) {
		super(nextProcessor);

	}

	@Override
	public boolean isAuthorized(AuthenticationProvider provider) {
		if (provider instanceof UsernamePasswordAuthenticationProvider)
			return Boolean.TRUE;
		else if (nextProcessor != null) {
			return nextProcessor.isAuthorized(provider);
		} else {
			return Boolean.FALSE;
		}
	}
}
