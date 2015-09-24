package ch3;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution03 {

    /**
     * Use an ArrayList to keep track of all the stacks
     * */
    private static class SetOfStacks {

        private static class StackNode {
            int val;
            StackNode next;

            StackNode(int i) {
                val = i;
            }

        }


        private static int THRESHOLD = 2;

        int curStack = 0;    //the pointer to the current stack
        int curHeight = 0;     //the height of the current stack
        ArrayList<StackNode> stacks = new ArrayList<StackNode>();

        void push(int i){
            StackNode n = new StackNode(i);

            if(curHeight == 0){
                stacks.add(n);
                curHeight++;
            } else {
                stacks.get(curStack).next = n;

                curHeight = (curHeight + 1)%THRESHOLD;
                if(curHeight == 0)
                    curStack++;
            }

        }

        int pop() throws EmptyStackException{
            StackNode n = stacks.get(curStack);

            if(n == null) throw new EmptyStackException("Empty Stack");

            if(curHeight == 0) {
                if(curStack == 0) throw new EmptyStackException("Empty Stack");

                curHeight = THRESHOLD - 1;
                curStack--;
                return n.val;
            }


            for(int i = 0; i < curHeight - 1; i++){
                n = n.next;
            }

            curHeight--;

            return n.val;
        }




    }

    public static void main(String[] args) throws EmptyStackException{
        SetOfStacks s = new SetOfStacks();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers to be pushed into the stack (E.g. 1 2)..");
        if(sc.hasNext()){
            String inputNumStr = sc.nextLine();

            int[] inputNum = getNum(inputNumStr);
            for(int i = 0; i < inputNum.length; i++)
                s.push(inputNum[i]);
        }

        System.out.format("Pop from the stack: %d\n",s.pop());
        System.out.format("Pop from the stack: %d\n", s.pop());
        System.out.format("Pop from the stack: %d\n",s.pop());
        System.out.format("Pop from the stack: %d\n",s.pop());

    }

    private static int[] getNum(String s){
        String[] inputNumStrArr = s.split(" ");

        int[] inputNum = new int[inputNumStrArr.length];
        for(int i = 0; i < inputNum.length; i++)
            inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

        return inputNum;
    }

    private static class EmptyStackException extends Exception{
        EmptyStackException(String s) {
            super(s);
        }
    }



}
