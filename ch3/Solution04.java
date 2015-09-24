package ch3;

import java.util.Scanner;
import java.util.Stack;

public class Solution04 {

    /**
     * Use one stack to store all the newly inserted elements, use another stack to store all the old elements
     * Whenever the stack of old elements is empty, 'pour' all the newly inserted ones into it
     * */
    private static class MyQueue{
        Stack newStack = new Stack();
        Stack oldStack = new Stack();

        void enqueue(int i){
            newStack.push(i);
        }

        int dequeue(){
            if(!oldStack.isEmpty())
                return (Integer)oldStack.pop();

            while(!newStack.isEmpty())
                oldStack.push(newStack.pop());

            return (Integer)oldStack.pop();
        }

        int peek(){
            if(!oldStack.isEmpty())
                return (Integer)oldStack.peek();

            while(!newStack.isEmpty())
                oldStack.push(newStack.pop());

            return (Integer)oldStack.peek();
        }

    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers to be pushed into the queue (E.g. 1 2)..");
        if(sc.hasNext()) {
            String inputNumStr = sc.nextLine();

            int[] inputNum = getNum(inputNumStr);
            for (int i = 0; i < inputNum.length; i++)
                q.enqueue(inputNum[i]);

        }

        System.out.format("Dequeue one number: %d\n",q.dequeue());

    }

    private static int[] getNum(String s){
        String[] inputNumStrArr = s.split(" ");

        int[] inputNum = new int[inputNumStrArr.length];
        for(int i = 0; i < inputNum.length; i++)
            inputNum[i] = Integer.parseInt(inputNumStrArr[i]);

        return inputNum;
    }


}
