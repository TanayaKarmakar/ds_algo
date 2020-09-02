package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class AddTwoNumbersLeetcode2 {
	private static int carry = 0;
	private static ListNode addRest(ListNode source, ListNode target) {
		while(source != null) {
			int sum = source.val;
			if(carry > 0) {
				sum += carry;
			}
			if(sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			target.next = new ListNode(sum);
			target = target.next;
			source = source.next;
		}
		return target;
	}
	
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		
		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode tmp3 = res;
		
		carry = 0;
		while(tmp1 != null && tmp2 != null) {
			int sum = tmp1.val + tmp2.val;
			if(carry > 0) {
				sum += carry;
			}
			
			if(sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			
			tmp3.next = new ListNode(sum);
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
			tmp3 = tmp3.next;
		}
		
		if(tmp1 != null) {
			tmp3 = addRest(tmp1, tmp3);
		}
		
		if(tmp2 != null) {
			tmp3 = addRest(tmp2, tmp3);
		}
		
		if(carry > 0) {
			tmp3 = tmp3.next;
			tmp3.next = new ListNode(carry);
			//tmp3 = tmp3.next;
		}
		
		res = res.next;
		return res;
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.head = new ListNode(9);
		ll1.head.next = new ListNode(8);
		//ll1.head.next.next = new ListNode(3);
		
		LinkedList ll2 = new LinkedList();
		ll2.head = new ListNode(1);
//		ll2.head.next = new ListNode(6);
//		ll2.head.next.next = new ListNode(4);
		
		ListNode res = addTwoNumbers(ll1.head, ll2.head);
		ListNode tmp = res;
		
		while(tmp != null) {
			System.out.print(tmp.val + (tmp.next != null ? "->":""));
			tmp = tmp.next;
		}
		
		System.out.println();

	}

}
