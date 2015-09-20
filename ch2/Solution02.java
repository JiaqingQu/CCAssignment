package ch2;

import java.util.Scanner;

public class Solution02 {

    /**
     * [Reference] The ListNode class is copied from the book
     */
    private static class ListNode {
        ListNode next = null;
        int val;

        public ListNode() {
        }

        ;

        public ListNode(int n) {
            val = n;
        }

        void appendToTail(int d) {
            ListNode endNode = new ListNode(d);

            ListNode n = this;
            while (n.next != null) {
                n = n.next;
            }

            n.next = endNode;
        }

    }

    public static void main(String[] args) {


        String inputNumStr = "";
        int[] inputNum;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the list (E.g. 1 2 3 4)..");
        inputNumStr = sc.nextLine();

        String[] inputNumStrArr = inputNumStr.split(" ");

        inputNum = new int[inputNumStrArr.length];
        for (int i = 0; i < inputNum.length; i++)
            inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

        ListNode list = generateList(inputNum);

        System.out.println("Enter the kth last you want to get (E.g. 2)..");
        int k = sc.nextInt();

        int kthLastNum = kthLast(list, k);

        System.out.println(kthLastNum);

    }

    /**
     * Use two pointers whose distance is k - 1 to scan the list until the tail pointer reach the last
     */
    public static int kthLast(ListNode headList, int k) {
        //empty list
        if (headList == null)
            return Integer.MIN_VALUE;

        // set the head and tail pointer, if k < length of list, return MIN_VALUE
        ListNode head = headList;
        ListNode tail = headList;
        for (int i = 1; i <= k - 1; i++) {
            tail = tail.next;

            if (tail == null)
                return Integer.MIN_VALUE;
        }

        // move the pointers to the end
        while (tail != null) {
            head = head.next;
            tail = tail.next;
        }

        return head.val;

    }

    public static ListNode generateList(int[] num) {
        if (num.length == 0)
            return null;

        ListNode head = new ListNode(num[0]);

        for (int i = 1; i < num.length; i++) {
            head.appendToTail(num[i]);
        }

        return head;

    }

    public static void printList(ListNode head) {
        ListNode n = head;

        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }

        System.out.println();


    }


}
