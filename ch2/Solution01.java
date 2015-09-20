package ch2;


import java.util.HashSet;
import java.util.Scanner;

public class Solution01 {


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
        System.out.println("Enter the list (E.g. 1 2 3 3)..");

        String inputNumStr = "";
        int[] inputNum;

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            inputNumStr = sc.nextLine();

            String[] inputNumStrArr = inputNumStr.split(" ");

            inputNum = new int[inputNumStrArr.length];
            for(int i = 0; i < inputNum.length; i++)
                inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

            ListNode list = generateList(inputNum);

            removeDul(list);

            printList(list);
        }

    }

    /**
     * Use HashSet to store all the element
     * */
    public static void removeDul(ListNode head){
        // an empty list
        if(head == null)
            return;

        HashSet<Integer> s = new HashSet<Integer>();

        ListNode prev = head;
        ListNode n = prev.next;

        while(n!=null){
            s.add(prev.val);
            if(!s.contains(n.val)){
                prev = prev.next;
                n = n.next;
            }
            //if n occurs before, delete this node
            else{
                prev.next = n.next;
                n = prev.next;
            }
        }

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
