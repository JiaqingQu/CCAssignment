package ch4;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

public class Solution08 {

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
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        n1.setlChild(n2);
        n1.setrChild(n3);
        n2.setlChild(n4);
        n2.setrChild(n5);


        System.out.format("The first common ancestor of %d and %d is %d\n",n3.val,n4.val,getFirstCommonAncestor(n1, n3, n4).val);

    }

    /**
     * Find all the path from root
     *  - if p and q are in the same path, p or q which comes first is the FCA (First Common Ancestor)
     *  - otherwise, the last element of the longest common part of p and q is the FCA
     * */
    private static BinaryTreeNode getFirstCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q){
        ArrayList<ArrayList<BinaryTreeNode>> allPath = getPath(root);

        ArrayList<BinaryTreeNode> pathP = null;
        ArrayList<BinaryTreeNode> pathQ = null;


        for(ArrayList<BinaryTreeNode> path: allPath){
            if(path.contains(p))
                pathP = path;
            if(path.contains(q))
                pathQ = path;
        }


        if(pathP == pathQ){
            int indexP = pathP.indexOf(p);
            int indexQ = pathP.indexOf(q);

            if(indexP <= indexQ)
                return p;
            else
                return q;
        } else {
            int i = 0;

            while (pathP.get(i) == pathQ.get(i) && i < pathP.size() && i < pathQ.size()){
                i++;
            }

            return pathP.get(i - 1);

        }

    }


    private static ArrayList<ArrayList<BinaryTreeNode>> getPath(BinaryTreeNode root){
        ArrayList<ArrayList<BinaryTreeNode>> allPath = new ArrayList<ArrayList<BinaryTreeNode>>();

        if(root == null)
            return null;

        ArrayList<ArrayList<BinaryTreeNode>> leftPaths = getPath(root.lChild);
        ArrayList<ArrayList<BinaryTreeNode>> rightPaths = getPath(root.rChild);

        if((leftPaths == null) && (rightPaths == null)){
            ArrayList<BinaryTreeNode> path = new ArrayList<BinaryTreeNode>();
            path.add(root);
            allPath.add(path);

            return allPath;
        }

        if(leftPaths!=null){
            for(ArrayList<BinaryTreeNode> path: leftPaths){
                path.add(0,root);
                allPath.add(path);
            }
        }

        if(rightPaths!=null){
            for(ArrayList<BinaryTreeNode> path: rightPaths){
                path.add(0,root);
                allPath.add(path);
            }
        }

        return allPath;

    }








}
