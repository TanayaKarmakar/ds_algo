package com.app.linkedlist;

import com.app.linkedlist.LinkedList.ListNode;

//test for the intersection point for two lists
//list might have cycle
public class TestForOverlappingListII {
	private static ListNode isCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}

		if (slow == fast)
			return null;
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	private static int length(ListNode head) {
		int count = 0;
		ListNode tmp = head;
		while (tmp != null) {
			count++;
			tmp = tmp.next;
		}
		return count;
	}

	private static ListNode intersectionPointWithoutCycle(ListNode l1, ListNode l2) {
		int m = length(l1);
		int n = length(l2);
		if(m < n) {
			ListNode tmp = l1;
			l1 = l2;
			l2 = tmp;
			
			int tmpLen = m;
			m = n;
			n = tmpLen;
		}
		
		int diff = (m - n);
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		while(diff > 0) {
			tmp1 = tmp1.next;
			diff--;
		}
		
		while(tmp1 != tmp2) {
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		
		return tmp1;
	}

	private static ListNode intersectionPoint(ListNode l1, ListNode l2) {
		// check for cyclicity
		ListNode root0 = isCycle(l1);
		ListNode root1 = isCycle(l2);

		if (root0 == root1) {
			// they don't have cycle
			// run the method for normal intersection point test
			return intersectionPointWithoutCycle(l1, l2);
		} else if ((root0 != null && root1 == null) || (root0 == null && root1 != null)) {
			// can't intersect
			return null;
		} else {
			ListNode tmp = root1;
			do {
				tmp = tmp.next;
			} while (tmp != root1 && tmp != root0);

			return (tmp == root0) ? root1 : null;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
