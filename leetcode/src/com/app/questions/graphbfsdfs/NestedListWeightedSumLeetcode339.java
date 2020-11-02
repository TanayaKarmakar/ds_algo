package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface NestedInteger {
	public boolean isInteger();

	public Integer getInteger();

	public void setInteger(int value);

	public void add(NestedInteger ni);

	public List<NestedInteger> getList();
}

class MyNestedInteger implements NestedInteger {
	Integer el;
	List<NestedInteger> list;

	public MyNestedInteger() {
		list = new ArrayList<>();
	}

	public MyNestedInteger(int val) {
		el = val;
	}

	@Override
	public boolean isInteger() {
		return (el != null && (list == null || list.isEmpty()));
	}

	@Override
	public Integer getInteger() {
		return el;
	}

	@Override
	public void setInteger(int value) {
		el = value;
	}

	@Override
	public void add(NestedInteger ni) {
		list.add(ni);
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}

}

public class NestedListWeightedSumLeetcode339 {
	private static int sum = 0;

	private static void depthSumRec(NestedInteger ni, int depth) {
		if (ni.isInteger()) {
			sum += ni.getInteger() * depth;
			return;
		}

		List<NestedInteger> list = ni.getList();
		for (NestedInteger niItem : list) {
			depthSumRec(niItem, depth + 1);
		}
	}

	private static int depthSum(List<NestedInteger> nestedList) {
		int depth = 1;
		sum = 0;
		for (NestedInteger ni : nestedList) {
			depthSumRec(ni, depth);
		}

		return sum;
	}

	public static void main(String[] args) {
		List<NestedInteger> list = new ArrayList<>();
		NestedInteger ni1 = new MyNestedInteger(1);
		NestedInteger ni2 = new MyNestedInteger(1);
		NestedInteger finalNi1 = new MyNestedInteger();
		finalNi1.add(ni1);
		finalNi1.add(ni2);
		list.add(finalNi1);
		
		NestedInteger ni3 = new MyNestedInteger(2);
		list.add(ni3);
		
		NestedInteger ni4 = new MyNestedInteger(1);
		NestedInteger ni5 = new MyNestedInteger(1);
		NestedInteger finalNi2 = new MyNestedInteger();
		finalNi2.add(ni4);
		finalNi2.add(ni5);
		list.add(finalNi2);
		
		int sum = depthSum(list);
		
		System.out.println(sum);

	}

}
