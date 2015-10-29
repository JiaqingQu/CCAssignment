package ch5;


import java.util.ArrayList;
import java.util.Arrays;

public class Solution03 {

    public static void main(String[] args) {
//        maxSeqByFlip(Integer.parseInt("0100010",2));
        int num = Integer.parseInt("1110101",2);
//        ArrayList<Integer>  seq = getSequence(num);
//
//        System.out.println(Arrays.toString(seq.toArray()));

        System.out.println(maxSeqByFlip(num));

    }


    /**
     * Regard the num by sequence of 0 and 1, e.g. [2*0][3*1]..
     * Each time encountering a 0 seq, update the maxFlipSeq
     * */
    private static int maxSeqByFlip(int num){

        ArrayList<Integer> sequence = new ArrayList<Integer>();

        // scan the number and get the sequence representation
        sequence = getSequence(num);


        // Check the corner case
        // the binary representation only contains 0
        if(sequence.size() == 1) {
            return 1;
        }

        int maxSeqByFlip = 0;

        if(sequence.get(0) == 0) {
            maxSeqByFlip = sequence.get(1);
        } else {
            maxSeqByFlip = sequence.get(1) + 1;
        }

        int i = 2;

        for(i = 2; i < sequence.size() - 1; i = i + 2) {
            int seq = 0;

            if(sequence.get(i) == 1) {
                seq = sequence.get(i - 1) + sequence.get(i + 1) + 1;
            } else {
                seq = Math.max(sequence.get(i - 1), sequence.get(i + 1)) + 1;
            }

            if (seq > maxSeqByFlip) {
                maxSeqByFlip = seq;
            }
        }

        if((i + 2) < sequence.size()) {
            int seq = sequence.get(sequence.size() - 1) + 1;
            if(seq > maxSeqByFlip)
                maxSeqByFlip = seq;
        }

        return maxSeqByFlip;

    }

    private static ArrayList<Integer> getSequence(int num){
        ArrayList<Integer> result = new ArrayList<Integer>();

        // the first position in the result should always indicate 0
        if((num & 1) != 0)
            result.add(0);

        int currentBit = num & 1;
        int counter = 0;
        for(int i = 0; i < 32; i++) {
            if((num & 1) == currentBit) {
                counter++;
            }
            else {
                result.add(counter);
                counter = 1;
                currentBit = currentBit ^ 1;
            }


            num = num >>> 1;
        }

        return result;

    }



}
