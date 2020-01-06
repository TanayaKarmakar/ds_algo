package com.app.stack.classroom;

public class TwoStacksTest {

	public static void main(String[] args) {
		TwoStacks twoStacks = new TwoStacks();
		int stack1StartEl = 1;
		int stack2StartEl = 30;
		for (int i = 0; i < 15; i++) {
			twoStacks.push1(stack1StartEl);
			twoStacks.push2(stack2StartEl);
			stack1StartEl++;
			stack2StartEl--;
		}
		
		System.out.println("Processing stacks");
		
		while(!twoStacks.isEmpty1()) {
			System.out.println(twoStacks.pop1());
		}
		
		while(!twoStacks.isEmpty2()) {
			System.out.println(twoStacks.pop2());
		}
		
//		twoStacks.pop1();
//		twoStacks.pop2();

	}

}
