import java.util.List;

public class Recipe {
    List<Product> products;
    List<Product> ingredients;
    public Recipe(List<Product> products, List<Product> ingredients) {
        this.products = products;
        this.ingredients = ingredients;
    }
    public Recipe(Product product,Product ingredient) {
        this.products = List.of(product);
        this.ingredients = List.of(ingredient);
    }
    public Recipe(Product product,List<Product> ingredients) {
        this.products = List.of(product);
        this.ingredients = ingredients;
    }
}
