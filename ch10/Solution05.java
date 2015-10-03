package ch10;

public class Solution05 {

    public static void main(String[] args) {
        String[] input = {"at","","","baby","","","cat", "", "", "", "", "ddd", "eeee", "", "", "", "zzz"};

        System.out.println(sparseSearch(input,"ddd"));
    }


    private static int sparseSearch(String[] input, String target) {
        int start = 0;
        int end = input.length - 1;


        while (true) {
            // calcuate midValue
            int midPos = start + (end - start)/2;
            String midVal = input[midPos];


            // update midPosition if empty
            if (midVal.isEmpty()) {

                while (midVal.isEmpty() && (midPos >= start)) {
                    midVal = input[--midPos];
                }

                if (midPos++ == start) {

                    while (midVal.isEmpty() && midPos <= end) {
                        midVal = input[midPos++];
                    }
                }
            }

//            int oldStart = start;
//            int oldEnd = end;

            if (midVal.compareTo(target) < 0) {
                start = midPos;
            } else if (midVal.compareTo(target) > 0) {
                end = midPos;
            } else {
                return midPos;
            }

            if(midPos == end) {
                break;
            }



        }

        return -1;

    }

}
