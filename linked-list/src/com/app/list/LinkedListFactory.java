package com.app.list;

import java.util.List;

import com.app.list.LinkedList.Node;

public class LinkedListFactory {
	public static LinkedList createListFrom(List<Integer> numbers) {
		LinkedList list = new LinkedList();
		for(Integer num: numbers) {
			list.head = insert(list.head, num);
		}
		return list;
	}
	
	public static Node insert(Node head, int data) {
		if(head == null) {
			head = new Node(data);
		} else {
			Node pNode = head;
			while(pNode.next != null) {
				pNode = pNode.next;
			}
			pNode.next = new Node(data);
		}
		return head;
	}
}
