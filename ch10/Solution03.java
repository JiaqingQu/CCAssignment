package ch10;

public class Solution03 {

    public static void main(String[] args) {
        int[] input = {3,5,7,9,1,2};


        System.out.println(searchSortedArray(input, 7, 0, 5));
    }

    /**
     *
     * */
    private static int searchSortedArray(int[] input, int target, int start, int end){

        if (start + 1 == end) {
            if (input[start] == target) {
                return start;
            }
            if (input[end] == target) {
                return end;
            } else {
                return -1;
            }
        }

        int middlePos = (start + end) / 2;
        int middleVal = input[middlePos];

        int pos = -1;

        if(middleVal >= input[start]){
            if((target >= input[start]) && (target <= middleVal)){
                pos = searchSortedArray(input, target, start, middlePos);
            } else {
                pos = searchSortedArray(input, target, middlePos, end);
            }
        } else {
            if((target >= middleVal) && (target <= input[end])){
                pos = searchSortedArray(input, target, middlePos, end);
            } else {
                pos  = searchSortedArray(input, target, start, middlePos);
            }

        }

        return pos;
    }



}
