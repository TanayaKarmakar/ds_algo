package com.designpatterns.structural.compound;

public class GooseAdapter implements Quackable {
	public Goose goose;
	
	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}

	@Override
	public void quack() {
		goose.honk();
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
