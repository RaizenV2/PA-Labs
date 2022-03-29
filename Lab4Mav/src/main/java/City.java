import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    Map<Intersection, List<Street>> mapping;

    public City() {
        mapping = new HashMap<>();
    }

    public Map<Intersection, List<Street>> getMapping() {
        Map<Intersection,List<Street>> retMap = new HashMap<>();
        for(Map.Entry element: this.mapping.entrySet())
        {
            Intersection key = (Intersection) element.getKey();
            List<Street> value = (List<Street>) element.getValue();
            retMap.put(key,value);
         }

        return mapping;
    }

    public void setMapping(Intersection intersection, List<Street> streesList) {
        this.mapping.put(intersection,streesList);
    }

    @Override
    public String toString() {
        String str ="";
        for(Map.Entry element:this.mapping.entrySet())
        {
            str += element.getKey().toString();
            List<Street> value = (List<Street>) element.getValue();
            str += " Streets --> ";
            for(Street street: value)
            {
                str += street.getName();
                str += "(" + street.getWeights() +")";
                str +=" ";
            }
            str+="\n";
        }
        return  str;
    }
}
