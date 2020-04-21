package com.app.questions.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.app.questions.practice.LinkedList.ListNode;

class NodeComparator implements Comparator<Triplet> {

	@Override
	public int compare(Triplet t1, Triplet t2) {
		if(t1.node.val == t2.node.val)
			return 0;
		else if(t1.node.val < t2.node.val)
			return -1;
		else
			return 1;
	}
	
}

class Triplet {
	ListNode node;
	int aPos;
	int vPos;
	
	public Triplet(ListNode node, int aPos, int vPos) {
		this.node = node;
		this.aPos = aPos;
		this.vPos = vPos;
	}
}

public class MergeKSortedListLeetcode23 {
	private static ListNode merge(ListNode[] nodes) {
		if(nodes.length == 0)
			return null;
        if(nodes.length == 1)
			return nodes[0];
		int size = nodes.length;
		
		PriorityQueue<Triplet> pQ = new PriorityQueue<Triplet>(new NodeComparator());
		
		for(int i = 0; i < size; i++) {
			if(nodes[i] != null) {
				Triplet triplet = new Triplet(nodes[i], i, 0);
				pQ.add(triplet);
			}	
		}
		
		if(pQ.isEmpty())
			return null;
		
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		
		ListNode temp = dummy;
		
		while(!pQ.isEmpty()) {
			Triplet item = pQ.poll();
			ListNode pNode = item.node;
			
			item.node = item.node.next;
			
			pNode.next = null;
			
			temp.next = pNode;
			temp = temp.next;
			
			if(item.node != null) {
				pQ.add(new Triplet(item.node, item.aPos, item.vPos + 1));
			}	
		}
		
		dummy = dummy.next;
		return dummy;
	}

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.head = new ListNode(1);
		l1.head.next = new ListNode(4);
		l1.head.next.next = new ListNode(5);
		
		LinkedList l2 = new LinkedList();
		l2.head = new ListNode(1);
		l2.head.next = new ListNode(3);
		l2.head.next.next = new ListNode(4);
		
		LinkedList l3 = new LinkedList();
		l3.head = new ListNode(2);
		l3.head.next = new ListNode(6);
		
		ListNode[] nodes = new ListNode[3];
		nodes[0] = l1.head;
		nodes[1] = l2.head;
		nodes[2] = l3.head;
		
		ListNode node = merge(nodes);
		ListNode tmp = node;
		
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}

	}

}
