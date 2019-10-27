package com.app.list;

import com.app.list.LinkedList.Node;

public class LinkedListUtils {
	public static void print(Node head) {
		Node pNode = head;
		while (pNode != null) {
			System.out.print(pNode.data + "\t");
			pNode = pNode.next;
		}
	}

}
