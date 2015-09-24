package ch4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution04 {

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
        n1.setlChild(n2);
        n1.setrChild(n3);
        n2.setlChild(n4);
        n2.setrChild(n5);
//        n5.setrChild(n6);
        System.out.println("Generated Tree is .. ");

        System.out.println("Check balance: "+isBalance(n1));

    }

    public static boolean isBalance(BinaryTreeNode n){
        int h = checkHeight(n);
        if(h > 0)
            return true;

        return false;
    }

    /**
     * Recursively check the height of each node's two subtree
     * return -1 when the tree is not balanced
     * */
    public static int checkHeight(BinaryTreeNode n){
        if(n == null)
            return 0;

        int leftHeight = checkHeight(n.lChild);
        int rightHeight = checkHeight(n.rChild);

        if((leftHeight == -1) || (rightHeight == -1))
            return -1;

        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }




}
