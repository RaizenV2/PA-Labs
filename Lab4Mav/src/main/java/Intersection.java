import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Intersection implements Comparable {
    private String name;

    public Intersection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersection that = (Intersection) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {throw  new NullPointerException("Este null , nu este bun");
        }
        if (o == null || getClass() != o.getClass()){
            throw  new ClassCastException("Nu este aceeasi clasa");
        } ;
        String compareThis = ((Intersection) o).getName();
        return this.name.compareTo(compareThis);
    }


}
