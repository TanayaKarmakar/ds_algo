package com.app.list;

import java.util.*;

//User defined Node
class XoredNode<T> {
	private T data;
	public int next = 0;

	public XoredNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
}

public class XoredDLL<T> {
	XoredNode<T> start = null;
	XoredNode<T> end = null;
	Map<Integer, XoredNode<T>> pointerMap = new HashMap<>();

	public void add(T data) {
		XoredNode<T> node = new XoredNode<T>(data);
		this.end = node;

		int previous = 0;
		if (start == null) {
			start = node;
			pointerMap.put(previous ^ node.hashCode(), start);
			return;
		} else {
			XoredNode<T> currentNode = start;
			while (currentNode.next != 0) {
				int current = currentNode.hashCode();
				currentNode = pointerMap.get(previous ^ currentNode.next);
				previous = current;

			}
			currentNode.next = previous ^ node.hashCode();
			pointerMap.put(node.hashCode(), node);
		}
	}

	public void printFromStart() {
		int previous = 0;
		int next = start.hashCode();
		while ((next) != 0) {
			System.out.println("Data:" + pointerMap.get(next).getData());
			// If you verify whether reverse traversal is working,you can
			// comment below i block
			if (pointerMap.get(next).next == 0)
				break;
			int pre = pointerMap.get(next).hashCode();
			next = pointerMap.get(next).next ^ previous;
			previous = pre;
		}
	}

	public static void main(String[] args) {
		XoredDLL<Integer> dll = new XoredDLL<Integer>();
		dll.add(100);
		dll.add(200);
		dll.add(300);
		dll.add(400);
		dll.add(500);
		dll.add(600);
		dll.add(700);
		dll.add(800);
		dll.add(900);
		dll.printFromStart();
	}
}