package ch10;

import java.util.Arrays;

public class Solution11 {

    public static void main(String[] args) {
        int[] input = {1};

        int[] output = peakAndValley(input);

        System.out.println(Arrays.toString(output));
    }

    private static int[] peakAndValley(int[] input) {
        int i = 0;

        for(i = 0; i < input.length - 2; i = i + 2){
            int maxPos = maxPos(input, i);

            // swap the largest value in the current 3 nodes into the middle
            if(maxPos != (i+1)) {
                int tmp = input[i+1];
                input[i+1] = input[maxPos];
                input[maxPos] = tmp;
            }
        }

        // one more element left
        if((i + 3) < input.length) {
            if(input[i+3] < input[i+2]){
                int tmp = input[i + 2];
                input[i + 2] = input[i + 3];
                input[i + 3] = tmp;
            }
        }

        return input;
    }

    private static int maxPos(int[] input, int i){
        if((input[i] >= input[i+1]) && (input[i] >= input[i+2])) {
            return i;
        } else if((input[i+1] >= input[i]) && (input[i+1] >= input[i+2])){
            return i+1;
        } else {
            return i+2;
        }
    }
}
