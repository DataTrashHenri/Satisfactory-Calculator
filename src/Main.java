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
    public static void main(String[] args) {

        //Item ironplate = new Item("Iron Bar",new Item("Iron Ingot"));
        //Item superironplate = new Item("Super Iron Bar",ironplate);
        //Item thiccPlate = new Item("Thiccc plate", new Item[]{ironplate, superironplate});
        Item ironIngot = new Item("Iron Ingot",new Item("Iron Ore"));
        Item ironPlate = new Item("Iron Plate",ironIngot);
        Item ironRod = new Item("Iron Rod",ironIngot);
        Item portableMiner = new Item("Portable Miner",new Item[]{ironPlate,ironRod});
        //todo:: amount "3x IronIngot"
    }

}