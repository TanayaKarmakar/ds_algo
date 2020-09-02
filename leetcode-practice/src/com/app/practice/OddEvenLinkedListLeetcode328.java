package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class OddEvenLinkedListLeetcode328 {
	private static final int DUMMY = Integer.MAX_VALUE;
	
	private static ListNode oddEven(ListNode head) {
		ListNode odd = new ListNode(DUMMY);
		ListNode even = new ListNode(DUMMY);
		ListNode oddTmp = odd;
		ListNode evenTmp = even;
		
		
		int nodeNum = 1;
		ListNode tmp = head;
		while(tmp != null) {
			ListNode curr = tmp;
			tmp = tmp.next;
			curr.next = null;
			if(nodeNum % 2 == 0) {
				evenTmp.next = curr;
				evenTmp = evenTmp.next;
			} else {
				oddTmp.next = curr;
				oddTmp = oddTmp.next;
			}
			nodeNum++;
		}
		
		odd = odd.next;
		even = even.next;
		oddTmp.next = even;
		return odd;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		
		ListNode res = oddEven(ll.head);
		ListNode tmp = res;
		
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		
		System.out.println();
		
		ll = new LinkedList();
		ll.head = new ListNode(2);
		ll.head.next = new ListNode(1);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(5);
		ll.head.next.next.next.next = new ListNode(6);
		ll.head.next.next.next.next.next = new ListNode(4);
		ll.head.next.next.next.next.next.next = new ListNode(7);
		
		res = oddEven(ll.head);
		tmp = res;
		
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		
	}

}
