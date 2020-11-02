package Validate_and_GetInput;

import Entities.Fruit;
import java.io.*;
import java.util.*;

public class Validate {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Scanner scan = new Scanner(System.in);

    //VALIDATE Y/N QUESTION
    public boolean ynVal() throws IOException {
        boolean ynCheck;
        boolean addMore = false;
        do {
            System.out.print("Do you want to continue (Y/N) ? ");
            String check = in.readLine().trim();
            if (check.equalsIgnoreCase("y")) {          //if y then return to adding student
                ynCheck = true;
                addMore = true;
            } else if (check.equalsIgnoreCase("n")) {   //if n then end the function
                ynCheck = true;
                addMore = false;
                System.out.println();
            } else {
                System.out.println("Wrong input. Please enter Y or N only");
                ynCheck = false;
            }
        } while (ynCheck == false);
        return addMore;
    }

    //VALIDATE STRING HAVE NO SPECIAL CHAR
    public boolean noSpeVal(String input) {
        boolean invalidInput;
        input = input.trim();
        if (input == null || input.equals("")) {      //check for blank input
            System.out.println("Blank input. Please enter again");
            System.out.println();
            invalidInput = true;
        } else if (!input.matches("[a-zA-Z0-9]*")) { //check if ID having special characters
            System.out.println("No special character allowed");
            System.out.println();
            invalidInput = true;
        } else {
            invalidInput = false;
        }
        return invalidInput;
    }

    //VALIDATE STRING HAVE NO NUMB, SPE BUT HAVE SPACE
    public boolean noNumSpeHaveSpaceVal(String string) {
        boolean invalidString;
        string = string.trim();
        if (string == null || string.equals("")) {  //check for blank input
            System.out.println("Blank input. Please enter again");
            System.out.println();
            invalidString = true;
        } else if (!string.matches("[a-zA-Z\\s]*")) {  //check for name to be character and space only
            System.out.println("No number or special character allowed");
            System.out.println();
            invalidString = true;
        } else {
            invalidString = false;
        }
        return invalidString;
    }

    //VALIDATE PRICE
    public boolean intVal(int price) {
        boolean invalidInt = false;
        if (price < 0) {
            System.out.println("Please enter a positive value");
            System.out.println();
            invalidInt = true;
        }
        return invalidInt;
    }
    
    //CHECK FOR DUPLICATE ID
    public boolean checkDupID(String id, ArrayList<Fruit> fruitList) {
        boolean dupID = false;
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).getId().equalsIgnoreCase(id) == true) {   //check if the new id is the same as another id
                System.out.println("This id has already taken. Please enter different id");
                dupID = true;
                break;
            } else {
                dupID = false;
            }
        }
        return dupID;
    }
}
