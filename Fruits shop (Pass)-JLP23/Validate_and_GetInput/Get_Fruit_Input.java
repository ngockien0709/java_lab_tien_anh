package Validate_and_GetInput;

import Entities.Fruit;
import java.io.*;
import java.util.*;

public class Get_Fruit_Input {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Scanner scan = new Scanner(System.in);
    Validate va = new Validate();

    //GET FRUIT ID
    public String getFruitID(ArrayList<Fruit> fruitList) throws IOException {
        boolean dupID;
        boolean invalidID;
        String id;
        do {
            System.out.print("Enter fruit id: ");
            id = in.readLine().trim();
            invalidID = va.noSpeVal(id); //validate no special char
            dupID = va.checkDupID(id, fruitList); //check for duplicate id
        } while (invalidID == true || dupID == true);
        return id;
    }

    //GET FRUIT NAME
    public String getFruitName() throws IOException {
        boolean invalidName;
        String name;
        do {
            System.out.print("Enter fruit name: ");
            name = in.readLine().trim();
            invalidName = va.noNumSpeHaveSpaceVal(name); //validate no number or special char. But still allow space
        } while (invalidName == true);
        return name;
    }

    //GET FRUIT PRICE
    public int getFruitPrice() throws IOException {
        boolean invalidPrice;
        int price = 0;
        do {
            System.out.print("Enter fruit price: ");
            try {
                price = Integer.parseInt(in.readLine().trim());
                invalidPrice = va.intVal(price); //check if price < 0
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "is not a number. Please enter again");
                System.out.println();
                invalidPrice = true;
            }
        } while (invalidPrice == true);
        return price;
    }

    //GET FRUIT QUANTITY
    public int getFruitQuantity() throws IOException {
        boolean invalidQuantity;
        int quantity = 0;
        do {
            System.out.print("Enter fruit quantity: ");
            try {
                quantity = Integer.parseInt(in.readLine().trim());
                invalidQuantity = va.intVal(quantity);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "is not a number. Please enter again");
                System.out.println();
                invalidQuantity = true;
            }
        } while (invalidQuantity == true);
        return quantity;
    }

    //GET FRUIT ORIGIN
    public String getFruitOrigin() throws IOException {
        boolean invalidOrigin;
        String origin;
        do {
            System.out.print("Enter fruit origin: ");
            origin = in.readLine().trim();
            invalidOrigin = va.noNumSpeHaveSpaceVal(origin); //validate no number or special char. But still allow space
        } while (invalidOrigin == true);
        return origin;
    }

    //GET ORDER FRUIT ITEM
    public int getOrderSelectedInput(ArrayList<Fruit> fruitList) throws IOException {
        boolean invalidInput;
        int selectInput = 0;
        do {
            try {
                System.out.print("Enter item: ");
                selectInput = Integer.parseInt(in.readLine().trim());
                if (selectInput <= 0 || selectInput > fruitList.size()) { //check if item exist
                    System.out.println("There arent any item like that. Please enter again");
                    System.out.println();
                    invalidInput = true;
                } else {
                    invalidInput = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "is not a number. Please enter again"); //check if input not a number
                invalidInput = true;
            }
        } while (invalidInput == true);
        return (selectInput - 1);
    }

    //GET ORDER QUANTITY
    public int getOrderQuantity(int selectItem, ArrayList<Fruit> fruitList) throws IOException {
        boolean invalidQuantity;
        int quantity = 0;
        do {
            try {
                System.out.print("Please input quantity: ");
                quantity = Integer.parseInt(in.readLine());
                if (quantity <= 0) {
                    System.out.println("Please enter positive input");
                    System.out.println();
                    invalidQuantity = true;
                } else if (quantity > fruitList.get(selectItem).getQuantity()) { //check if user try to buy too much
                    System.out.println("You cant order that much. Not enough in stock");
                    System.out.println();
                    invalidQuantity = true;
                } else {
                    invalidQuantity = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "is not a number. Please enter again"); //check if input not a number
                invalidQuantity = true;
            }
        } while (invalidQuantity == true);
        return quantity;
    }

    //GET CUSTOMER NAME
    public String getCustomerName() throws IOException {
        boolean invalidName;
        String customerName;
        do {
            System.out.print("Input your name: ");
            customerName = in.readLine().trim();
            invalidName = va.noNumSpeHaveSpaceVal(customerName); //validate no number or special char. But still allow space
        } while (invalidName == true);
        return customerName;
    }
}
