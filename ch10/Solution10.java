package ch10;

public class Solution10 {

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

        void insert(int num) {
            BinaryTreeNode node = new BinaryTreeNode(num);

            if((num < val) && (lChild == null)) {
                lChild = node;
                return;
            }
            if((num >= val) && (rChild == null)){
                rChild = node;
                return;
            }

            if(num < val) {
                lChild.insert(num);
            } else {
                rChild.insert(num);
            }
        }




    }

    public static void main(String[] args) {

    }

    private static class Rank {
        private BinaryTreeNode root; // I'm a TREE! ↖(^ω^)↗

        Rank(){

        }

        void track(int num){
            BinaryTreeNode node = new BinaryTreeNode(num);

            if(root == null) {
                root = node;
            } else {
                root.insert(num);
            }
        }

        int getRankOfNumber(int n) {
           return getRankOfNumber(root, n);
        }

        int getRankOfNumber(BinaryTreeNode r, int n) {
            // Base Case
            if(n == r.val) {
                return getTreeSize(r.lChild) + 1;
            }

            int result = 0;

            if(n > r.val) {
                result = getTreeSize(r.lChild) + 1 +getRankOfNumber(r.rChild, n);
            } else {
                result = getRankOfNumber(r.lChild, n);
            }


            return result;

        }

        int getTreeSize(BinaryTreeNode node) {
            if (node == null) {
                return 0;
            }

            return 1 + getTreeSize(node.lChild) + getTreeSize(node.rChild);
        }



    }

}
