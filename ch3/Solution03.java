package ch3;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution03 {

    /**
     * FOLLOW-UP:
     * There are two ways we can do it:
     *  1. Simply pop the node in that certain stack and leave that stack with no-full capacity.
     *     Pros & Cons: This is easy to implement. However, we may leave many empty pointers after many operations,
     *      which is very space-consuming.
     *  2. Write a shift function that pop the element in the next stack and put it in the bottom of the current stack.
     *      Whenever popAt(int index) is called, call that shift function for every stacks which are later than index and before the last one.
     *     Pros & Cons: This makes sure that every sub stacks are in their full capacity. However, this is very time-consuming.
     *      Since every time popAt is called, all the elements afterwards will be touched.
     * */

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
