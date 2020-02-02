package com.app.questions;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.app.questions.LinkedList.Node;

class NodeComparator implements Comparator<Triplet> {

	@Override
	public int compare(Triplet node1, Triplet node2) {
		if (node1.node.data == node2.node.data)
			return 0;
		else if (node1.node.data < node2.node.data)
			return -1;
		else
			return 1;
	}

}

class Triplet {
	Node node;
	int listPos;
	int valPos;
	
	public Triplet(Node node, int listPos, int valPos) {
		this.node = node;
		this.listPos = listPos;
		this.valPos = valPos;
	}
}

public class MergeKSortedList {
	// using heap
	private static Node mergeKSortedList(Node[] nodes) {
		if(nodes.length == 0)
			return null;
		if(nodes.length == 1)
			return nodes[0];
		PriorityQueue<Triplet> pQ = new PriorityQueue<>(new NodeComparator());
		int size = nodes.length;
		Node dummy = new Node(-1);
		Node tmp = dummy;

		for (int i = 0; i < size; i++) {
			if(nodes[i]!= null) {
				pQ.add(new Triplet(nodes[i], i, 0));
			}
		}
		
		if(pQ.isEmpty())
			return null;
		
		while(!pQ.isEmpty()) {
			Triplet triplet = pQ.poll();
			Node node = triplet.node;
			int listPos = triplet.listPos;
			int valPos = triplet.valPos;
			//node.next = null;
			if(tmp == dummy) {
				//dummy.next = new Node(node.data);
				dummy.next = node;
			} else {
				//tmp.next = new Node(node.data);
				tmp.next = node;
			}
			tmp = tmp.next;
			//tmp.next = null;
			
			//Node pNode = nodes[listPos];
			Node pNode = node.next;
			node.next = null;
			
			if(pNode!= null) {
				//Node pNodeNext = pNode.next;
				
				//pNode = pNode.next;
				pQ.add(new Triplet(pNode, listPos, valPos + 1));
			}
		}
		dummy = dummy.next;
		return dummy;
	}

	public static void main(String[] args) {
		Node[] nodes = new Node[3];
		LinkedList ll = new LinkedList();
		/*ll.insertAtEnd(1);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		nodes[0] = ll.head;
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		nodes[1] = ll.head;
		
		ll = new LinkedList();
		ll.insertAtEnd(2);
		ll.insertAtEnd(6);
		nodes[2] = ll.head;
		
		
		System.out.println("TestCase - 1");
		Node node = mergeKSortedList(nodes);
		
		Node tmp = node;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
		
		System.out.println("TestCase - 2");
		nodes = new Node[1];
		
		node = mergeKSortedList(nodes);
		
		tmp = node;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();*/
		
		System.out.println("TestCase - 3 ");
		nodes = new Node[2];
		ll = new LinkedList();
		nodes[0] = ll.head;
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		nodes[1] = ll.head;
		
		Node node = mergeKSortedList(nodes);
		
		Node tmp = node;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

}
