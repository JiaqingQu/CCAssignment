package ch4;

import java.util.ArrayList;

public class Solution01 {

    private static class Node {
        int val;
        ArrayList<Node> children = new ArrayList<Node>(); //suppose the tree won't have more than 50 children
        boolean visited = false;

        Node(int i){
            val = i;
        }

        void addChild(Node c){
            children.add(c);
        }

        void visit(){
            this.visited = true;
        }

    }

    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n0.addChild(n1);
        n0.addChild(n4);
        n0.addChild(n5);
        n1.addChild(n3);
        n1.addChild(n4);
        n2.addChild(n1);
        n3.addChild(n2);
        n3.addChild(n4);

        System.out.println(hasRoute(n0,n3));

    }

    /**
     * Use the depth-first search
     * */
    public static boolean hasRoute(Node s, Node e){
        if(s == null)
            return false;
        if(s == e)
            return true;


        s.visit();
        for(int i = 0; i < s.children.size(); i++){
            Node c = s.children.get(i);
            if(c.visited != true){
                boolean result = hasRoute(c,e);
                if(result == true)
                    return result;
            }
        }

        return false;
    }

}
