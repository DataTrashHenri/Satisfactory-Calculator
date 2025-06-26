import java.text.DecimalFormat;
import java.util.HashMap;

public class ResourceMap {
    private static final HashMap<String,Double> resources = new HashMap<>();
    public static DecimalFormat df = new DecimalFormat("#,###.##");
    public static void addResource(String name,double amount) {
        resources.put(name,amount+(resources.get(name)==null?0:resources.get(name)));
    }
    public static void flush(){
        resources.clear();
    }
    public static void print(){
        System.out.println("--------------------------\nTotal raw Resources :\n");
        for (String key : resources.keySet()) {
            System.out.println(key+" : "+df.format(resources.get(key)));
        }
        ResourceMap.flush();
        System.out.println("--------------------------");
    }
}
