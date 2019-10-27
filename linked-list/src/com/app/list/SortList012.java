package com.app.list;

import java.util.Arrays;

import com.app.list.LinkedList.Node;

public class SortList012 {
	private static Node sortList(Node head) {
		Node pNode = head;
		Node prev = head;
		Node rNode;
		while(pNode != null) {
			if(pNode.data == 0 && pNode != head) {
				rNode = pNode;
				prev.next = pNode.next;
				pNode = pNode.next;
				rNode.next = null;
				rNode.next = head;
				head = rNode;
			}

			if(pNode != null) {
				prev = pNode;
				pNode = pNode.next;
			}
		}
		
		Node start = head;
		Node prevNode = head;
		while(start.data == 0) {
			prevNode = start;
			start = start.next;
		}
		
		Node last = prev;
		Node delim = last;

		while(start != delim.next && start!= null) {
			if(start.data == 2) {
				rNode = start;
				start = start.next;
				prevNode.next = start;
				rNode.next = null;
				last.next = rNode;
				last = last.next;
			}
			prevNode = start;
			if(start != null) {
				start = start.next;
			}
			
		}
		
		return head;
	}

	public static void main(String[] args) {
		LinkedList list = LinkedListFactory.createListFrom(Arrays.asList(2,1,2,1,1,2,0,1,0));
		list.head = sortList(list.head);
		LinkedListUtils.print(list.head);
		System.out.println();
		list = LinkedListFactory.createListFrom(Arrays.asList(2,1,0));
		list.head = sortList(list.head);
		LinkedListUtils.print(list.head);

	}

}
