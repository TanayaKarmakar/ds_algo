package com.designpatterns.structural.compound;

public class DuckCall implements Quackable {

	@Override
	public void quack() {
		System.out.println("Kwak");
	}

}
