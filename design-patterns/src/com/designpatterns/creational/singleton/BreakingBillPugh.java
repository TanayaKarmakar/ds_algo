package com.designpatterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakingBillPugh {
	private static BillPughSolution instance1 = BillPughSolution.getInstance();
	private static BillPughSolution instance2;

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor[] cstr = BillPughSolution.class.getDeclaredConstructors();
		for (Constructor c : cstr) {
			c.setAccessible(true);
			instance2 = (BillPughSolution) c.newInstance();
			break;
		}

		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
	}

}
