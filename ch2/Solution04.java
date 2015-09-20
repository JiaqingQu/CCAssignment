package ch2;


import java.util.List;
import java.util.Scanner;

public class Solution04 {

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

        System.out.println("Enter the list (E.g. 5 3 6 4 8)..");
        inputNumStr = sc.nextLine();

        String[] inputNumStrArr = inputNumStr.split(" ");

        inputNum = new int[inputNumStrArr.length];
        for (int i = 0; i < inputNum.length; i++)
            inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

        ListNode list = generateList(inputNum);

        System.out.println("Enter the partition number (E.g. 5)..");
        int k = sc.nextInt();

        ListNode sortedList = partition(list,k);

        printList(sortedList);


    }

    /**
     * Use two lists to sort all the nodes, one with larger nodes, the other with smaller nodes
     * */
    public static ListNode partition(ListNode head, int k){
        ListNode sHead = new ListNode(-1); //dummy head
        ListNode lHead = new ListNode(-1); //dummy head

        ListNode sTail = sHead;
        ListNode lTail = lHead;

        ListNode n = head;
        while (n != null){
            if(n.val < k){
                sTail.next = n;
                sTail = sTail.next;
            } else {
                lTail.next = n;
                lTail = lTail.next;
            }

            n  = n.next;
        }

        //append the large list to the small list
        sTail.next = lHead.next;
        lTail.next = null;

        //adjust the head of the small list to delete the dummy node
        return sHead.next;




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
