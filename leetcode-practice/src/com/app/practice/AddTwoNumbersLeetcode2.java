package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class AddTwoNumbersLeetcode2 {
	private static int[] getCarrySum(int val1, int val2, int carry) {
		int[] ans = new int[2];
		int sum = val1 + val2;
		if(carry > 0) {
			sum += carry;
		}
		
		if(sum > 9) {
			carry = sum / 10;
			sum = sum % 10;
		} else {
			carry = 0;
		}
		ans[0] = sum;
		ans[1] = carry;
		return ans;
	}
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode tmp3 = res;
		
		int carry = 0;
		while(tmp1 != null && tmp2 != null) {
			int[] ans = getCarrySum(tmp1.val, tmp2.val, carry);
			tmp3.next = new ListNode(ans[0]);
			carry = ans[1];
			tmp3 = tmp3.next;
			
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		
		while(tmp1 != null) {
			int[] ans = getCarrySum(tmp1.val, 0, carry);
			
			tmp3.next = new ListNode(ans[0]);
			carry = ans[1];
			tmp3 = tmp3.next;
			
			tmp1 = tmp1.next;
			
		}
		
		while(tmp2 != null) {
			int[] ans = getCarrySum(tmp2.val, 0, carry);
			
			tmp3.next = new ListNode(ans[0]);
			carry = ans[1];
			tmp3 = tmp3.next;
			
			tmp2 = tmp2.next;
		}
		
		if(carry > 0) {
			tmp3.next = new ListNode(carry);
			tmp3 = tmp3.next;
		}
		
		res = res.next;
		return res;
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.head = new ListNode(9);
		ll1.head.next = new ListNode(8);
//		ll1.head.next.next = new ListNode(3);
		
		LinkedList ll2 = new LinkedList();
		ll2.head = new ListNode(1);
//		ll2.head.next = new ListNode(6);
//		ll2.head.next.next = new ListNode(4);
		
		ListNode ll3 = addTwoNumbers(ll1.head, ll2.head);
		ListNode temp = ll3;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

		System.out.println();
	}

}
