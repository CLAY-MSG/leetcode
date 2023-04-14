package com.clay;

/**
 * 160.相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class CrossLinkedList {
    public static void main(String[] args) {
        /*ListNode listNodeA4 = new ListNode(4);
        ListNode listNodeA1 = new ListNode(1);
        ListNode listNodeB5 = new ListNode(5);
        ListNode listNodeB6 = new ListNode(6);
        ListNode listNodeB1 = new ListNode(1);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode8.next = listNode4;
        listNode4.next = listNode5;
        listNodeA1.next = listNode8;
        listNodeB6.next = listNodeB1;
        listNodeB1.next = listNode8;
        listNodeA4.next = listNodeA1;
        listNodeB5.next = listNodeB6;
        ListNode listNode3 = new ListNode(3);
        ListNode listNodeB2 = new ListNode(2);
        listNodeB2.next = listNode3;*/
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


        ListNode listNode3 = new ListNode(3);

        listNodeA21.next = listNode3;

        ListNode listNodeB2 = new ListNode(2);
        listNodeB2.next = listNode3;




        System.out.println(getIntersectionNode(listNodeA1, listNodeB2));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA.next == null && headB.next == null && headA.equals(headB)){
            return headA;
        }
        ListNode tempNodeA = headA;
        ListNode tempNodeB = headB;
        if (headA.next == null && headB.next != null){
            while (tempNodeB != null){
                if (tempNodeA.equals(tempNodeB)){
                    return tempNodeA;
                }
                tempNodeB = tempNodeB.next;
            }
        }else if (headB.next == null && headA.next != null){
            while (tempNodeA != null){
                if (tempNodeB.equals(tempNodeA)){
                    return tempNodeA;
                }
                tempNodeA = tempNodeA.next;
            }
        }else {
            while (tempNodeA != null){
                while (tempNodeB != null){
                    if (tempNodeA.equals(tempNodeB)){
                        return tempNodeA;
                    }
                    tempNodeB = tempNodeB.next;
                }
                tempNodeB = headB;
                tempNodeA = tempNodeA.next;
            }
        }

        return null;
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
