package ch10;

public class Solution09 {

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        int target = 9;

        int[] result = findSortedMatrix(nums, target);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    private static int[] findSortedMatrix(int[][] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;


        int m = nums.length;
        int n = nums[0].length;

        int i  = m - 1;
        int j = 0;

        while ((i >= 0) && (j <= n-1)) {
            int key = nums[i][j];

            if(target > key) {
                j++;
            } else if(target < key) {
                i--;
            } else{
                result[0] = i;
                result[1] = j;

                return result;
            }

        }



        return result;
    }

}
