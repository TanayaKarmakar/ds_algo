package com.app.practice.heap;

import java.util.PriorityQueue;

import com.app.practice.LinkedList.ListNode;

class ListItem implements Comparable<ListItem> {
	ListNode node;
	int aPos;
	int vPos;
	
	public ListItem(ListNode node, int aPos, int vPos) {
		this.node = node;
		this.aPos = aPos;
		this.vPos = vPos;
	}

	@Override
	public int compareTo(ListItem o) {
		return this.node.val - o.node.val;
	}
	
}

public class MergeKSortedListLeetcode23 {
	private static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0)
			return null;
		if(lists.length == 1)
			return lists[0];
		int n = lists.length;
		
		PriorityQueue<ListItem> q = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			if(lists[i] != null)
				q.add(new ListItem(lists[i], i, 0));
		}
		
		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode tmp = res;
		
		while(!q.isEmpty()) {
			ListItem item = q.poll();
			ListNode curr = item.node;
			int aPos = item.aPos;
			int vPos = item.vPos;
			
			ListNode next = curr.next;
			
			curr.next = null;
			tmp.next = curr;
			tmp = tmp.next;
			
			if(next != null) {
				q.add(new ListItem(next, aPos, vPos + 1));
			}
		}
		
		res = res.next;
		return res;
		
	}

	public static void main(String[] args) {
		

	}

}
