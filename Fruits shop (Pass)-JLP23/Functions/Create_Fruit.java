package Functions;

import Entities.*;
import Validate_and_GetInput.*;
import java.io.*;
import java.util.*;

public class Create_Fruit {

    Get_Fruit_Input geFruIn = new Get_Fruit_Input();
    Validate va = new Validate();

    //CREATE FRUIT AND ADD IT TO ARRAY
    public ArrayList<Fruit> createFruit(ArrayList<Fruit> fruitList) throws IOException {
        boolean addMore;
        do {
            Fruit fru = new Fruit();
            fru.setId(geFruIn.getFruitID(fruitList));
            fru.setName(geFruIn.getFruitName());
            fru.setOrigin(geFruIn.getFruitOrigin());
            fru.setPrice(geFruIn.getFruitPrice());
            fru.setQuantity(geFruIn.getFruitQuantity());
            fruitList.add(fru);
            addMore = va.ynVal();
        } while (addMore == true);
        return fruitList;
    }

    //DISPLAY ALL FRUIT
    public void displayCreatedFruit(ArrayList<Fruit> fruitList) {
        System.out.println("| ++ Id ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (int i = 0; i < fruitList.size(); i++) {
            System.out.println("       " + fruitList.get(i).getId() + "      |      " + fruitList.get(i).getName() + "     |     " + fruitList.get(i).getOrigin() + "    |      " + fruitList.get(i).getPrice() + "$" + "\n");
        }
    }
}
