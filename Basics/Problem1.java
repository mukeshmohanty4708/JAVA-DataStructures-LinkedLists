package com.JavaGit.Basics;
//Find nth node from the end of a Linked List.
public class Problem1 extends LinkedList{

    public void getNodeFromEnd(LinkedList head, int NthNode){
        LinkedList fastPtr = head;
        int pos = NthNode;
        while(NthNode > 0){
            fastPtr = fastPtr.next;
            --NthNode;
        }
        while(fastPtr != null){
            head = head.next;
            fastPtr = fastPtr.next;
        }
        System.out.println("Printing " + pos + " Node from the End: " + head.data);
    }

    public void getNodeFromEndRecursive(LinkedList head,LinkedList fastPtr, int NthNode){
        if(head == fastPtr){
            while(NthNode > 0){
                fastPtr = fastPtr.next;
                --NthNode;
            }
        }
        if(fastPtr == null){
            System.out.println("Printing Node from the End: " + head.data);
            return;
        }
        getNodeFromEndRecursive(head.next,fastPtr.next,NthNode);
    }

    public static void main(String[] args){
        System.out.println("Problem Statement 1: Find nth node from the end of a Linked List.");
        LinkedList node = new LinkedList();
        node.addBeg(5);node.addBeg(7);node.addBeg(8);
        node.addBeg(11);node.addBeg(38);
        node.addEnd(45); node.addEnd(47);
        LinkedList head = node.getHead();
        Problem1 obj = new Problem1();
        obj.getNodeFromEnd(head,4);
        obj.getNodeFromEndRecursive(head,head,4);
    }
}
