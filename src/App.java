import java.util.ArrayList;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList<Food> foodList = new ArrayList<Food>();
        ArrayList<Kitchenware> kitchenwareList = new ArrayList<Kitchenware>();
        ArrayList<cleanSupplies> cleanSuppliesList = new ArrayList<cleanSupplies>();
        int choice = 0;
        System.out.println("Welcome to the Inventory System!");
        while (choice != 4) {
        System.out.println("1. Add Food");
        System.out.println("2. Add Kitchenware");
        System.out.println("3. Add Cleaning Supplies");
        System.out.println("4. Exit");
        choice = input.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Enter Food Type: ");
                String foodType = input.next();
                System.out.println("Enter Food Name: ");
                String foodName = input.next();
                System.out.println("Enter Expiration Date: ");
                int day = input.nextInt();
                int month = input.nextInt();
                int year = input.nextInt();
                Food food = new Food(foodType, foodName, day, month, year);
                foodList.add(food);
                break;
            case 2:
                System.out.println("Enter Kitchenware Name: ");
                String kitchenwareName = input.next();
                Kitchenware kitchenware = new Kitchenware(kitchenwareName);
                kitchenwareList.add(kitchenware);
                break;
            case 3:
                System.out.println("Enter Cleaning Supplies Name: ");
                String cleanSuppliesName = input.next();
                System.out.println("Is it liquid? (true/false)");
                boolean liquid = input.nextBoolean();
                if (liquid) {
                    System.out.println("Is it toxic? (true/false)");
                    boolean toxic = input.nextBoolean();
                    boolean electric = false;
                    liquidClean cleanSupplies = new liquidClean(cleanSuppliesName, liquid, electric, toxic);
                    cleanSuppliesList.add(cleanSupplies);
                    break;
                }
                else {
                    System.out.println("Is it electric? (true/false)");
                boolean electric = input.nextBoolean();
                cleanSupplies cleanSupplies = new cleanSupplies(cleanSuppliesName, liquid, electric);
                cleanSuppliesList.add(cleanSupplies);
                }
                break;
            case 4: 
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
        for(Food f : foodList) {
            System.out.println(f);
        }
        for(Kitchenware k : kitchenwareList) {
            System.out.println(k);
        }
        for(cleanSupplies c : cleanSuppliesList) {
            System.out.println(c);
        }
        input.close();
    }
};



static class liquidClean extends cleanSupplies {
    boolean toxic;
    liquidClean(String name, boolean liquid, boolean electric, boolean toxic) {
        super(name, liquid, electric);
        setToxic(toxic);
    }
    liquidClean() {
        super();
    }
    void setToxic(boolean toxic) {
        this.toxic = toxic;
    }
    public String toString() {
        return "Liquid Cleaning Supplies Name: " + name + "\nLiquid: " + liquid + "\nElectric: " + electric;
    }
}
}

