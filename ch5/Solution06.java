package ch5;

public class Solution06 {


    /**
     * Xor operation can get the bit different position
     * */
    private int countFlip (int num1, int num2) {
        int xor = num1 ^ num2;

        return Integer.bitCount(xor);
    }
}

