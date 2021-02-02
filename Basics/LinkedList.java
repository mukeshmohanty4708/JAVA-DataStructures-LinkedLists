package com.JavaGit.Basics;

public class LinkedList {
    protected LinkedList next;
    protected LinkedList head;
    protected LinkedList tail;
    protected int data;
    private int length;

    public LinkedList(int data) {
        this.data = data;
        next = null;
    }

    public LinkedList() {
        next = null;
        head = null;
        tail = null;
        length = 0;
    }

    public synchronized LinkedList getHead(){
        System.out.println("Head Pointer is at: " + head.data);
        return head;
    }
    public synchronized LinkedList getTail(){
        System.out.println("Tail Pointer is at: " + tail.data);
        return tail;
    }

    public synchronized void addBeg(int val){
        LinkedList temp = new LinkedList(val);

        if(head == null){
            System.out.println("Adding the New Node for DS");
            head = temp;
            tail = temp;
            temp.next = null;
            ++length;
        }
        else{
            temp.next = head;
            head = temp;
            ++length;
        }
        printDS();
    }

    public synchronized void addEnd(int val){
        LinkedList temp = new LinkedList(val);
        if(head == null){
            head = temp;
            tail= temp;
            temp.next = null;
        }
        else{
            tail.next = temp;
            tail = temp;
        }
        ++length;
        printDS();
    }

    public synchronized void insertAtPos(int val, int pos){
        System.out.println("Adding Element at Position: "+ pos);
        LinkedList temp = new LinkedList(val);
        if(head == null){
            head = tail = temp;
            ++length;
            return;
        }
        LinkedList curr = getHead();
        LinkedList newnode = curr;
        int len = 1;
        while(curr != null){
            ++len;
            curr = curr.next;
        }
        if(len == pos || pos > len){
            addEnd(val);
            return;
        }

        while(pos > 2){
            newnode = newnode.next;
            --pos;
        }
        temp.next  = newnode.next;
        newnode.next = temp;
        ++length;
        printDS();
    }

    public synchronized void removeAtPos(int pos){
        System.out.println("Removing Element from Position: "+ pos);
        if(pos <= 0){
            LinkedList curr = getHead();
            curr = curr.next;
            head = curr;
            --length;
            return;
        }
        if(pos >= length){
            tail = null;
            --length;
        }
        LinkedList curr = getHead();
        while(pos > 2){
            curr = curr.next;
            --pos;
        }
        curr.next = curr.next.next;
        --length;
        printDS();


    }
    public void printDS(){
        LinkedList curr = getHead();
        LinkedList curr2 = getTail();
        System.out.println("Printing Linked List: ");
        System.out.print("[ ");
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.print("]\n");
    }

    public static void main(String[] args){
        LinkedList node = new LinkedList();
        node.addBeg(5);node.addBeg(7);node.addBeg(8);

        node.addBeg(11);node.addBeg(38);
        node.addEnd(45); node.addEnd(47);

        node.insertAtPos(33,4);
        node.removeAtPos(4);
    }

}
