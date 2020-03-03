package com.designpatterns.behavioural.chainofresponsibilty;

public class OAuthAuthenticationProcessor extends AuthenticationProcessor {

	public OAuthAuthenticationProcessor(AuthenticationProcessor nextProcessor) {
		super(nextProcessor);
	}

	@Override
	public boolean isAuthorized(AuthenticationProvider provider) {
		if(provider instanceof OAuthAuthenticationProvider) {
			return Boolean.TRUE;
		} else if(nextProcessor != null) {
			return nextProcessor.isAuthorized(provider);
		} else {
			return Boolean.FALSE;
		}
	}

}
