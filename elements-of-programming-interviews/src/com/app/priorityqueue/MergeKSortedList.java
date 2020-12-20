package com.app.priorityqueue;

import java.util.PriorityQueue;

import com.app.linkedlist.LinkedList.ListNode;

class QueueNode implements Comparable<QueueNode> {
	ListNode node;
	int arrayPos;
	int valuePos;
	
	public QueueNode(ListNode node, int arrayPos, int valuePos) {
		this.node = node;
		this.arrayPos = arrayPos;
		this.valuePos = valuePos;
	}

	@Override
	public int compareTo(QueueNode o) {
		return this.node.val - o.node.val;
	}
}

public class MergeKSortedList {
	private static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<QueueNode> pQ = new PriorityQueue<>();
		for(int i = 0; i < lists.length; i++) {
			if(lists[i] != null)
				pQ.add(new QueueNode(lists[i], 0, 0));
		}
		
		ListNode result = new ListNode(Integer.MAX_VALUE);
		ListNode tmp = result;
		
		while(!pQ.isEmpty()) {
			QueueNode qNode = pQ.poll();
			ListNode curr = qNode.node;
			ListNode currNext = curr.next;
			curr.next = null;
			tmp.next = curr;
			tmp = tmp.next;
			if(currNext != null)
				pQ.add(new QueueNode(currNext, qNode.arrayPos, qNode.valuePos + 1));
		}
		
		result = result.next;
		return result;
	}

	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(5);
		lists[0] = head1;
		
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(4);
		lists[1] = head2;
		
		ListNode head3 = new ListNode(2);
		head3.next = new ListNode(6);
		lists[2] = head3;
		
		ListNode result = mergeKLists(lists);
		
		ListNode temp = result;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();

	}

}