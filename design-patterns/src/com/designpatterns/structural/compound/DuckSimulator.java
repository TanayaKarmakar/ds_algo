package com.designpatterns.structural.compound;

public class DuckSimulator {

	public static void main(String[] args) {
		System.out.println("Simple Duck Creation");
		simpleDuckCreation();
		
		System.out.println("Duck Creation with Quack Counter");
		duckCreationWithQuackCounter();
		
		System.out.println("Duck creation with abstract factory");
		duckCreationWithFactoryPattern();
	}
	
	private static void duckCreationWithFactoryPattern() {
		System.out.println("Simple duck creation");
		AbstractDuckFactory duckFactory = new DuckFactory();
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redHeadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		
		simulate(mallardDuck);
		simulate(redHeadDuck);
		simulate(rubberDuck);
		simulate(duckCall);
		
		System.out.println("Duck Creation with QuackCounter");
		AbstractDuckFactory duckCounterFactory = new CounterDuckFactory();
		Quackable mallardDuckCounter = duckCounterFactory.createMallardDuck();
		Quackable redHeadDuckCounter = duckCounterFactory.createRedheadDuck();
		Quackable duckCallDuckCounter = duckCounterFactory.createDuckCall();
		Quackable rubberDuckDuckCounter = duckCounterFactory.createRubberDuck();
		
		simulate(mallardDuckCounter);
		simulate(redHeadDuckCounter);
		simulate(duckCallDuckCounter);
		simulate(rubberDuckDuckCounter);
		
		System.out.println("Total Number of Quacks " + QuackCounter.getCounter());
	}
	
	//decorator pattern
	private static void duckCreationWithQuackCounter() {
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable redHeadDuck = new QuackCounter(new RedheadDuck());
		Quackable rubberDuck = new QuackCounter(new RubberDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		simulate(mallardDuck);
		simulate(redHeadDuck);
		simulate(rubberDuck);
		simulate(duckCall);
		simulate(gooseDuck);
		
		System.out.println("Total number of quacks " + QuackCounter.getCounter());
	}
	
	private static void simpleDuckCreation() {
		Quackable mallardDuck = new MallardDuck();
		Quackable redHeadDuck = new RedheadDuck();
		Quackable rubberDuck= new RubberDuck();
		Quackable duckCall = new DuckCall();
		
		//adapter pattern
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		simulate(mallardDuck);
		simulate(redHeadDuck);
		simulate(rubberDuck);
		simulate(duckCall);
		simulate(gooseDuck);
	}
	
	private static void simulate(Quackable quackable) {
		quackable.quack();
	}

}
