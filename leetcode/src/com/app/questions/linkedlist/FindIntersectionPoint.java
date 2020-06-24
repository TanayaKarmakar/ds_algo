package com.app.questions.linkedlist;

import com.app.questions.linkedlist.LinkedList.Node;

public class FindIntersectionPoint {
	private static int length(Node node) {
        int len = 0;
        Node tmp = node;
        while(tmp != null) {
            tmp = tmp.next;
            len++;
        }
        
        return len;
    }
    public static Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null)
            return null;
        if(headA == headB)
            return headA;
        int m = length(headA);
        int n = length(headB);
        Node tmp;
        int lenTmp;
        if(m < n) {
            tmp = headA;
            headA = headB;
            headB = tmp;
            lenTmp = m;
            m = n;
            n = lenTmp;
        }
        int diff = m - n;
        tmp = headA;
        while(diff > 0) {
            tmp = tmp.next;
            diff--;
        }
        
        Node tmp1 = headB;
        while(tmp != null && tmp1!=null) {
            if(tmp == tmp1)
                return tmp;
            tmp = tmp.next;
            tmp1 = tmp1.next;
        }
        
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
