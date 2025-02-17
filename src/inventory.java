import java.util.ArrayList;
import java.util.Scanner;
public class inventory {
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
static class Food {
    String foodType;
    String foodName;
    int day;
    int month;
    int year;
    Food(String foodType, String foodName, int day, int month, int year) {
        setFoodType(foodType);
        setFoodName(foodName);
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    Food() {
        setFoodType("None");
        setFoodName("None");
        setDay(0);
        setMonth(0);
        setYear(0);
    }
    void setFoodType(String foodType) {
        this.foodType = foodType;
    }
    void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    void setDay(int day) {
        this.day = day;
    }
    void setMonth(int month) {
        this.month = month;
    }
    void setYear(int year) {
        this.year = year;
    }
    String getFoodType() {
        return foodType;
    }
    String getFoodName() {
        return foodName;
    }
    int getDay() {
        return day;
    }
    int getMonth() {
        return month;
    }
    int getYear() {
        return year;
    }
    public String toString() {
        return "Food Type: " + foodType + "\nFood Name: " + foodName + "\nExpiration Date: " + day + "/" + month + "/" + year;
    }
}
static class Kitchenware {
    String name;
    Kitchenware(String name) {
        setName(name);
    }
    Kitchenware() {
        setName("None");
    }
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
    public String toString() {
        return "Kitchenware Name: " + name;
    }
}
static class cleanSupplies {
    String name;
    boolean liquid;
    boolean electric;
    cleanSupplies(String name, boolean liquid, boolean electric) {
        setName(name);
        setLiquid(liquid);
        setElectric(electric);
    }
    cleanSupplies() {
        setName("None");
        setLiquid(false);
        setElectric(false);
    }
    void setName(String name) {
        this.name = name;
    }
    void setLiquid(boolean liquid) {
        this.liquid = liquid;
    }
    void setElectric(boolean electric) {
        this.electric = electric;
    }

    String getName() {
        return name;
    }
    boolean getLiquid() {
        return liquid;
    }

    boolean getElectric() {
        return electric;
    }
    public String toString() {
        return "Cleaning Supplies Name: " + name + "\nLiquid: " + liquid + "\nElectric: " + electric;
    }
}
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

