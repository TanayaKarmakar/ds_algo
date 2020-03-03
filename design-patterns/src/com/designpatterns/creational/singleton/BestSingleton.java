package com.designpatterns.creational.singleton;

import java.io.Serializable;


//readResolve() method protects hacking from serialization
// when deserialization happens then readResolve()
// is getting called, so at this point
// we can implement readResolve() and return the instance
public class BestSingleton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BestSingleton() {
		
	}
	
	private static class BestSingletonHolder {
		private static final BestSingleton INSTANCE = new BestSingleton();
	}
	
	public static BestSingleton getInstance() {
		return BestSingletonHolder.INSTANCE;
	}
	
	protected Object readResolve() {
		return getInstance();
	}

}
