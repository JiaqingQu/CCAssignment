package ch4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

public class Solution06 {

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
//        BinaryTreeNode n1 = new BinaryTreeNode(1);
//        BinaryTreeNode n2 = new BinaryTreeNode(2);
//        BinaryTreeNode n3 = new BinaryTreeNode(3);
//        BinaryTreeNode n4 = new BinaryTreeNode(4);
//        BinaryTreeNode n5 = new BinaryTreeNode(5);
//        BinaryTreeNode n6 = new BinaryTreeNode(6);
//        n1.setlChild(n2);
//        n1.setrChild(n3);
//        n2.setlChild(n4);
//        n2.setrChild(n5);

        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n11 = new BinaryTreeNode(11);
        n6.setlChild(n3);
        n6.setrChild(n9);
        n3.setlChild(n2);
        n3.setrChild(n4);
        n9.setlChild(n8);
        n9.setrChild(n10);
        n2.setlChild(n1);
        n4.setrChild(n5);
        n8.setlChild(n7);
        n10.setrChild(n11);


        System.out.format("Successor of %d is %d",n5.val,inOrderSuccessor(n5).val);
    }

    /**
     * Do in-order traverse backward
     */
    public static BinaryTreeNode inOrderSuccessor(BinaryTreeNode n) {

        if (n.rChild != null) {
            BinaryTreeNode node = n.rChild;

            while (node.lChild != null) {
                node = node.lChild;
            }

            return node;
        } else {
            BinaryTreeNode node = n;

            while ((node.p != null) && (node.p.rChild == node)) {
                node = node.p;
            }

            return node.p;
        }

    }




}
