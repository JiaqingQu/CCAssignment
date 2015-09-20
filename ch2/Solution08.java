package ch2;

import java.util.List;

public class Solution08 {

    /**
     * [Reference] The ListNode class is copied from the book
     * */
    private static class ListNode {
        ListNode next = null;
        int val;

        public ListNode(){};

        public ListNode(int n){
            val = n;
        }

        void appendToTail(int d){
            ListNode endNode = new ListNode(d);

            ListNode n = this;
            while(n.next!=null){
                n = n.next;
            }

            n.next = endNode;
        }

    }


    /**
     * Use the two fast and slow pointer's approach -
     *  1. When two pointers catch each other, move one pointer to the head and let both pointer go with the same speed until they meet each other
     *  2. If the fast pointer reach the end of the list, then there is no cycle
     * */
    public static void main(String[] args){
        System.out.println("Case 1:");
        System.out.println("The loop list is 1 -> 2 -> 3 -> 4 -> 2");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println("The beginning of the loop is..");
        ListNode loopNode = checkLoop(n1);
        System.out.println(loopNode == null ? Integer.MIN_VALUE : loopNode.val);

        System.out.println("Case 2:");
        System.out.println("The loop list is 1 -> 2 -> 3 -> 4");
        n4.next = null;
        System.out.println("The beginning of the loop is..");
        loopNode = checkLoop(n1);
        System.out.println(loopNode == null ? Integer.MIN_VALUE : loopNode.val);

        System.out.println("Case 3:");
        System.out.println("The loop list is 1");
        n1.next = null;
        System.out.println("The beginning of the loop is..");
        loopNode = checkLoop(n1);
        System.out.println(loopNode == null ? Integer.MIN_VALUE : loopNode.val);


    }

    public static ListNode checkLoop(ListNode l){
        //check corner case
        if((l == null) || (l.next == null))
            return null;

        ListNode p1 = l;    // slower pointer
        ListNode p2 = l;    // faster pointer

       do {
            p1 = p1.next;
            p2 = p2.next.next;
        } while((p2 != null) && (p2.next != null) && (p1 != p2));

        if((p2 == null) || (p2.next == null))
            return null;
        else {
            p2 = l;

            while (p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1;

        }
    }

    public static void printList(ListNode head){
        ListNode n = head;

        while(n!=null) {
            System.out.print(n.val + " ");
            n = n.next;
        }

        System.out.println();


    }



}
