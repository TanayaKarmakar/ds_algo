package com.app.questions.practice;

import java.util.Iterator;
import java.util.List;

//TBD
interface NestedInteger {
	public boolean isInteger();
	public Integer getInteger();
	public List<NestedInteger> getList();
}



class NestedIterator implements Iterator<Integer> {

    public NestedIterator(List<NestedInteger> nestedList) {
        
    }

    @Override
    public Integer next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}

public class FlattenNestedListIteratorLeetcode341 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
