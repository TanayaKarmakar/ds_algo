package com.app.questions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.app.questions.LinkedList.Node;

//TBD
//need to check the efficient solution
public class RemoveDuplicatesFromLinkedListPart2 {
	private static Node deleteDuplicates(Node head) {
		Map<Integer, Integer> numMap = new LinkedHashMap<>();
		Node tmp = head;
		while (tmp != null) {
			if (!numMap.containsKey(tmp.data)) {
				numMap.put(tmp.data, 1);
			} else {
				int freq = numMap.get(tmp.data);
				numMap.put(tmp.data, ++freq);
			}
			tmp = tmp.next;
		}

		Node dummy = new Node(Integer.MIN_VALUE);
		tmp = dummy;
		for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
			if (entry.getValue() == 1) {
				if (tmp == dummy) {
					dummy.next = new Node(entry.getKey());
					tmp = tmp.next;
				} else {
					tmp.next = new Node(entry.getKey());
					tmp = tmp.next;
				}
			}
		}
		dummy = dummy.next;
		return dummy;

	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);

		ll.head = deleteDuplicates(ll.head);
		ll.display();
	}

}
