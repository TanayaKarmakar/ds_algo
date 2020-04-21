package com.app.questions.practice;

import com.app.questions.practice.LinkedList.ListNode;

public class AddTwoNumbersLeetcode2 {
	private static int carry = 0;
	private static ListNode calculateSum(ListNode target, ListNode source) {
		while (source != null) {
			int sum = source.val;
			if (carry > 0) {
				sum = sum + carry;
			}
			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
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
		carry = 0;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		//int carry = 0;

		ListNode result = null;
		ListNode tmp3 = null;
		while (tmp1 != null && tmp2 != null) {
			int sum = tmp1.val + tmp2.val;
			if (carry > 0) {
				sum = sum + carry;
			}
			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			if (result == null) {
				result = new ListNode(sum);
				tmp3 = result;
			} else {
				tmp3.next = new ListNode(sum);
				tmp3 = tmp3.next;
			}
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}

		if (tmp1 != null) {
			tmp3 = calculateSum(tmp3, tmp1);
		}
		if (tmp2 != null) {
			tmp3 = calculateSum(tmp3, tmp2);
		}

		if(carry > 0) {
			tmp3.next = new ListNode(carry);
			tmp3 = tmp3.next;
		}
		return result;
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.head = new ListNode(9);
		ll1.head.next = new ListNode(8);
	//	ll1.head.next.next = new ListNode(3);
		
		LinkedList ll2 = new LinkedList();
		ll2.head = new ListNode(1);
//		ll2.head.next = new ListNode(6);
//		ll2.head.next.next = new ListNode(4);
		
		ListNode ll3 = addTwoNumbers(ll1.head, ll2.head);
		
		ListNode tmp = ll3;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}

	}

}
