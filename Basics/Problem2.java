package com.JavaGit.Basics;
//Check whether the given linked list is either NULL-terminated or ends in a cycle (cyclic) and find length: Floyds Cycle
// 1->2->3->4->5->6->7->|
//          |<-10<-9<-8<-
public class Problem2 extends LinkedList {

    public void checkFloydsCycle(LinkedList head){
        LinkedList fast_ptr = head;
        LinkedList slow_ptr = head;
        boolean is_cycle = false;

        do{
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
            if(fast_ptr == slow_ptr){
                is_cycle = true;
                break;
            }
            if(fast_ptr == null){
                System.out.println("Its a NULL Terminated Loop");
                return;
            }

        }while(fast_ptr.next != null);

        if(is_cycle) {
            int len = 0;
            fast_ptr = fast_ptr.next;
            while (fast_ptr != slow_ptr) {
                fast_ptr = fast_ptr.next;
                ++len;
            }
            System.out.println("The length of the Loop is :" + len);
        }
    }

    public static void main(String[] args){
        LinkedList node = new LinkedList();
        node.addBeg(1);node.addEnd(2);node.addEnd(3);
        node.addBeg(4);node.addEnd(5);node.addEnd(6);
    }
}
