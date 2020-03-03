package com.designpatterns.creational.singleton;

//not thread safe though
public class EagerInitialization {
	private static final EagerInitialization instance = new EagerInitialization();

	private EagerInitialization() {

	}

	public static EagerInitialization getInstance() {
		return instance;
	}

}
