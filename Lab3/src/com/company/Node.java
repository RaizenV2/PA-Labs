package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Node implements Comparable {
    private String name;
    private Map<Node,Integer> cost ;

    public Node(String name){
        this.name = name;
        this.cost = new HashMap<Node,Integer>();
    }


    public String getName() {
        return name;
    }

    public Map<Node, Integer> getCost() {
        Map <Node,Integer> retCost = new HashMap<Node,Integer>();

        for(Map.Entry mapElement : this.cost.entrySet()){
            Node key = (Node)mapElement.getKey();
            Integer value = (Integer)mapElement.getValue();
            retCost.put(key,value);
        }
        return retCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Node n, Integer i ) {
        this.cost.put(n,i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }


    @Override
    public int compareTo(Object o) {

        if(o == null){
            throw new NullPointerException("not good , is null");
        }

        if(getClass() != o.getClass()){
            throw new ClassCastException("not good, not the same class");
        }
        String compareName = ((Node) o).getName();

        return this.name.compareTo(compareName);
    }

    @Override
    public  String toString(){
        String s ="";
        s += "Name -->";
        s += this.name;
        s += " :: Neighbours: ";
        for(Map.Entry mapElement: this.getCost().entrySet()){
            Node el = (Node) mapElement.getKey();
            s +=" ";

            s += el.getName();
        }

        return s;
    }
}
