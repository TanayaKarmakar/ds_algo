package com.app.questions.stack;

import java.util.Stack;

class StackNode {
	int value;
	int count;
	
	public StackNode(int value, int count) {
		this.value = value;
		this.count = count;
	}
}

class StockSpanner {
	Stack<StackNode> stack1;

	public StockSpanner() {
		stack1 = new Stack<>();
	}

	public int next(int price) {
		int count = 1;
		while(!stack1.isEmpty() && stack1.peek().value <= price) {
			StackNode sNode = stack1.pop();
			count += sNode.count;
		}
		
		stack1.push(new StackNode(price, count));
		return count;
	}
}

public class OnlineStockSpannerLeetcode901 {

	public static void main(String[] args) {
		StockSpanner stockSpanner = new StockSpanner();
		int[] nums = { 100, 80, 60, 70, 60, 75, 85 };
		
		for(int el: nums) {
			System.out.print(stockSpanner.next(el) + " ");
		}
		
		System.out.println();

	}

}
