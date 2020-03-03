package com.designpatterns.creational.singleton;

public class StaticBlockInitialization {
	private static StaticBlockInitialization instance;

	static {
		try {
			instance = new StaticBlockInitialization();
		} catch (Exception ex) {
			System.out.println("An error occurred while creating instance");
		}
	}

	private StaticBlockInitialization() {

	}

	public static StaticBlockInitialization getInstance() {
		return instance;
	}

}
