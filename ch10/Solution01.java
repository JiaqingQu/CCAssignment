package ch10;

public class Solution01 {

    public static void main(String[] args) {
        int[] a = {1,3,5,6,8,9,0,0,0,0};
        int[] b = {};

        int[] result = sortedMerge(a, b, 6);

        for(int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }

    /**
     * Process the list from end to front
     * Maintain two pointers with one pointing to a, the other pointing to b,
     *  find the max value of pointer A and pointer B and decrease the pointer
     * */
    private static int[] sortedMerge(int[] a, int[] b, int lengthA){

        int n = lengthA + b.length - 1;

        int i = lengthA - 1;
        int j = b.length - 1;

        while(n >= 0){
            int maxNum = -1;

            if((i >= 0) && (j >=0)){
                if(a[i] >= b[j]){
                    maxNum = a[i];
                    i--;
                }
                else{
                    maxNum = b[j];
                    j--;
                }
            }
            else {
                if(i >= 0){
                    maxNum = a[i];
                    i--;
                }
                if(j >= 0){
                    maxNum = b[j];
                    j--;
                }
            }

            a[n] = maxNum;

            n--;
        }


        return a;
    }

}
