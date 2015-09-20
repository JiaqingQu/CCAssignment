package ch2;

import java.util.List;
import java.util.Scanner;

public class Solution03 {

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
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//
//        n1.next = n2;
//        n2.next = n3;
//
//        System.out.println("The list created is..");
//        printList(n1);
//
//        deleteMiddleNode(n2);
//        System.out.println("After deletion..");
//        printList(n1);

        String inputNumStr = "";
        int[] inputNum;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the list (E.g. 1 2 3 4)..");
        inputNumStr = sc.nextLine();

        String[] inputNumStrArr = inputNumStr.split(" ");

        inputNum = new int[inputNumStrArr.length];
        for (int i = 0; i < inputNum.length; i++)
            inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

        ListNode[] n = new ListNode[inputNum.length];
        for(int i = 0; i < n.length; i++)
            n[i] = new ListNode(inputNum[i]);

        for(int i = 0; i < n.length - 1; i++)
            n[i].next = n[i+1];

        System.out.println("Input the ith delete node (E.g. 2 )..");
        int k  = sc.nextInt();

        deleteMiddleNode(n[k]);

        printList(n[0]);


    }

    /**
     * Replace the target node with its next node and delete the next one
     * */
    public static void deleteMiddleNode(ListNode d){

        d.val = d.next.val;
        d.next = d.next.next;

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
