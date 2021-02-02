package com.JavaGit.Basics;

class CircularLinkedLists {
    private CircularLinkedLists next;
    private CircularLinkedLists head;
    private int data;
    private int length;

    CircularLinkedLists(){
        head = next = null;
        length = 0;
    }

    CircularLinkedLists(int data){
        this.data = data;
        next = null;
    }

    public synchronized CircularLinkedLists getHead(){
        return head;
    }

    public synchronized void insert(int val){
        System.out.println("Adding new Value to List: "+ val);
        CircularLinkedLists node = new CircularLinkedLists(val);
        if(head == null){
            node.next = null;
            head = node;
            node.next = head;
            ++length;
        }
        else{
            CircularLinkedLists curr = head;
            while(curr.next != head){
                curr = curr.next;
            }
            curr.next = node;
            node.next = head;
            ++length;
        }
        printDS();
    }

    public void printDS(){
        CircularLinkedLists temp = getHead();

        System.out.println("Printing Linked List: ");
        System.out.print("[ ");
        do{
            System.out.print(temp.data + " ");
            temp = temp.next;
        }while(temp != head);
        System.out.print("]--->\n");

    }

    public static void main(String[] args) {
        System.out.println("Circular Linked Lists");

        CircularLinkedLists node = new CircularLinkedLists();
        node.insert(1);node.insert(2);node.insert(3);
    }
}