package com.app.practice;

import java.util.LinkedHashMap;
import java.util.Map;

import com.app.practice.LinkedList.ListNode;

class ListValue {
	ListNode node;
	int freq;
}

public class RemoveDuplicatesFromSortedList2Leetcode82 {
	private static ListNode removeDuplicate(ListNode head) {
		Map<Integer, ListValue> map = new LinkedHashMap<>();
		ListNode temp = head;
		while(temp != null) {
			if(!map.containsKey(temp.val)) {
				ListValue value = new ListValue();
				value.node = temp;
				value.freq = 1;
				map.put(temp.val, value);
			} else {
				ListValue value = map.get(temp.val);
				value.freq++;
				map.put(temp.val, value);
			}
			temp = temp.next;
		}
		
		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode tmp = res;
		for(Map.Entry<Integer, ListValue> entry: map.entrySet()) {
			ListValue val = entry.getValue();
			if(val.freq == 1) {
				val.node.next = null;
				tmp.next = val.node;
				tmp = tmp.next;
			}
		}
		res = res.next;
		return res;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(2);
		ll.head.next.next.next = new ListNode(3);
		ll.head.next.next.next.next = new ListNode(4);
		ll.head.next.next.next.next.next = new ListNode(4);
		ll.head.next.next.next.next.next.next = new ListNode(5);
		
		ListNode res = removeDuplicate(ll.head);
		
		ListNode tmp = res;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println();

	}

}
