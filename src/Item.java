import java.util.Arrays;
import java.util.List;

public class Item {
    private List<Item> ingredients;
    private String name;
    private boolean isRawMaterial;
    public Item(String name, Item[] ingredients) {
        this.ingredients = Arrays.asList(ingredients);
        this.name = name;
        this.isRawMaterial = false;
    }
    public Item(String name, Item ingredient) {
        this.isRawMaterial=false;
        this.name = name;
        this.ingredients = Arrays.asList(ingredient);
    }
    public Item(String name) {
        isRawMaterial=true;
        this.name = name;
    }

    public void printRecipe(int depth) {
        System.out.print(Main.colorpool[depth%16]);
        if (isRawMaterial) {
            System.out.println(name);
            return;
        }
        System.out.println("<"+name+">"+" Ingredients:");
        /*if (ingredients.size() ==1) {
            System.out.println("-- "+ingredients.getFirst().name);
            return;
        }*/
        for(Item ingredient : ingredients) {
            System.out.print(Main.colorpool[(depth+1)%16]);
            for (int i = 0; i < depth; i++) {
                System.out.print("--");
            }

            System.out.print("-- ");
            ingredient.printRecipe(depth+1);
        }
    }
}
