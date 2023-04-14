package com.clay;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class MinimumStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        Node topNode = minStack.root;
        System.out.println(topNode.val);
        while (topNode.next != null){
            topNode = topNode.next;
            System.out.println(topNode.val);
        }

        System.out.println("===========================");
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

        System.out.println("===========================");
        
        Node tempNode = minStack.root;
        System.out.println(tempNode.val);
        while (tempNode.next != null){
            tempNode = tempNode.next;
            System.out.println(tempNode.val);
        }
    }

    static class MinStack {
        Node root;
        
        public MinStack() {
            
        }

        public void push(int val) {
            if (root == null){
                root = new Node(val,null);
                root.val = val;
            }else {
                Node top = getTop(root);
                top.next = new Node(val,null);
            }
        }

        public void pop() {
            if (root == null){
                return;
            }
            if (root.next == null){
                root = null;
                return;
            }
            Node temp = root;
            while (temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }

        public int top() {
            return getTop(root).val;
        }

        public int getMin() {
            int minVal = root.val;
            Node temp = root;
            while (temp.next != null){
                temp = temp.next;
                if (minVal > temp.val){
                    minVal = temp.val;
                }
            }
            return minVal;
        }
        
        public Node getTop(Node root){
            Node topNode = root;
            while (topNode.next != null){
                topNode = topNode.next;
            }
            return topNode;
        }
    }
    
    static class Node{
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
