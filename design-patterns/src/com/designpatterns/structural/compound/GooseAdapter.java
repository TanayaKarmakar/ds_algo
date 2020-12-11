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
}
