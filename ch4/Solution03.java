package ch4;

import com.sun.tools.internal.xjc.reader.dtd.bindinfo.BIAttribute;

import java.util.*;

public class Solution03 {

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
        BTreePrinter.printNode(n1);


        HashMap<Integer, ArrayList<BinaryTreeNode>> map = listDepth(n1);

        for(Integer level: map.keySet()){
            System.out.format("Level %d has: ", level);
            ArrayList<BinaryTreeNode> nodes = map.get(level);

            Iterator nodeIt = nodes.iterator();
            while (nodeIt.hasNext()){
                System.out.print(((BinaryTreeNode)nodeIt.next()).val);
            }

            System.out.println();
        }
    }

    /**
     * Use BFS while keeping track of the currentLevel and countLevel to store the level information
     * */
    public static HashMap<Integer, ArrayList<BinaryTreeNode>> listDepth(BinaryTreeNode r){
        HashMap<Integer, ArrayList<BinaryTreeNode>> map = new HashMap<Integer, ArrayList<BinaryTreeNode>>();

        int[] countLevel = new int[100];   //count the number of nodes on each level
        int currentLevel = 0;
        countLevel[0] = 1;

        LinkedList<BinaryTreeNode> quene = new LinkedList<BinaryTreeNode>();
        quene.add(r);

        while (!quene.isEmpty()){
            for(int i = 0; i < countLevel[currentLevel]; i++){
                BinaryTreeNode n = quene.remove();
                //add the node to the list of current level
                map = addToCurrentLevel(map, currentLevel, n);

                if(n.lChild != null){
                    countLevel[currentLevel + 1]++;
                    quene.add(n.lChild);
                }
                if(n.rChild != null){
                    countLevel[currentLevel + 1]++;
                    quene.add(n.rChild);
                }

            }

            currentLevel++;
        }

        return map;
    }

    private static HashMap<Integer,ArrayList<BinaryTreeNode>> addToCurrentLevel(HashMap<Integer, ArrayList<BinaryTreeNode>> map, int level, BinaryTreeNode n){
        ArrayList<BinaryTreeNode> list = map.get(level);
        if(list == null)
            list = new ArrayList<BinaryTreeNode>();
        list.add(n);
        map.put(level,list);

        return map;
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
