package com.app.problems;

import java.util.HashMap;
import java.util.Map;

class XORedNode<T> {
	private T data;
	int both = 0;

	public XORedNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
}

public class XORedDLL<T> {
	private XORedNode<T> start;
	private XORedNode<T> end;
	private Map<Integer, XORedNode<T>> nodeMap;

	public XORedDLL() {
		this.nodeMap = new HashMap<>();
	}

	public void add(T data) {
		XORedNode<T> node = new XORedNode<T>(data);
		int previous = 0;
		this.end = node;
		if (start == null) {
			//when we insert a new node at the beginning(while inserting the first element)
			//both pointer will be XOR of NULL and current node
			start = node;
			nodeMap.put(previous ^ node.hashCode(), node);
		} else {
			//otherwise we take we start traversing from the start
			XORedNode<T> currentNode = start;
			
			//we iterate until we encounter the last node
			while (currentNode.both != 0) {
				int current = currentNode.hashCode();
				currentNode = nodeMap.get(previous ^ currentNode.both);
				previous = current;
			}
			currentNode.both = previous ^ node.hashCode();
			nodeMap.put(node.hashCode(), node);
		}
	}

	public void traverseForward() {
		int previous = 0;
		int both = start.hashCode();
		while (both != 0) {
			System.out.println("Data : " + this.nodeMap.get(both).getData());
			
			if(this.nodeMap.get(both).both == 0)
				break;
			int pre = this.nodeMap.get(both).hashCode();
			both = this.nodeMap.get(both).both ^ previous;
			previous = pre;
		}
	}

	public static void main(String[] args) {
		XORedDLL<Integer> dll = new XORedDLL<Integer>();
		dll.add(100);
		dll.add(200);
		dll.add(300);
		
		dll.traverseForward();
		
	}

}
