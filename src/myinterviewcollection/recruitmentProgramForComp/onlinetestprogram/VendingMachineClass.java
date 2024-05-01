/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.recruitmentProgramForComp.onlinetestprogram;

import java.util.Scanner;

/**
 *
 * @author $ADDAM
 */
public class VendingMachineClass {
 
    public static void runVendingMachine() {
        int Food = runMenu();
        int Price = retrievePrice(Food);
        int change = moneyInserted(Price);
        
        if (change > 0) {
            System.out.print("Please collect your change : " + change);
        }
    }

    private static int runMenu() {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;
        System.out.println("\n\nPlease enter your selection:"
                + "\n1: Snickers \t 125"
                + "\n2: Reeses Cup \t 130"
                + "\n3: Doritoes \t 150"
                + "\n4: Pepsi \t 185"
                + "\n5: Exit ");
        choice = keyboard.nextInt();
        return choice;
    }

    private static int retrievePrice(int menuChoice) {
        switch (menuChoice) {
            case 1:
                return 125;
            case 2:
                return 130;
            case 3:
                return 150;
            case 4:
                return 185;
            default:
                return 0;
        }
    }

    private static int moneyInserted(int Price) {
        Scanner keyboard = new Scanner(System.in);
        int money = 0;
        System.out.println("Your item costs: " + Price + " Please enter the amount of money:");
        money = keyboard.nextInt();
        while (money < Price) {
            System.out.println("Please insert " + (Price - money) + " more.");
            money = money + keyboard.nextInt();
        }
        return money - Price;
    }

    private static void changeOut(int change) {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        while (change >= 25) {
            quarters = quarters + 1;
            change = change - 25;
        }
        while (change >= 10) {
            dimes = dimes + 1;
            change = change - 10;
        }
        while (change >= 5) {
            nickels = nickels + 1;
            change = change - 5;
        }
        // to see the change, print it to the console perhaps
        System.out.printf("\nHere's your change:\n%d quarters, %d dimes, %d nickels and %d pennies!", quarters, dimes, nickels, change);
    }
}
