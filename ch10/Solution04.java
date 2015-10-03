package ch10;

public class Solution04 {

    private static class Listy {
        private int[] nums;

        Listy(int[] nums) {
            this.nums = nums;
        }

        int elementAt(int i){
            if(i > nums.length - 1) {
                return -1;
            } else {
                return nums[i];
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,3,7,8,8,9};

        Listy list = new Listy(nums);

        System.out.println(sortWithoutSize(list,8));

    }

    /**
     * Find the size of the list by exponentially expand the range
     * When end is out of the range of list, begin binary search
     * */
    private static int sortWithoutSize(Listy list, int target) {
        int start = 0;
        int end = 1;

        // find the size of the list
        while(list.elementAt(end) != -1){
            end = end * 2;
        }

        // do the binary search
        while (start + 1 < end){
            int midPos = start + (end - start)/2;
            int midVal = list.elementAt(midPos);

            if((target < midVal) || (midVal == -1)){
                end = midPos;
            } else if(target > midVal) {
                start = midPos;
            } else if(target == midVal) {
                return midPos;
            }

        }

        if(list.elementAt(start) == target) {
            return start;
        } else if(list.elementAt(end) == target){
            return end;
        } else
            return -1;

    }


}
