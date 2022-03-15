package com.company;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodes;

    public Network() {
        this.nodes = new ArrayList<Node>();
    }

    public List<Node> getNodes() {
        List<Node> retNodes = new ArrayList<Node>();
        for(Node n:nodes)
        {
            retNodes.add(n);
        }
        return retNodes;
    }

    public void setNodes(Node n) {
        this.nodes.add(n);
    }

    @Override
    public String toString() {
        String s = "";
        for (Node node : nodes){
            s  += node.toString();
            s +="\n";
        }
        return s;
    }
}
