import java.text.DecimalFormat;
import java.util.HashMap;

public class ResourceMap {
    private final HashMap<String,Double> resources;
    private final DecimalFormat df;
    public ResourceMap() {
        this.resources = new HashMap<>();
        this.df = new DecimalFormat("#,###.##");
    }
    public void addResource(String name,double amount) {
        resources.put(name,amount+(resources.get(name)==null?0:resources.get(name)));
    }
    public void flush(){
        resources.clear();
    }
    public void print(){
        System.out.println("--------------------------\nTotal raw Resources :\n");
        for (String key : resources.keySet()) {
            System.out.println(key+" : "+df.format(resources.get(key)));
        }
        this.flush();
        System.out.println("--------------------------");
    }
}
