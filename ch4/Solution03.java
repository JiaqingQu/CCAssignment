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


}
