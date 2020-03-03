package com.designpatterns.creational.singleton;

//not a thread safe though
public class LazyInitialization {
	private static LazyInitialization instance;
	
	private LazyInitialization() {
		
	}
	
	public static LazyInitialization getInstance() {
		if(instance == null) 
			instance = new LazyInitialization();
		return instance;
	}

}
