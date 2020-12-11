package com.designpatterns.structural.compound;

public class DuckSimulatorForFlocks {

	public static void main(String[] args) {
		AbstractDuckFactory duckFactory = new DuckFactory();
		
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redHeadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		
		Flock mainFlock = new Flock();
		mainFlock.add(mallardDuck);
		mainFlock.add(redHeadDuck);
		mainFlock.add(duckCall);
		mainFlock.add(rubberDuck);
		
		Flock mallardDuckFlock = new Flock();
		Quackable mallardDuck1 = duckFactory.createMallardDuck();
		Quackable mallardDuck2 = duckFactory.createMallardDuck();
		Quackable mallardDuck3 = duckFactory.createMallardDuck();
		
		mallardDuckFlock.add(mallardDuck1);
		mallardDuckFlock.add(mallardDuck2);
		mallardDuckFlock.add(mallardDuck3);
		
		mainFlock.add(mallardDuckFlock);
		
		System.out.println("Iterating main flock");
		mainFlock.quack();
		
		System.out.println("Iterating Mallard Duck Flock");
		mallardDuckFlock.quack();
	}

}
