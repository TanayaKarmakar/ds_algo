package com.app.practice.linkedlist;

import com.app.practice.LinkedList.ListNode;

public class IntersectionOfLinkedListLeetCode160 {
    private static int length(ListNode list) {
        int l = 0;
        ListNode tmp = list;
        while(tmp != null) {
            l++;
            tmp = tmp.next;
        }
        return l;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int m = length(headA);
        int n = length(headB);

        if(m < n) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;

            int tmpInt = m;
            m = n;
            n = tmpInt;
        }

        int diff = (m - n);
        ListNode tmp1 = headA;
        while(diff > 0) {
            tmp1 = tmp1.next;
            diff--;
        }

        ListNode tmp2 = headB;
        while(tmp1 != null && tmp2 != null) {
            if(tmp1 == tmp2)
                return tmp1;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
