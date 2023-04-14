package com.clay;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class PalindromeList {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(2, new ListNode(1)))));
        ListNode head = new ListNode(1,new ListNode(2));
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head.next == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        int mid = list.size() / 2;
        int i = 0;
        int j = list.size() - 1;
        int end = (list.size() % 2 == 0) ? mid : mid + 1;
        while (i <= mid - 1 && j >= end){
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
