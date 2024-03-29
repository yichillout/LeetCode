package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

import java.util.*;

public class LC0445_AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int num = 0;
        ListNode tmp = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) {
                num += s1.pop();
            }

            if (!s2.empty()) {
                num += s2.pop();
            }

            tmp.val = num % 10;
            ListNode head = new ListNode(num / 10);
            head.next = tmp;
            tmp = head;
            num /= 10;
        }

        return tmp.val == 0 ? tmp.next : tmp;
    }

}
