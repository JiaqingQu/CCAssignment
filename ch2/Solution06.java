package ch2;

import java.util.Scanner;

public class Solution06 {

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

        System.out.println("Enter the list1 (E.g. 1 2 3 3 2 1)..");
        inputNumStr = sc.nextLine();

        String[] inputNumStrArr = inputNumStr.split(" ");

        inputNum = new int[inputNumStrArr.length];
        for (int i = 0; i < inputNum.length; i++)
            inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

        ListNode l = generateList(inputNum);

        System.out.println(isPalindrome(l));

//        ListNode reverseList = reverse(l);

//        printList(reverseList);

    }

    /**
     * Use the two runners approach to solve the problem
     * Traverse the last half part then compare the two lists
     * */
    public static boolean isPalindrome(ListNode l){
        ListNode p1 = l; // lower pointer
        ListNode p2 = l; // fast pointer

        if(p1.next == null)
            return true;
        if(p1.next.next == null){
            if(p1.val == p1.next.val)
                return true;
            else
                return false;
        }

        while((p2 != null) && (p2.next != null)){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // move p2 to the head
        p2 = l;

        //reverse the last half part
        ListNode lastHalf = reverse(p1);
        ListNode firstHalf = p2;

        ListNode n1 = firstHalf;
        ListNode n2 = lastHalf;

        while(n2.next != null){
            if(n1.val != n2.val)
                return false;
            else {
                n1 = n1.next;
                n2 = n2.next;
            }
        }

        return true;

    }

    public static ListNode reverse(ListNode l){
        if((l == null) || (l.next == null))
            return l;

        ListNode prev = null;
        ListNode n = l;
        ListNode next = n.next;

        while(n != null){
            next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }

        return prev;
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


