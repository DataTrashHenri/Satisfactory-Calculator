import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item {
    private List<Item> ingredients;
    private List<Double> amounts;
    private final String name;
    private final boolean isRawMaterial;

    public Item(String name, Item[] ingredients,Double[] amounts) {
        this.ingredients = Arrays.asList(ingredients);
        this.name = name;
        this.isRawMaterial = false;
        this.amounts=Arrays.asList(amounts);
    }
    public Item(String name, Item ingredient, Double amounts) {
        this.isRawMaterial=false;
        this.name = name;
        this.ingredients = Collections.singletonList(ingredient);
        this.amounts = Collections.singletonList(amounts);
    }
    public Item(String name) {
        isRawMaterial=true;
        this.name = name;
    }
    public void printRecipe(int amount) {
        printRecipe(0,amount);
    }
    public void printRecipe(int depth, double amount) {
        if (isRawMaterial) {
            System.out.println(amount+"x "+name);
            return;
        }
        System.out.println(amount+"x "+"<"+name+">"+" :");

        for (int i = 0; i < ingredients.size(); i++) {
            System.out.print(Main.colorpool[(depth+1)%16]);
            for (int j = 0; j < depth; j++) {
                System.out.print(Main.colorpool[(j+1)%16]);
                System.out.print("   |");
            }
            System.out.print(Main.colorpool[(depth+1)%16]);
            System.out.print("   |");
            ingredients.get(i).printRecipe(depth+1,amounts.get(i)*amount);
        }
    }

}
