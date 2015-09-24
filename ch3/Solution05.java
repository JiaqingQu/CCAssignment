package ch3;

import java.util.Scanner;
import java.util.Stack;

public class Solution05 {

    /**
     * Use one stack to contain the sorted element, whenever a new element comes in, it compared with the top of the sorted stack
     * */
    private static class SortStack {
        Stack s = new Stack();
        Stack sort = new Stack();

        SortStack() {

        }

        void push(int i){
            if(sort.isEmpty())
                sort.push(i);
            if(i <= (Integer)sort.peek())
                sort.push(i);
            else {
                while (!sort.isEmpty())
                    s.push(sort.pop());

                sort.push(i);

                while (!s.isEmpty())
                    sort.push(s.pop());
            }
        }

        int pop() throws EmptyStackException{
            if(sort.isEmpty()) throw new EmptyStackException("Empty Stack");

            return (Integer)sort.pop();
        }

        int peek() throws EmptyStackException{
            if(sort.isEmpty()) throw new EmptyStackException("Empty Stack");

            return (Integer)sort.pop();
        }

        boolean isEmpty(){
            return sort.isEmpty();
        }


    }

    public static void main(String[] args) throws EmptyStackException{
        SortStack s = new SortStack();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers to be pushed into the queue (E.g. 1 2)..");
        if(sc.hasNext()) {
            String inputNumStr = sc.nextLine();

            int[] inputNum = getNum(inputNumStr);
            for (int i = 0; i < inputNum.length; i++)
                s.push(inputNum[i]);

        }

        System.out.format("The top of the stack is: %d\n", (Integer) s.peek());
    }

    private static class EmptyStackException extends Exception{
        EmptyStackException(String s) {
            super(s);
        }
    }

    private static int[] getNum(String s){
        String[] inputNumStrArr = s.split(" ");

        int[] inputNum = new int[inputNumStrArr.length];
        for(int i = 0; i < inputNum.length; i++)
            inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

        return inputNum;
    }






}
