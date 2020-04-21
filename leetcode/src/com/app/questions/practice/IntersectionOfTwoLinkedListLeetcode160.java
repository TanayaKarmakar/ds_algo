package com.app.questions.practice;

import com.app.questions.practice.LinkedList.ListNode;

public class IntersectionOfTwoLinkedListLeetcode160 {
	private static int length(ListNode l) {
		ListNode tmp = l;
		int len = 0;
		while(tmp != null) {
			len++;
			tmp = tmp.next;
		}
		return len;
	}
	
	private static ListNode getIntersectionNode(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null)
			return  null;
		if(l1 == l2)
			return l1;
		int m = length(l1);
		int n = length(l2);
		
		if(m < n) {
			ListNode tmp = l1;
			l1 = l2;
			l2 = tmp;
			
			int t = m;
			m = n;
			n = t;
		}
		
		int diff = m - n;
		while(diff > 0) {
			l1 = l1.next;
			diff--;
		}
		
		ListNode tmp = l1;
		ListNode tmp1 = l2;
		
		while(tmp != null && tmp1 != null) {
			if(tmp == tmp1)
				return tmp;
			tmp = tmp.next;
			tmp1 = tmp1.next;
		}
		return null;
	}

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.head = new ListNode(4);
		l1.head.next = new ListNode(1);
		l1.head.next.next = new ListNode(8);
		l1.head.next.next.next = new ListNode(4);
		l1.head.next.next.next.next = new ListNode(5);
		
		LinkedList l2 = new LinkedList();
		l2.head = new ListNode(5);
		l2.head.next = new ListNode(0);
		l2.head.next.next = new ListNode(1);
		l2.head.next.next.next = l1.head.next.next;
		
		ListNode node = getIntersectionNode(l1.head, l2.head);
		
		System.out.println(node.val);

	}

}
