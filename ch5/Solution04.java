package ch5;

/**
 * Created by qujiaqing on 15/10/26.
 */
public class Solution04 {

    /**
     * Keep adding 1
     * */
    private int getNext(int num) {
        int countOneBit = Integer.bitCount(num);

        int result = num + 1;
        while (Integer.bitCount(result) != countOneBit) {
            result ++;
        }

        return result;
    }

    /**
     * Keep decreasing 1
     * */
    private int getPrev(int num) {
        int countOneBit = Integer.bitCount(num);

        int result = num - 1;
        while (Integer.bitCount(result) != countOneBit) {
            result --;
        }

        return result;
    }


}
