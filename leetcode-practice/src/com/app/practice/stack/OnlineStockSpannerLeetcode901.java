package com.app.practice.stack;

import java.util.Stack;

class StockElement {
	int stockValue;
	int spanValue;

	public StockElement(int stockValue, int spanValue) {
		this.stockValue = stockValue;
		this.spanValue = spanValue;
	}
}

class StockSpanner {
	Stack<StockElement> stack;

	public StockSpanner() {
		stack = new Stack<>();
	}

	public int next(int price) {
		int val = 1;
		if (stack.isEmpty() || stack.peek().stockValue > price) {
			StockElement stock = new StockElement(price, val);
			stack.push(stock);
		} else {
			while (!stack.isEmpty() && stack.peek().stockValue <= price) {
				StockElement stock = stack.pop();
				val += stock.spanValue;
			}
			StockElement stock = new StockElement(price, val);
			stack.push(stock);
		}
		return val;
	}
}

public class OnlineStockSpannerLeetcode901 {

	public static void main(String[] args) {
		StockSpanner obj = new StockSpanner();
		System.out.println(obj.next(100));
		System.out.println(obj.next(80));
		System.out.println(obj.next(60));
		System.out.println(obj.next(70));
		System.out.println(obj.next(60));
		System.out.println(obj.next(75));
		System.out.println(obj.next(85));
	}

}
