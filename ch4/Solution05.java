package ch4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution05 {


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
        BinaryTreeNode n6 = new BinaryTreeNode(6);
//        n1.setlChild(n2);
//        n1.setrChild(n3);
//        n2.setlChild(n4);
//        n2.setrChild(n5);
        n4.setlChild(n2);
        n4.setrChild(n5);
        n2.setlChild(n1);
        n2.setrChild(n3);
//        n5.setrChild(n6);
        System.out.println("Generated Tree is .. ");

        System.out.println(validateBST(n1));

        //
    }

    public static boolean validateBST(BinaryTreeNode n){
        if(n == null)
            return true;

        if(validateBST(n.lChild) && validateBST(n.rChild)){
            int lChildVal = (n.lChild == null)?Integer.MIN_VALUE: n.lChild.val;
            int rChildVal = (n.rChild == null)?Integer.MAX_VALUE: n.rChild.val;

            if((lChildVal <= n.val) && (n.val <= rChildVal))
                return true;
        }

        return false;

    }



}
