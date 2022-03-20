import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        var nodes = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);
        var nodes2 = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        Random generator  = new Random();
        var edges  = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Street("v" + i,generator.nextInt(1,100)))
                .toArray(Street[]::new);


        List<Street> edgesList = new ArrayList<>();

        for(Street street : edges)
        {
            edgesList.add(street);
        }

//        Collections.sort(edgesList);
        Collections.sort(edgesList,(u,v)->u.getWeights().compareTo(v.getWeights()));

        for(Street t : edgesList)
        {
            System.out.println(t);
        }

        HashSet<Intersection> intersections = new HashSet<>();

        for(Intersection t : nodes)
        {
            intersections.add(t);

        }
        for(Intersection t : nodes2)
        {
            intersections.add(t);

        }

        System.out.println(intersections);
    }
}
