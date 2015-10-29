package ch6;

import java.util.Random;

public class Solution07 {

    /**
     * Answer:
     *  The gender ratio will be 1
     *
     *  n = 1, P(G) = 1/2
     *  n = 2, P(BG) = 1/4
     *  n = 3, P(BBG) = 1/8
     *  ...
     *
     *  We can calculate the gender ratio using these probabilities, when n approximate infinity, the gender ratio will be 1
     *
     * */

    /**
     * Simulation program
     * */
    int[] oneFamily() {
        Random r = new Random();

        int boy = 0;
        int girl = 0;
        while (r.nextBoolean() != true) {
            boy ++;
        }
        girl = 1;

        int[] result = new int[2];
        result[0] = boy;
        result[1] = girl;

        return result;
    }

    double simulate() {
        int boy = 0;
        int girl = 0;

        int n = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] gender = oneFamily();

            boy = boy + gender[0];
            girl = girl + gender[1];
        }

        return boy/girl;
    }


}
