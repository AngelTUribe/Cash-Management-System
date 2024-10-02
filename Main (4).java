import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Notes twenties = new Notes(20);
        Notes tens = new Notes(10);
        Notes fives = new Notes(5);
        Notes ones = new Notes(1);
        Coins quarters = new Coins(0.25f, 0.2f);
        Coins dimes = new Coins(0.10f, 0.08f);
        Coins nickels = new Coins(0.05f, 0.176f);
        Coins pennies = new Coins(0.01f, 0.088f);

        dimes.increaseQuantity(41);
        nickels.increaseQuantity(17);
        pennies.increaseQuantity(132);
        ones.increaseQuantity(33);
        fives.increaseQuantity(12);
        tens.increaseQuantity(2);
        twenties.increaseQuantity(5);

        System.out.println(twenties);
        System.out.println(tens);
        System.out.println(fives);
        System.out.println(ones);
        System.out.println(quarters);
        System.out.println(dimes);
        System.out.println(nickels);
        System.out.println(pennies);

        float totalMoney = twenties.getTotalValue() + tens.getTotalValue() + fives.getTotalValue() +
                ones.getTotalValue() + quarters.getTotalValue() + dimes.getTotalValue() +
                nickels.getTotalValue() + pennies.getTotalValue();

        float totalWeight = quarters.getTotalWeight() + dimes.getTotalWeight() +
                nickels.getTotalWeight() + pennies.getTotalWeight();

        System.out.println("Total Money is $" + String.format("%4.2f", totalMoney) +
                " total weight is " + String.format("%4.3f", totalWeight) + "oz");

        Scanner scanner = new Scanner(System.in);
        System.out.print("How much do you need? ");
        float requestedAmount = scanner.nextFloat();

        float remainingAmount = requestedAmount;

        while (remainingAmount > 0.001) {
            if (remainingAmount >= 20 && twenties.getQuantityOnHand() > 0) {
                System.out.println("Give them a $20 note");
                remainingAmount -= 20;
                twenties.decreaseQuantity(1);
            } else if (remainingAmount >= 10 && tens.getQuantityOnHand() > 0) {
                System.out.println("Give them a $10 note");
                remainingAmount -= 10;
                tens.decreaseQuantity(1);
            } else if (remainingAmount >= 5 && fives.getQuantityOnHand() > 0) {
                System.out.println("Give them a $5 note");
                remainingAmount -= 5;
                fives.decreaseQuantity(1);
            } else if (remainingAmount >= 1 && ones.getQuantityOnHand() > 0) {
                System.out.println("Give them a $1 note");
                remainingAmount -= 1;
                ones.decreaseQuantity(1);
            } else if (remainingAmount >= 0.25 && quarters.getQuantityOnHand() > 0) {
                System.out.println("Give them a quarter");
                remainingAmount -= 0.25;
                quarters.decreaseQuantity(1);
            } else if (remainingAmount >= 0.10 && dimes.getQuantityOnHand() > 0) {
                System.out.println("Give them a dime");
                remainingAmount -= 0.10;
                dimes.decreaseQuantity(1);
            } else if (remainingAmount >= 0.05 && nickels.getQuantityOnHand() > 0) {
                System.out.println("Give them a nickel");
                remainingAmount -= 0.05;
                nickels.decreaseQuantity(1);
            } else if (remainingAmount >= 0.01 && pennies.getQuantityOnHand() > 0) {
                System.out.println("Give them a penny");
                remainingAmount -= 0.01;
                pennies.decreaseQuantity(1);
            } else {
                System.out.println("I don't have enough money. I still owe you $" +
                        String.format("%4.2f", remainingAmount));
                break;
            }
        }

        float remainingWeight = quarters.getTotalWeight() + dimes.getTotalWeight() +
                nickels.getTotalWeight() + pennies.getTotalWeight();

        System.out.println("I have $" + String.format("%4.2f", Math.max(0, totalMoney - requestedAmount)) +
                " left, it's total weight is " + String.format("%4.3f", remainingWeight) + "oz");

    }
}
