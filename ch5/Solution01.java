package ch5;

public class Solution01 {

    public static void main(String[] args) {
        int n = Integer.parseInt("1000001100",2);
        int m = Integer.parseInt("10011",2);
        int i = 2;
        int j = 6;
        int result = bitInsertion(n, m, i, j);

        System.out.format("Number n is %s, m is %s, i is %d, j is %d\n",
                Integer.toBinaryString(n),Integer.toBinaryString(m), i, j);
        System.out.format("The result is %s\n",Integer.toBinaryString(result));
    }

    /**
     * 1. Clear the bits on positions j to i of n
     * 2. Move m i positions left and do the 'OR' operation with n
     * */
    private static int bitInsertion(int n, int m, int i, int j){

        // clear the positions of j to i of n
        for(int k = i; k <= j; k++) {
            int mask = ~(1 << k);
            n = n & mask;
        }

        // move m i positions left and 'OR' with n
        m = m << i;

        return n | m;

    }




}
