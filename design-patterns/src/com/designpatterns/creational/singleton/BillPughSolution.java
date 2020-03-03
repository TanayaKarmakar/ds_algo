package com.designpatterns.creational.singleton;

//one of the best approach
// thread safe
// lazy initialization
// but can be hackable by reflection and serialization
public class BillPughSolution {
	
	private BillPughSolution() {
		
	}
	
	private static class BillPughSolutionHolder {
		public static final BillPughSolution instance = new BillPughSolution();
	}
	
	public static BillPughSolution getInstance() {
		return BillPughSolutionHolder.instance;
	}

}
