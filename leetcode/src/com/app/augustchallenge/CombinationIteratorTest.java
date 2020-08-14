package com.app.augustchallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CombinationIterator {
	int cLen;
	List<String> list;

    public CombinationIterator(String characters, int combinationLength) {
       cLen = combinationLength;
       list = new ArrayList<>();
       preprocessing(characters);
    }
    
    public String next() {
        return list.remove(0);
    }
    
    public boolean hasNext() {
        return list.size() > 0;
    }
    
    private void preprocessing(String chars) {
    	int n = chars.length();
    	int total = (int)Math.pow(2, n);
    	
    	for(int i = 0; i < total; i++) {
    		int k = 0;
    		int temp = i;
    		
    		while(temp != 0) {
    			k++;
    			temp = temp & (temp - 1);
    		}
    		
    		if(k == cLen) {
    			String str = "";
    			int j = 0;
    			temp = i;
    			
    			
    			//System.out.println(temp);
    			while(temp != 0) {
    				if((temp & 1) == 1) {
    					str = str + chars.charAt(j);	
    				}
    				j++;
					temp = temp >> 1;
    			}
    			list.add(str);
    		}
    	}
    	Collections.sort(list);
    }
}

public class CombinationIteratorTest {

	public static void main(String[] args) {
		CombinationIterator cItr = 
				new CombinationIterator("abc", 2);
		
		System.out.println(cItr.next());
		System.out.println(cItr.hasNext());
		System.out.println(cItr.next());
		System.out.println(cItr.hasNext());
		System.out.println(cItr.next());
		System.out.println(cItr.hasNext());
	}

}
