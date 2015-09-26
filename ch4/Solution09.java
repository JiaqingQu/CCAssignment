package ch4;

import java.util.ArrayList;

public class Solution09 {

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode lChild = null;
        BinaryTreeNode rChild = null;
        BinaryTreeNode p = null;

        BinaryTreeNode(int i) {
            val = i;
        }

        void setlChild(BinaryTreeNode l) {
            lChild = l;
            l.p = this;
        }

        void setrChild(BinaryTreeNode r) {
            rChild = r;
            r.p = this;
        }

    }


    public static void main(String[] args) {


    }


    /**
     * [Reference: I discussed this question with Jun Zhou]
     * Get all the inputs of the left child and right child then combine them together
     * */
    private static ArrayList<ArrayList<Integer>> getInput(BinaryTreeNode node){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(node.lChild == null && node.rChild == null){
            ArrayList<Integer> input = new ArrayList<Integer>();
            input.add(node.val);
            result.add(input);

            return result;
        }


        ArrayList<ArrayList<Integer>> leftInput = getInput(node.lChild);
        ArrayList<ArrayList<Integer>> rightInput = getInput(node.rChild);

        for(ArrayList<Integer> leftArray : leftInput){
            for(ArrayList<Integer> rightArray : rightInput){
                ArrayList<ArrayList<Integer>> oneCombination = getAllCombination(leftArray,rightArray);

                for(ArrayList<Integer> array : oneCombination){
                    array.add(0, node.val);
                    result.add(array);
                }
            }

        }


        return result;

    }

    /**
     * The combination rule is to maintain the relative position of each input and mix them together
     * */
    private static ArrayList<ArrayList<Integer>> getAllCombination(ArrayList<Integer> left,
                                                                   ArrayList<Integer> right) {

        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        getAllCombination(new ArrayList<Integer>(), left, right, results);

        return results;
    }

    private static void getAllCombination(ArrayList<Integer> prefix,
                                                                   ArrayList<Integer> left,
                                                                   ArrayList<Integer> right,
                                                                   ArrayList<ArrayList<Integer>> results) {
        if(left.isEmpty() && right.isEmpty()){
            results.add(((ArrayList<Integer>) prefix.clone()));
        }


        // delete left, add it to prefix
        if (!left.isEmpty()) {
            int leftFirst = left.remove(0);
            prefix.add(leftFirst);
            getAllCombination(prefix, left, right, results);

            // revert change
            // delete right and add it to prefix
            left.add(0, leftFirst);
            prefix.remove(prefix.size() - 1);

        }
        if (!right.isEmpty()) {
            int rightFirst = right.remove(0);
            prefix.add(rightFirst);
            getAllCombination(prefix, left, right, results);

            // revert change
            prefix.remove(prefix.size() - 1);
            right.add(0,rightFirst);
        }

    }




}
