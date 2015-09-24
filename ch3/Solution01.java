package ch3;


import java.util.Scanner;

public class Solution01 {

    /**
     * Partition the array as using index 0,3,6,.. to store elements in the first stack
     *  index 1,4,7.. to store elements in the second stack
     *  index 2,5,8.. to store elements in the third stack
     * */
    private static class MultiStack {
        private static int STACK_FRAME = 1;

        int stackSize = STACK_FRAME;    //the size of each array
        int[] n = new int[3 * STACK_FRAME];  //the array to store all the numbers
        int[] size = new int[3];    //record the size of each stack

        MultiStack(){
            size[0] = 0;
            size[1] = 0;
            size[2] = 0;
        }

        void push(int stackNum, int val){
            if( (size[stackNum]+1) > stackSize){
                this.expand();
            }



            n[size[stackNum] * 3 + stackNum] = val;

            size[stackNum] += 1;

        }

        int peek(int stackNum) throws EmptyStackException{
            if(size[stackNum] == 0) throw new EmptyStackException("Empty Stack");

            return n[size[stackNum] * 3 + stackNum];

        }

        int pop(int stackNum) throws EmptyStackException{
            if(size[stackNum] == 0) throw new EmptyStackException("Empty Stack");

            int num = n[(size[stackNum] - 1) * 3 + stackNum];
            size[stackNum]--;

            return num;
        }

        private void expand(){
            int[] n_expand = new int[n.length + 3 * STACK_FRAME];

            for (int i = 0; i < n.length; i++){
                n_expand[i] = n[i];
            }

            stackSize += 3 * STACK_FRAME;
            n = n_expand;


        }


    }

    public static void main(String[] args) throws EmptyStackException{
        MultiStack s = new MultiStack();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the numbers to be pushed into the first stack (E.g. 1 2)..");
        if(sc.hasNext()){
            String inputNumStr = sc.nextLine();

            int[] inputNum = getNum(inputNumStr);
            for(int i = 0; i < inputNum.length; i++)
                s.push(0,inputNum[i]);
        }

        System.out.println("Enter the numbers to be pushed into the second stack (E.g. 3 4)..");
        if(sc.hasNext()){
            String inputNumStr = sc.nextLine();

            int[] inputNum = getNum(inputNumStr);
            for(int i = 0; i < inputNum.length; i++)
                s.push(1,inputNum[i]);
        }

        System.out.println("Enter the numbers to be pushed into the second stack (E.g. 5 6)..");
        if(sc.hasNext()){
            String inputNumStr = sc.nextLine();

            int[] inputNum = getNum(inputNumStr);
            for(int i = 0; i < inputNum.length; i++)
                s.push(2,inputNum[i]);
        }

        System.out.println("Pop from the first stack.. ");
        System.out.println(s.pop(0));
        System.out.println("Pop from the first stack.. ");
        System.out.println(s.pop(0));
        System.out.println("Peek the second stack.. ");
        System.out.println(s.pop(1));





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
