import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[] colorpool = {
            "\u001B[30m", // Black
            "\u001B[31m", // Red
            "\u001B[32m", // Green
            "\u001B[33m", // Yellow
            "\u001B[34m", // Blue
            "\u001B[35m", // Magenta
            "\u001B[36m", // Cyan
            "\u001B[37m", // White
            "\u001B[90m", // Bright Black (Gray)
            "\u001B[91m", // Bright Red
            "\u001B[92m", // Bright Green
            "\u001B[93m", // Bright Yellow
            "\u001B[94m", // Bright Blue
            "\u001B[95m", // Bright Magenta
            "\u001B[96m", // Bright Cyan
            "\u001B[97m", // Bright White
    };
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String,Item> items = new HashMap<>();
        //IRON RELATED
        items.put("Iron Ore", new Item("Iron Ore"));
        items.put("Iron Ingot", new Item("Iron Ingot", items.get("Iron Ore"), 1.0));
        items.put("Iron Plate", new Item("Iron Plate", items.get("Iron Ingot"), 1.5));
        items.put("Iron Rod", new Item("Iron Rod", items.get("Iron Ingot"), 1.0));
        items.put("Portable Miner", new Item("Portable Miner", new Item[]{items.get("Iron Plate"), items.get("Iron Rod")}, new Double[]{2.0, 4.0}));
        items.put("Screws", new Item("Screws", items.get("Iron Rod"), 0.25));
        items.put("Reinforced Iron Plate", new Item("Reinforced Iron Plate", new Item[]{items.get("Iron Plate"), items.get("Screws")}, new Double[]{6.0, 12.0}));
        items.put("Modular Frame", new Item("Modular Frame", new Item[]{items.get("Reinforced Iron Plate"), items.get("Iron Rod")}, new Double[]{3.0, 12.0}));
        items.put("Rotor", new Item("Rotor", new Item[]{items.get("Iron Rod"), items.get("Screws")}, new Double[]{5.0, 25.0}));
        items.put("Smart Plating", new Item("Smart Plating", new Item[]{items.get("Reinforced Iron Plate"), items.get("Rotor")}, new Double[]{1.0, 1.0}));

        //COPPER RELATED
        items.put("Copper Ore", new Item("Copper Ore"));
        items.put("Copper Ingot", new Item("Copper Ingot", items.get("Copper Ore"), 1.0));
        items.put("Copper Wire", new Item("Copper Wire", items.get("Copper Ingot"), 0.5));
        items.put("Cable", new Item("Cable", items.get("Copper Wire"), 2.0));
        items.put("Copper Sheet", new Item("Copper Sheet", items.get("Copper Ingot"), 2.0));

        //LIMESTONE RELATED
        items.put("Limestone", new Item("Limestone"));
        items.put("Concrete", new Item("Concrete", items.get("Limestone"), 3.0));

        //STEEL
        items.put("Coal", new Item("Coal"));
        items.put("Steel Ingot", new Item("Steel Ingot", new Item[]{items.get("Iron Ore"), items.get("Coal")}, new Double[]{1.0, 1.0}));
        items.put("Steel Pipe", new Item("Steel Pipe", items.get("Steel Ingot"), 1.5));
        items.put("Steel Beam", new Item("Steel Beam", items.get("Steel Ingot"), 4.0));
        items.put("Versatile Framework", new Item("Versatile Framework", new Item[]{items.get("Modular Frame"), items.get("Steel Beam")}, new Double[]{0.5, 6.0d}));

        //SPECIAL
        items.put("Xeno Zapper", new Item("Xeno Zapper", new Item[]{items.get("Iron Rod"), items.get("Reinforced Iron Plate"), items.get("Cable"), items.get("Copper Wire")}, new Double[]{10.0, 2.0, 15.0, 50.0}));

        //TIER 4
        items.put("Stator", new Item("Stator", new Item[]{items.get("Steel Pipe"), items.get("Copper Wire")}, new Double[]{3.0, 8.0}));
        items.put("Automated Wiring", new Item("Automated Wiring", new Item[]{items.get("Stator"), items.get("Cable")}, new Double[]{1.0, 20.0}));
        items.put("Motor", new Item("Motor", new Item[]{items.get("Rotor"), items.get("Stator")}, new Double[]{2.0, 2.0}));
        items.put("Encased Industrial Beam", new Item("Encased Industrial Beam", new Item[]{items.get("Steel Beam"), items.get("Concrete")}, new Double[]{3.0, 6.0}));


        //automatedWiring.printRecipe(100);
        String input;
        while (true) {
            System.out.println("\n\u001B[32m[product],[amount]->");
            input= scanner.nextLine();
            if (input.isEmpty()) break;
            String product = Arrays.stream(input.split(",")[0].strip().split(" ")).map(s-> s.substring(0,1).toUpperCase()+s.substring(1)).reduce((a, b)->a+" "+b).get();
            int amount = Integer.parseInt(input.split(",")[1].strip());
            items.get(product).printRecipe(amount);
        }


    }

}