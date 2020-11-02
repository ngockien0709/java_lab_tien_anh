package Functions;

import java.io.*;
import java.util.*;

public class Main_Menu {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Scanner scan = new Scanner(System.in);

    //PRINT OUT MAIN MENU
    public void printMainMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyers)");
        System.out.println("4. Exit");
    }

    //GET MAIN MENU CHOICE
    public int getMainMenuChoice() {
        int choice = 0;
        do {
            try {
                System.out.print("Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program: ");
                choice = Integer.parseInt(scan.nextLine());         //out of range check
                if (choice < 1 || choice > 4) {
                    System.out.println("Out of range. Please choose 1 to 4 only");
                    System.out.println();
                }
            } catch (NumberFormatException e) {                   //check if input is not number
                System.out.println(e.getMessage() + "is not a number. Please choose 1 to 4 only");
                System.out.println();
            }
        } while (choice < 1 || choice > 4);
        return choice;
    }
}
