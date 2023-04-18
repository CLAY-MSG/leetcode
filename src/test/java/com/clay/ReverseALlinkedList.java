package com.clay;

import java.util.Stack;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class ReverseALlinkedList {
    public static void main(String[] args) {
        ListNode listNodeA1 = new ListNode(1);
        ListNode listNodeA3 = new ListNode(3);
        ListNode listNodeA5 = new ListNode(5);
        ListNode listNodeA7 = new ListNode(7);
        ListNode listNodeA9 = new ListNode(9);
        ListNode listNodeA11 = new ListNode(11);
        ListNode listNodeA13 = new ListNode(13);
        ListNode listNodeA15 = new ListNode(15);
        ListNode listNodeA17 = new ListNode(17);
        ListNode listNodeA19 = new ListNode(19);
        ListNode listNodeA21 = new ListNode(21);
        listNodeA1.next = listNodeA3;
        listNodeA3.next = listNodeA5;
        listNodeA5.next = listNodeA7;
        listNodeA7.next = listNodeA9;
        listNodeA9.next = listNodeA11;
        listNodeA11.next = listNodeA13;
        listNodeA13.next = listNodeA15;
        listNodeA15.next = listNodeA17;
        listNodeA17.next = listNodeA19;
        listNodeA19.next = listNodeA21;

        System.out.println(reverseList(null));
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        Stack<ListNode> integerStack = new Stack<>();
        while (head != null){
            integerStack.push(head);
            head = head.next;
        }
        ListNode newHead = new ListNode(integerStack.pop().val);
        newHead.next = new ListNode(integerStack.pop().val);
        ListNode temp = newHead.next;
        while (!integerStack.empty()){
            temp.next = new ListNode(integerStack.pop().val);
            temp = temp.next;
        }
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
