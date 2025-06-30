public class Main {
    static RecipeManager rm;
    public static void main(String[] args) {
        rm = new RecipeManager();
        rm.printRecipe("Modular Engine",50);
        rm.printResources();
    }
}
