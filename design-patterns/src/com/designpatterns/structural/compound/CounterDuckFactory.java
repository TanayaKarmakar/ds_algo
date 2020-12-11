package com.designpatterns.structural.compound;

public class CounterDuckFactory extends AbstractDuckFactory {

	@Override
	public Quackable createMallardDuck() {
		return new QuackCounter(new MallardDuck());
	}

	@Override
	public Quackable createRedheadDuck() {
		return new QuackCounter(new RedheadDuck());
	}

	@Override
	public Quackable createRubberDuck() {
		return new QuackCounter(new RubberDuck());
	}

	@Override
	public Quackable createDuckCall() {
		return new QuackCounter(new DuckCall());
	}

}
