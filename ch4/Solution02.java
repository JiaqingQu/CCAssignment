package ch4;

import java.util.*;

public class Solution02 {

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode lChild = null;
        BinaryTreeNode rChild = null;

        BinaryTreeNode(int i){
            val = i;
        }

        void setlChild(BinaryTreeNode l){
            lChild = l;
        }

        void setrChild(BinaryTreeNode r){
            rChild = r;
        }


    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);

        n1.setlChild(n2);
        n1.setrChild(n3);
        n2.setlChild(n4);
        n2.setrChild(n5);

        int[] nums = {3,1,5};
        BinaryTreeNode root = minimumMST(nums);

//        BTreePrinter.printNode(root);
    }

    /**
     * The key point here is the number at the middle position should always be the root of the tree
     * */
    public static BinaryTreeNode minimumMST(int[] nums){
        return minimumMSTHelper(nums, 0, nums.length - 1);
    }

    private static BinaryTreeNode minimumMSTHelper(int[] nums, int s, int e){
        if(e < s)
            return null;


        //recursive
        int rootPos = (s + e)/2;
        int rootNum = nums[rootPos];

        BinaryTreeNode root = new BinaryTreeNode(rootNum);
        BinaryTreeNode lTree = minimumMSTHelper(nums, s, rootPos - 1);
        BinaryTreeNode rTree = minimumMSTHelper(nums, rootPos + 1, e);

        root.setlChild(lTree);
        root.setrChild(rTree);

        return root;
    }






}
