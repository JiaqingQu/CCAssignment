package ch4;

import java.util.ArrayList;

public class Solution07 {

    private static class Node {
        String val;
        ArrayList<Node> in = new ArrayList<Node>();
        ArrayList<Node> out = new ArrayList<Node>();

        Node(String s){
            this.val = s;
        }

        void addIn(Node n){
            in.add(n);
        }

        void addOut(Node n){
            out.add(n);
        }

    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        addDependency(d,a);
        addDependency(b,f);
        addDependency(d,b);
        addDependency(a,f);
        addDependency(c,d);

        ArrayList<Node> projects = new ArrayList<Node>();

        projects.add(a);
        projects.add(b);
        projects.add(c);
        projects.add(d);
        projects.add(e);
        projects.add(f);

        ArrayList<Node> output = buildOrder(projects);

        for(Node n: output){
            System.out.print(n.val + " ");
        }





    }

    /**
     * Use the theory in topological sort, the next node to be put into the result is always the node without the in-degree
     * [Reference: The idea of this solution is drawn from the discussion with Jun Zhou]
     * */
    private static ArrayList<Node> buildOrder(ArrayList<Node> projects){

        ArrayList<Node> inputProjects = projects;
        ArrayList<Node> result = new ArrayList<Node>();

        while(!inputProjects.isEmpty()){

            for(int i = 0; i < inputProjects.size(); i++){
                Node node = inputProjects.get(i);

                // find the nodes with no in-edge
                if(node.in.isEmpty()){

                    // remove its dependant's in-edge
                    for(Node dependent: node.out) {
                        dependent.in.remove(node);
                    }

                    // remove its out edge
                    node.out.clear();

                    // remove it from the original input
                    inputProjects.remove(i);

                    // add it to the result
                    result.add(node);

                    break;
                }
            }
        }

        return result;

    }

    /**
     * In this case, d depends on n
     * */
    private static void addDependency(Node d, Node n){
        n.out.add(d);
        d.in.add(n);
    }





}
