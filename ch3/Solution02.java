package ch3;

import java.util.Scanner;

public class Solution02 {

    private static class StackNode {
        int val;
        StackNode next;

        StackNode(int i) {
            val = i;
        }

    }

    /**
     * Use two stacks to implement the min function - pop the top element from stack1 and store it in stack2,
     * whenever the top element is smaller than the current min value, pop it out and update the min value
     * */
    private static class MyStack {
        StackNode top;

        MyStack(){

        }

        void push(int i){
            StackNode n = new StackNode(i);

            n.next = top;
            top = n;
        }

        int pop() throws EmptyStackException{
            if (top == null) throw new EmptyStackException("Empty Stack");

            int val = top.val;
            top = top.next;

            return val;
            //
        }

        int peek() throws EmptyStackException{
            if(top == null) throw new EmptyStackException("Empty Stack");

            return top.val;
        }

        /**
         * Use another stack to find the minimum value of the stack
         * Scanning the stack from top to bottom, whenever when we encounter a smaller number, add that into the minStack
         * Return Integer.MIN_VALUE if there is no element in the stack
         * */
        int min() throws EmptyStackException{
            if(top == null) throw new EmptyStackException("Empty Stack");

            //find the minimum value
            int currentMin = top.val;

            MyStack minStack = new MyStack();
            StackNode n = top;
            while (n != null){
                if(n.val < currentMin) {
                    currentMin = n.val;
                    minStack.push(n.val);
                }

                n = n.next;
            }

            //restore the original stack
            n = minStack.top;
            while (n != null) {
                this.push(n.val);

                n = n.next;
            }

            return currentMin;
        }
    }

    public static void main(String[] args) throws EmptyStackException{

        System.out.println("Enter the numbers to be pushed into the stack (E.g. 3 5 7 8 1 9)..");

        String inputNumStr = "";
        int[] inputNum;

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            inputNumStr = sc.nextLine();

            String[] inputNumStrArr = inputNumStr.split(" ");

            inputNum = new int[inputNumStrArr.length];
            for(int i = 0; i < inputNum.length; i++)
                inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

            MyStack s = generateStack(inputNum);

            System.out.format("The smallest number in the stack is %d\n",s.min());

        }


    }

    private static MyStack generateStack(int[] nums){
        MyStack s = new MyStack();

        for(int i = 0; i < nums.length; i++)
            s.push(nums[i]);

        return s;

    }

    private static class EmptyStackException extends Exception{
        EmptyStackException(String s) {
            super(s);
        }
    }







}
