package ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution07 {

    public static void main(String[] args) {
        int missInt = findMissingInt("ch10/test.txt");

        System.out.println(missInt);


    }

    /**
     * Use bit vector (array of byte) to represent the existence of a certain number
     * */
    private static int findMissingInt(String filePath){
        try {
            Scanner sc = new Scanner(new FileReader(filePath));

            byte[] bitVector = new byte[500000000];

            // record all the integers in the bit vector
            while (sc.hasNext()){
                int i = sc.nextInt();

                int byteIndex = i/8;
                int byteOffset = i%8;

                bitVector[byteIndex] |= (1 << byteOffset);
            }

            // find the missing int
            for(int i = 0; i < 1000000000; i++){
                for(int j = 0; j < 8; j++){
                    if((bitVector[i] & (1 << j)) == 0) {
                        return 8 * i + j;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return -1;

    }



}
