public class Street implements Comparable {
    private String name;
    private Integer weights;

    public Street(String name, Integer weights) {
        this.name = name;
        this.weights = weights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeights() {
        return weights;
    }

    public void setWeights(Integer weights) {
        this.weights = weights;
    }


    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", weights=" + weights +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if (this == o) {throw  new NullPointerException("Este null , nu este bun");
        }
        if (o == null || getClass() != o.getClass()){
            throw  new ClassCastException("Nu este aceeasi clasa");
        } ;

        Street t  = (Street) o;
        Integer compareThis = t.getWeights();

        return this.weights.compareTo(compareThis);
    }
}
