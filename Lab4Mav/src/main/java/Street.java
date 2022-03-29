import java.util.Objects;

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
        return "Street: " + name +
                " weights: " + weights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(name, street.name) && Objects.equals(weights,street.weights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weights);
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
