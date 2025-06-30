public class Product {
    public String name;
    public double amount;
    public Product(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
    public Product(String name) {
        this.name = name;
        this.amount = 1;
    }
    public Product(String name, int amount) {
        this(name, (double) amount);
    }

}
