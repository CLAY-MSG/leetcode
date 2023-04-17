package com.clay;

/**
 * 2.两数相加
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。请你将两个数相加，
 * 并以相同形式返回一个表示和的链表。你可以假设除了数字0之外，这两个数都不会以0开头。
 * @author CLAY
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return get(l1, l2,false);
    }

    public static ListNode get(ListNode tempListNode1, ListNode tempListNode2, boolean flag) {
        int val;
        if (tempListNode1 == null && tempListNode2 == null){
            return null;
        }else if (tempListNode1 == null){
            if (flag){
                val = tempListNode2.val + 1;
                if (val < 10){
                    return new ListNode(val, tempListNode2.next);
                }else {
                    if (tempListNode2.next == null){
                        return new ListNode(val - 10, new ListNode(1));
                    }else {
                        return new ListNode(val - 10, get(null, tempListNode2.next, true));
                    }
                }
            }else {
                return tempListNode2;
            }
        }else if (tempListNode2 == null){
            if (flag){
                val = tempListNode1.val + 1;
                if (val < 10){
                    return new ListNode(val, tempListNode1.next);
                }else {
                    if (tempListNode1.next == null){
                        return new ListNode(val - 10, new ListNode(1));
                    }else {
                        return new ListNode(val - 10, get(null, tempListNode1.next, true));
                    }
                }
            }else {
                return tempListNode1;
            }
        }else if (tempListNode1.next == null && tempListNode2.next == null){
            if (flag){
                val = tempListNode1.val + tempListNode2.val + 1;
            }else {
                val = tempListNode1.val + tempListNode2.val;
            }
            if (val < 10){
                return new ListNode(val);
            }else {
                return new ListNode(val - 10, new ListNode(1));
            }
        }

        if (flag){
            val = tempListNode1.val + tempListNode2.val + 1;
        }else {
            val = tempListNode1.val + tempListNode2.val;
        }
        if (val < 10){
            return new ListNode(val, get(tempListNode1.next, tempListNode2.next, false));
        }else {
            return new ListNode(val - 10, get(tempListNode1.next, tempListNode2.next, true));
        }

    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
}




