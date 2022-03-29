import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Faker faker = new Faker();
        var nodes = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection(faker.address().streetAddress()))
                .toArray(Intersection[]::new);

        Random generator  = new Random();
        var edges  = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Street(faker.address().streetAddress(),generator.nextInt(1,100)))
                .toArray(Street[]::new);


        List<Street> edgesList = new ArrayList<>();

        for(Street street : edges)
        {
            edgesList.add(street);
        }

//        Collections.sort(edgesList);
        Collections.sort(edgesList,(u,v)->u.getWeights().compareTo(v.getWeights()));
//
//        for(Street t : edgesList)
//        {
//            System.out.println(t);
//        }

        List<Intersection> intersections = new ArrayList<>();

        for(Intersection t : nodes)
        {
            intersections.add(t);

        }
        City oras = new City();
        oras.setMapping(intersections.get(1),Arrays.asList(edges[0],edges[1],edges[2]));

        oras.setMapping(intersections.get(2),Arrays.asList(edges[2],edges[1],edges[3]));

        oras.setMapping(intersections.get(3),Arrays.asList(edges[0],edges[1]));

//        System.out.println(intersections);
//        System.out.println(oras);
//        Map<Intersection<List<Street>>> retOras = oras.getMapping();
        Map<Intersection,List<Street>> retOras = oras.getMapping();

        var set = retOras.entrySet().stream().filter(e->e.getValue().size()>2).map(Map.Entry::getValue).flatMap(List::stream).filter(e->e.getWeights() >10).collect(Collectors.toSet());
        System.out.println(set);
        Graph<Intersection,Street> graf2= new SimpleWeightedGraph<>(Street.class);
        for(Intersection t : intersections)
        {
            graf2.addVertex(t);
        }
        graf2.addEdge(intersections.get(0),intersections.get(1),edges[0]);
        graf2.setEdgeWeight(edges[0],edges[0].getWeights());

        graf2.addEdge(intersections.get(0),intersections.get(2),edges[1]);
        graf2.setEdgeWeight(edges[1],edges[1].getWeights());
        graf2.addEdge(intersections.get(1),intersections.get(3),edges[2]);
        graf2.setEdgeWeight(edges[2],edges[2].getWeights());

        var rezolvare = new KruskalMinimumSpanningTree<Intersection, Street>(graf2);
        var rezolvare2 = rezolvare.getSpanningTree();
        System.out.println(rezolvare2);


    }
}
