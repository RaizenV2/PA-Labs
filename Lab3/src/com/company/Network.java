package com.company;

import java.util.*;

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

    public void displayIdentifiableNodes()
    {
        List<Identifiable> targetNodes = new ArrayList<Identifiable>();
        for(Node n : nodes){
            if(n instanceof Identifiable){
                targetNodes.add((Identifiable)n);
            }
            Collections.sort(targetNodes,AddresComparator);
        }
        for(Identifiable f : targetNodes) {
            System.out.println(f);
        }
    }
    public  static void Djistraka(Network network ,Node source)
    {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);
        while(unsettledNodes.size() != 0){
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry< Node, Integer> adjacencyPair:
                    currentNode.getCost().entrySet())
            {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)){
                    CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
    }

    private static Node getLowestDistanceNode(Set< Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    private static void showPath(List<Node> list) {
        String s ="";
        for (int i = 0; i < list.size(); i++)
        {
            s+= list.get(i).getName();
            s+= " <--";

        }
        s+="START";
        System.out.println(s);
    }
    private static void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode)
    {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);

            evaluationNode.setShortestPath(shortestPath);
            showPath(shortestPath);
        }

    }

    public static Comparator<Identifiable> AddresComparator = new Comparator<Identifiable>() {
        @Override
        public int compare(Identifiable node, Identifiable t1) {
            String addr1 = node.getAddress();
            String addr2 = t1.getAddress();
            return addr1.compareTo(addr2);
        }
    };
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
