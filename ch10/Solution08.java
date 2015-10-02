package ch10;

public class Solution08 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findDuplicateNum(nums));
    }

    /**
     * Use bit vector (byte array) to indicate the the existence of a number
     * */
    private static int findDuplicateNum(int[] nums){
        byte[] bitVector = new byte[4000];

        for(int i = 0; i < nums.length; i++){
            int byteIndex = nums[i]/8;
            int byteOffset = nums[i]%8;

            // the number hasn't been there before
            if((bitVector[byteIndex] & (1 << byteOffset)) == 0) {
                bitVector[byteIndex] |= (1 << byteOffset);
            } else {
                return nums[i];
            }
        }

        return -1;
    }

}
