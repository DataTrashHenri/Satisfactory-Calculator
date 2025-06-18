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

        //IRON RELATED
        Item ironOre = new Item("Iron Ore");
        Item ironIngot = new Item("Iron Ingot",ironOre,1.0);
        Item ironPlate = new Item("Iron Plate",ironIngot,1.5);
        Item ironRod = new Item("Iron Rod",ironIngot,1.0);
        Item portableMiner = new Item("Portable Miner",new Item[]{ironPlate,ironRod},new Double[]{2.0,4.0});
        Item screws = new Item("Screws",ironRod,0.25);
        Item reinforcedIronPlate = new Item("Reinforced Iron Plate",new Item[]{ironPlate,screws},new Double[]{6.0,12.0});
        Item modularFrame = new Item("Modular Frame", new Item[]{reinforcedIronPlate, ironRod}, new Double[]{3.0, 12.0});
        Item rotor = new Item("Rotor", new Item[]{ironRod, screws}, new Double[]{5.0, 25.0});

        //COPPER RELATED
        Item copperOre = new Item("Copper Ore");
        Item copperIngot = new Item("Copper Ingot",copperOre,1.0);
        Item wire = new Item("Copper Wire",copperIngot,0.5);
        Item cable = new Item("Cable",wire,2.0);

        //STEEL
        Item coal = new Item("Coal");
        Item steelIngot = new Item("Steel Ingot", new Item[]{ironOre, coal}, new Double[]{1.0,1.0});
        Item steelPipe = new Item("Steel Pipe", steelIngot, 1.5);
        Item steelBeam = new Item("Steel Beam",steelIngot,4.0);
        Item versatileFramework = new Item("Versatile Framework", new Item[]{modularFrame,steelBeam}, new Double[]{0.5, 6.0d});

        //SPECIAL
        Item xenoZapper = new Item("Xeno Zapper",new Item[]{ironRod,reinforcedIronPlate,cable,wire},new Double[]{10.0,2.0,15.0,50.0});



        versatileFramework.printRecipe(0,10);


    }

}