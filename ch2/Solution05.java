package ch2;

import java.util.List;
import java.util.Scanner;

public class Solution05 {

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

        String inputNumStr = "";
        int[] inputNum;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the list1 (E.g. 7 1 6)..");
        inputNumStr = sc.nextLine();

        String[] inputNumStrArr = inputNumStr.split(" ");

        inputNum = new int[inputNumStrArr.length];
        for (int i = 0; i < inputNum.length; i++)
            inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

        ListNode list1 = generateList(inputNum);
        printList(list1);

        System.out.println("Enter the list (E.g. 5 9 2)..");
        inputNumStr = sc.nextLine();

        inputNumStrArr = inputNumStr.split(" ");

        inputNum = new int[inputNumStrArr.length];
        for (int i = 0; i < inputNum.length; i++)
            inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

        ListNode list2 = generateList(inputNum);
        printList(list2);

        ListNode result = addList(list1,list2);
        printList(result);

    }

    public static ListNode addList(ListNode l1, ListNode l2){
        return addListHelper(l1,l2,0);
    }

    /**
     * For every digit in the result list, it values = l1.digit + l2.digit + carry
     * [Reference: I resorted the answer from the book to help myself have better understand of the recursive idea..
     *             The code is hardly the same but I wrote it based on my understanding.
     * ]
     * */
    public static ListNode addListHelper(ListNode l1, ListNode l2, int carry){
        //Base case
        if((l1 == null) && (l2 == null) && (carry == 0))
            return null;

        ListNode result = new ListNode();

        int val = carry;
        if(l1 != null)
            val += l1.val;
        if(l2 != null)
            val += l2.val;

        result.val = val % 10;

        if((l1 != null) || (l2 != null)){
            ListNode nextL1 = (l1 != null) ? l1.next: null;
            ListNode nextL2 = (l2 != null) ? l2.next: null;
            carry = (val > 10 ) ? 1: 0;

            result.next = addListHelper(nextL1,nextL2,carry);
        }

        return result;

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


}
