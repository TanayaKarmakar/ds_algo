package com.app.practice;

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
	private static ListNode mergeLists(ListNode[] nodes) {
		if(nodes.length == 0)
			return null;
		if(nodes.length == 1)
			return nodes[0];
		PriorityQueue<ListItem> pQ = new PriorityQueue<>();
		for(int i = 0; i < nodes.length; i++) {
			pQ.add(new ListItem(nodes[i], i, 0));
		}
		
		if(pQ.isEmpty())
			return null;
		
		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode tmp = res;
		while(!pQ.isEmpty()) {
			ListItem item = pQ.poll();
			ListNode node = item.node;
			ListNode curr = node;
			if(node != null) {
				node = node.next;
				curr.next = null;
				tmp.next = curr;
				tmp = tmp.next;
				if(node != null) {
					pQ.add(new ListItem(node, item.aPos, item.vPos + 1));
				}
			}	
		}
		
		res = res.next;
		return res;
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.head = new ListNode(1);
		ll1.head.next = new ListNode(4);
		ll1.head.next.next = new ListNode(5);
		
		LinkedList ll2 = new LinkedList();
		ll2.head = new ListNode(1);
		ll2.head.next = new ListNode(3);
		ll2.head.next.next = new ListNode(4);
		
		LinkedList ll3 = new LinkedList();
		ll3.head = new ListNode(2);
		ll3.head.next = new ListNode(6);
		
		ListNode[] nodes = new ListNode[3];
		nodes[0] = ll1.head;
		nodes[1] = ll2.head;
		nodes[2] = ll3.head;
		
		ListNode res = mergeLists(nodes);
		
		ListNode tmp = res;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

}
