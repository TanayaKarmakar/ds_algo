package com.app.practice.design;

import java.util.LinkedList;
import java.util.Queue;

class HitCounter {
	Queue<Integer> q;
	
    /** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int checkUpto = timestamp - 300;
        while(!q.isEmpty() && q.peek() < checkUpto) {
        	q.poll();
        }
        
        return q.size();
    }
}

public class DesignHitCounterLeetcode362 {

	public static void main(String[] args) {
		

	}

}
