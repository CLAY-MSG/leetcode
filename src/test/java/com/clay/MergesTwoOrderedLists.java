package com.clay;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class MergesTwoOrderedLists {
    public static void main(String[] args) {
        /*ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);*/

        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);
        list2.next.next.next = new ListNode(4);

        ListNode listNode = new MergesTwoOrderedLists().mergeTwoLists(list1, list2);
        ListNode temp = listNode;
        while (temp.next != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null){
                return list2;
            }
            if (list2 == null){
                return list1;
            }
        ListNode list = new ListNode();
        ListNode nextNode1;
        ListNode nextNode2;
        if (list1.val < list2.val){
            list.val = list1.val;
            nextNode1 = list1.next;
            nextNode2 = list2;
        }else {
            list.val = list2.val;
            nextNode1 = list1;
            nextNode2 = list2.next;
        }

        while (nextNode1 != null && nextNode2 != null){
            if (nextNode1.val < nextNode2.val){
                ListNode tail = getTail(list);
                tail.next = new ListNode(nextNode1.val);
                nextNode1 = nextNode1.next;
            }else if (nextNode1.val == nextNode2.val){
                ListNode tail = getTail(list);
                tail.next = new ListNode(nextNode1.val);;
                tail.next.next = new ListNode(nextNode2.val);
                nextNode1 = nextNode1.next;
                nextNode2 = nextNode2.next;
            }else {
                ListNode tail = getTail(list);
                tail.next = new ListNode(nextNode2.val);
                nextNode2 = nextNode2.next;
            }
        }
        ListNode tail = getTail(list);
        if (nextNode1 == null){
            tail.next = nextNode2;
        }else {
            tail.next = nextNode1;
        }
        return list;
    }

    public static ListNode getTail(ListNode list){
        ListNode temp = list;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



