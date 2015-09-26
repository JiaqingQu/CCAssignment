package ch4;

public class Solution11 {

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode lChild = null;
        BinaryTreeNode rChild = null;
        BinaryTreeNode p = null;
        int size;

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

    /**
     * [Reference: I discussed this question with Zhou Jun]
     * Generate a random number r and suppose that left child has l nodes and right child has r nodes
     *  - r is in [0, 1/ (1 + l + r) ), stay at the current node
     *  - r is in [1/ (1 + l + r), (l + 1)/ (1 + l + r) ), go left
     *  - else, go right
     * */
    class MyTree {

         BinaryTreeNode getRandomNode(BinaryTreeNode node){
             if(node == null)
                return null;

             if(node.lChild == null && node.rChild == null)
                return node;

             int leftChildNum = (node.lChild == null) ? 0: node.lChild.size;
             int rightChildNum = (node.rChild == null) ? 0: node.rChild.size;


             double decideNum = Math.random();

             double currentProb = 1 / (1 + leftChildNum + rightChildNum);
             double leftProb = (1 + leftChildNum)/ (1 + leftChildNum + rightChildNum);

             if(decideNum <= currentProb)
                 return node;
             else if(decideNum <= leftProb)
                 return getRandomNode(node.lChild);
             else
                 return  getRandomNode(node.rChild);

        }



    }

}
