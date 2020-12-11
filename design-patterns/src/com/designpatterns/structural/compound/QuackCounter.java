package com.designpatterns.structural.compound;

public class QuackCounter implements Quackable {
	private Quackable quackable;
	private static int numQuacks;

	public QuackCounter(Quackable quackable) {
		this.quackable = quackable;
	}

	@Override
	public void quack() {
		quackable.quack();
		numQuacks++;
	}

	public static int getCounter() {
		return numQuacks;
	}
}
