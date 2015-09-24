package ch4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution12 {

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
        System.out.println("Generated Tree is .. ");

        System.out.format("The number of path of sum 3 is: %d\n", getPathSum(n1, 3));

    }

    public static int getPathSum(BinaryTreeNode n, int sum){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();   // key: sum of path, value: number of that sum path
        getPathSumHelper(n, map);

        if(map.containsKey(sum))
            return map.get(sum);
        else
            return 0;
    }

    /**
     * [Reference: This solution's idea is drawn from the discussion with Jun Zhou ]
     * Use recursion to get every sum of path whose end node is current node
     * Count every path in each step
     * */
    private static ArrayList<Integer> getPathSumHelper(BinaryTreeNode n, HashMap<Integer, Integer> map) {
        if(n == null)
            return null;

        ArrayList<Integer> list = new ArrayList();
        ArrayList<Integer> left = getPathSumHelper(n.lChild, map);
        ArrayList<Integer> right = getPathSumHelper(n.rChild, map);

        // count all the path from the left
        if(left != null) {
            for(int i = 0; i < left.size(); i++){
                int pathSum = left.get(i) + n.val;

                if(map.containsKey(pathSum)) {
                    int count = map.get(pathSum) + 1;
                    map.put(pathSum, count);
                } else {
                    map.put(pathSum, 1);
                }

                list.add(pathSum);
            }
        }
        // count all the path from right
        if(right != null){
            for(int i = 0; i < right.size(); i++){
                int pathSum = right.get(i) + n.val;

                if(map.containsKey(pathSum)) {
                    int count = map.get(pathSum) + 1;
                    map.put(pathSum, count);
                } else {
                    map.put(pathSum, 1);
                }

                list.add(pathSum);
            }

        }

        // count the node itself
        if(map.containsKey(n.val)) {
            int count = map.get(n.val) + 1;
            map.put(n.val, count);
        } else {
            map.put(n.val, 1);
        }

        list.add(n.val);

        return list;

    }




}
