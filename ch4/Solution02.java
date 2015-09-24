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

        BTreePrinter.printNode(root);
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

//        if(s == e){
//            BinaryTreeNode root = new BinaryTreeNode(nums[s]);
//            return root;
//        }

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

    /**
     * [Reference: This Tree Printer is referred from
     *  http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
     *  for testing
     * ]
     * */
    static class BTreePrinter {

        public static void printNode(BinaryTreeNode root) {
            int maxLevel = BTreePrinter.maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private static <T extends Comparable<?>> void printNodeInternal(List<BinaryTreeNode> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            BTreePrinter.printWhitespaces(firstSpaces);

            List<BinaryTreeNode> newNodes = new ArrayList<BinaryTreeNode>();
            for (BinaryTreeNode node : nodes) {
                if (node != null) {
                    System.out.print(node.val);
                    newNodes.add(node.lChild);
                    newNodes.add(node.rChild);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).lChild != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (nodes.get(j).lChild != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private static int maxLevel(BinaryTreeNode node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.lChild), BTreePrinter.maxLevel(node.rChild)) + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }




}
