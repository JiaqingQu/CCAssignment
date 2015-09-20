package ch2;

import java.util.List;

public class Solution07 {

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

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        System.out.println("Case 1:");
        System.out.print("List 1 is: ");
        printList(n1);
        System.out.print("List 2 is: ");
        printList(n2);
        System.out.println(isIntersec(n1, n2));
        System.out.println("Case 2:");
        System.out.print("List 1 is: ");
        printList(n1);
        System.out.print("List 2 is: ");
        printList(n4);
        System.out.println(isIntersec(n1,n4));

    }

    /**
     * If two lists end at the same node, they are intersected
     * */
    public static boolean isIntersec(ListNode l1, ListNode l2){
        if((l1 == null) || (l2 == null))
            return false;

        int length1 = 0;
        int length2 = 0;

        ListNode n1 = l1;
        while (n1 != null){
            n1 = n1.next;
            length1++;
        }

        ListNode n2 = l2;
        while(n2 != null){
            n2 = n2.next;
            length2++;
        }

        n1 = l1;
        n2 = l2;
        int diff = Math.abs(length1 - length2);

        if(length1 > length2)
           n1 = moveNBehind(n1, diff);
        else
           n2 = moveNBehind(n2, diff);

//        System.out.println(n1.val);
//        System.out.println(n2.val);

        while(n1.next != null){
            n1 = n1.next;
            n2 = n2.next;
        }

        if(n1 == n2)
            return true;
        else
            return false;

    }

    public static ListNode generateList(int[] num){
        if(num.length == 0)
            return null;

        ListNode head = new ListNode(num[0]);

        for(int i = 1; i < num.length; i++){
            head.appendToTail(num[i]);
        }

        return head;

    }

    public static void printList(ListNode head){
        ListNode n = head;

        while(n!=null) {
            System.out.print(n.val + " ");
            n = n.next;
        }

        System.out.println();


    }

    public static ListNode moveNBehind(ListNode l, int n){
        for(int i = 1; i <= n; i++)
            l = l.next;

        return l;
    }

}