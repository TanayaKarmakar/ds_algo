package com.app.list;

import java.util.Arrays;

import com.app.list.LinkedList.Node;

public class DeleteNodes {
	private static void deleteNodes(Node head, int n, int m) {
		int tmpN = n;
		int tmpM = m - 1;
		Node pNode = head;
		Node rNode;
		while (pNode != null) {
			while (tmpM > 0) {
				pNode = pNode.next;
				tmpM--;
			}
			if(pNode != null) {
				rNode = pNode.next;

				while (tmpN > 0 && rNode!=null) {
					rNode = rNode.next;
					tmpN--;
				}
				pNode.next = rNode;
				pNode = rNode;
				tmpM = (m - 1);
				tmpN = n;
			}
		}
	}

	public static void main(String[] args) {
		LinkedList list = LinkedListFactory.createListFrom(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		System.out.println("Before deletion");
		LinkedListUtils.print(list.head);

		deleteNodes(list.head, 3, 2);
		System.out.println("After deletion");
		LinkedListUtils.print(list.head);
	}

}
