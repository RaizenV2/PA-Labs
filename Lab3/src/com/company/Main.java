package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Node n = new Computer("Station1","128.0.01",100);
        Node n2 = new Computer("Station2","231.123.0.1",200);
        Node n3 = new Computer("Server","1.1.1.1.",1000);
        Node n4 = new Switch("Switch");
        n.setCost(n2,1002);
        n2.setCost(n,1002);
        n.setCost(n3,100);
        n3.setCost(n,100);
        n2.setCost(n3,100);
        n3.setCost(n2,100);
        n2.setCost(n4,30);
        n4.setCost(n2,30);
        n4.setCost(n3,20);
        n3.setCost(n4,20);

        Network net = new Network();
        net.setNodes(n);
        net.setNodes(n3);
        net.setNodes(n2);
        net.setNodes(n4);


        System.out.println(net);
        System.out.println("SPACER");
        net.displayIdentifiableNodes();
        System.out.println("SPACER");
        Network.Djistraka(net,n);

    }
}
