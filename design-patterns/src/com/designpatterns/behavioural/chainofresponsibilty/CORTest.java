package com.designpatterns.behavioural.chainofresponsibilty;

public class CORTest {
	
	private static AuthenticationProcessor getChainOfProcessors() {
		OAuthAuthenticationProcessor oAuthProcessor = 
				new OAuthAuthenticationProcessor(null);
		UserNamePasswordAuthenticationProcessor userNamePasswordProcessor =
				new UserNamePasswordAuthenticationProcessor(oAuthProcessor);
		return userNamePasswordProcessor;
		
	}

	public static void main(String[] args) {
		//Test happy path
		AuthenticationProcessor processor = getChainOfProcessors();
		boolean isHandled = processor.isAuthorized(new OAuthAuthenticationProvider());
		
		System.out.println("IsHandled  - " + isHandled);
		
		//unhappy path where request will be dropped
		// because correct provider not found in the chain
		isHandled = processor.isAuthorized(new SamlAuthenticationProvider());
		
		System.out.println("IsHandled - " + isHandled);

	}

}
