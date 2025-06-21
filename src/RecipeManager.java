import java.util.HashMap;
import java.util.List;

public class RecipeManager {

    HashMap<String,Recipe> recipes;

    public RecipeManager() {
        this.recipes = new HashMap<>();
        loadRecipes();
    }
    private void loadRecipes() {
        recipes.put("Iron Ingot", new Recipe(new Product("Iron Ingot"), new Product("Iron Ore")));
        recipes.put("Iron Plate", new Recipe(new Product("Iron Plate"), new Product("Iron Ingot", 1.5)));
        recipes.put("Iron Rod", new Recipe(new Product("Iron Rod"), new Product("Iron Ingot", 1.0)));
        recipes.put("Portable Miner", new Recipe(new Product("Portable Miner"), List.of(
                new Product("Iron Plate", 2.0),
                new Product("Iron Rod", 4.0)
        )));
        recipes.put("Screws", new Recipe(new Product("Screws"), new Product("Iron Rod", 0.25)));
        recipes.put("Reinforced Iron Plate", new Recipe(new Product("Reinforced Iron Plate"), List.of(
                new Product("Iron Plate", 6.0),
                new Product("Screws", 12.0)
        )));
        recipes.put("Modular Frame", new Recipe(new Product("Modular Frame"), List.of(
                new Product("Reinforced Iron Plate", 3.0),
                new Product("Iron Rod", 12.0)
        )));
        recipes.put("Rotor", new Recipe(new Product("Rotor"), List.of(
                new Product("Iron Rod", 5.0),
                new Product("Screws", 25.0)
        )));
        recipes.put("Smart Plating", new Recipe(new Product("Smart Plating"), List.of(
                new Product("Reinforced Iron Plate", 1.0),
                new Product("Rotor", 1.0)
        )));


        recipes.put("Copper Ingot", new Recipe(new Product("Copper Ingot"), new Product("Copper Ore")));
        recipes.put("Copper Wire", new Recipe(new Product("Copper Wire"), new Product("Copper Ingot", 0.5)));
        recipes.put("Cable", new Recipe(new Product("Cable"), new Product("Copper Wire", 2.0)));
        recipes.put("Copper Sheet", new Recipe(new Product("Copper Sheet"), new Product("Copper Ingot", 2.0)));


        recipes.put("Concrete", new Recipe(new Product("Concrete"), new Product("Limestone", 3.0)));


        recipes.put("Steel Ingot", new Recipe(new Product("Steel Ingot"), List.of(
                new Product("Iron Ore", 1.0),
                new Product("Coal", 1.0)
        )));
        recipes.put("Steel Pipe", new Recipe(new Product("Steel Pipe"), new Product("Steel Ingot", 1.5)));
        recipes.put("Steel Beam", new Recipe(new Product("Steel Beam"), new Product("Steel Ingot", 4.0)));
        recipes.put("Versatile Framework", new Recipe(new Product("Versatile Framework"), List.of(
                new Product("Modular Frame", 0.5),
                new Product("Steel Beam", 6.0)
        )));


        recipes.put("Xeno Zapper", new Recipe(new Product("Xeno Zapper"), List.of(
                new Product("Iron Rod", 10.0),
                new Product("Reinforced Iron Plate", 2.0),
                new Product("Cable", 15.0),
                new Product("Copper Wire", 50.0)
        )));


        recipes.put("Stator", new Recipe(new Product("Stator"), List.of(
                new Product("Steel Pipe", 3.0),
                new Product("Copper Wire", 8.0)
        )));
        recipes.put("Automated Wiring", new Recipe(new Product("Automated Wiring"), List.of(
                new Product("Stator", 1.0),
                new Product("Cable", 20.0)
        )));
        recipes.put("Motor", new Recipe(new Product("Motor"), List.of(
                new Product("Rotor", 2.0),
                new Product("Stator", 2.0)
        )));
        recipes.put("Encased Industrial Beam", new Recipe(new Product("Encased Industrial Beam"), List.of(
                new Product("Steel Beam", 3.0),
                new Product("Concrete", 6.0)
        )));
        recipes.put("Rubber Heavyoil", new Recipe(new Product("Rubber Heavy oil"), List.of(
                new Product("Crude Oil", 1.5),
                new Product("Heavy Oil Residue", 1.0)
        )));
        recipes.put("Polymer Resin", new Recipe(new Product("Polymer Resin"), new Product("Crude Oil", 2.0)));
        recipes.put("Rubber", new Recipe(new Product("Rubber"), List.of(
                new Product("Polymer Resin", 2.0),
                new Product("Water", 2.0)
        )));
        recipes.put("Plastic", new Recipe(new Product("Plastic"), List.of(
                new Product("Polymer Resin", 3.0),
                new Product("Water", 1.0)
        )));
        recipes.put("Plastic Heavyoil", new Recipe(new Product("Plastic Heavy oil"), List.of(
                new Product("Crude Oil", 1.5),
                new Product("Heavy Oil Residue", 0.5)
        )));
        recipes.put("Modular Engine", new Recipe(new Product("Modular Engine"), List.of(
                new Product("Smart Plating", 2.0),
                new Product("Motor", 2.0),
                new Product("Rubber", 15.0)
        )));

    }

    private Recipe getRecipe(String name) {
        return recipes.get(name);
    }

    public void printRecipe(Recipe recipe,double amount,int depth) {
        simulateDepth(depth);
        System.out.println("< "+amount+"x "+recipe.products.stream().map(product -> product.name).collect(java.util.stream.Collectors.joining(", "))+">"+" :");
        for (Product ingredient : recipe.ingredients) {
            if (this.getRecipe(ingredient.name)==null) {
                simulateDepth(depth+1);
                System.out.println(amount* ingredient.amount+"x -"+ingredient.name+"-");
            } else {
                printRecipe(this.recipes.get(ingredient.name),amount*ingredient.amount,depth+1);
            }
        }
    }

    public void printRecipe(String recipe, int amount) {
        printRecipe(getRecipe(recipe),amount,0);
    }
    private void simulateDepth(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("   |");
        }
    }

}
