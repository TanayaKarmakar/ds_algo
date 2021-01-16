package com.app.janchallenge2021;

import com.app.questions.practice.LinkedList.ListNode;

public class RemoveDuplicatesFromSortedListII {
	private static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode p = head;
		ListNode result = new ListNode(Integer.MAX_VALUE);
		ListNode tmp = result;
		
		while(p != null) {
			ListNode q = p.next;
			int count = 1;
			
			while(q != null && p.val == q.val) {
				count++;
				q = q.next;
			}
			
			if(count == 1) {
				ListNode curr = p;
				tmp.next = curr;
				tmp = tmp.next;
			}
			p = q;
			tmp.next = null;
		}
		
		result = result.next;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
