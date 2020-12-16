package com.designpatterns.structural.compound;

public class DuckCall implements Quackable {

	@Override
	public void quack() {
		System.out.println("Kwak");
	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

}
