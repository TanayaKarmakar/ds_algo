package com.app.list;

import java.util.Arrays;

import com.app.list.LinkedList.Node;

public class RotationCounter {

	private static int findRotationCount(Node head) {
		if (head == null || head.next == null)
			return 0;
		Node pNode = head;
		int rotationCount = 0;
		while (pNode.next != null && pNode.data < pNode.next.data) {
			rotationCount++;
			pNode = pNode.next;
		}
		return (rotationCount + 1);
	}

	public static void main(String[] args) {
		LinkedList list = LinkedListFactory.createListFrom(Arrays.asList(15, 18, 5, 8, 11, 12 ));
		System.out.println("Rotation count - " + findRotationCount(list.head));
	}

}
