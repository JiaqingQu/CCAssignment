package ch5;


public class Solution07 {

    /**
     * Mask the even bits and shift left by 1 position, mask the odd bits and shift right by 1 position
     * */
    private int swapBit(int num) {
        int result =  ((num & 0x55555555) << 1) | ((num & 0xAAAAAAAA) >>> 1);

        return result;
    }

}
