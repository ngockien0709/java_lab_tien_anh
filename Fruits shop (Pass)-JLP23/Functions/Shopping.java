package Functions;

import Entities.*;
import Validate_and_GetInput.*;
import java.io.*;
import java.util,*

public class Shopping {

    ArrayList<StoreOrder> orderList = new ArrayList<>();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Validate va = new Validate();
    Get_Fruit_Input get = new Get_Fruit_Input();

    //GET CUSTOMER ORDER INTO ARRAY
    public ArrayList<StoreOrder> getCustomerOrder(ArrayList<Fruit> fruitList) throws IOException {
        StoreOrder order = new StoreOrder();
        int total = 0;
        int orderQuantity;
        boolean orderMore;
        if (!fruitList.isEmpty()) {
            do {
                //print the list
                printFruitList(fruitList);

                //get selected item
                int selectItem = get.getOrderSelectedInput(fruitList);

                //print out the name of selected fruit
                for (int i = 0; i < fruitList.size(); i++) {
                    System.out.println("You selected: " + fruitList.get(selectItem).getName());
                    break;
                }

                //get order quantity and reduce the quantity had been bought
                orderQuantity = get.getOrderQuantity(selectItem, fruitList);
                for (int i = 0; i < fruitList.size(); i++) {
                    fruitList.get(selectItem).setQuantity(fruitList.get(selectItem).getQuantity() - orderQuantity);
                    break;
                }

                if (order.isEmpty()) { //if the order list is currently empty
                    //add the order to a order array
                    Fruit x = new Fruit();
                    x.setId(fruitList.get(selectItem).getId());
                    x.setName(fruitList.get(selectItem).getName());
                    x.setOrigin(fruitList.get(selectItem).getOrigin());
                    x.setPrice(fruitList.get(selectItem).getPrice());
                    x.setQuantity(orderQuantity);
                    int orderAmount = fruitList.get(selectItem).getPrice() * orderQuantity;
                    x.setAmount(orderAmount);
                    order.add(x):
                } else { //the order list is not empty
                    for (int i = 0; i < order.size(); i++) {
                        if (fruitList.get(selectItem).getName().equalsIgnoreCase(order.get(i).getName()) == false) { //if not found any same name
                            //add the order to a order array
                            Fruit x = new Fruit();
                            x.setId(fruitList.get(selectItem).getId());
                            x.setName(fruitList.get(selectItem).getName());
                            x.setOrigin(fruitList.get(selectItem).getOrigin());
                            x.setPrice(fruitList.get(selectItem).getPrice());
                            x.setQuantity(orderQuantity);
                            int orderAmount = fruitList.get(selectItem).getPrice() * orderQuantity;
                            x.setAmount(orderAmount);
                            order.add(x);
                            break;
                        } else { //same name found
                            order.get(i).setQuantity(order.get(i).getQuantity() + orderQuantity);
                            order.get(i).setAmount(order.get(i).getPrice() * order.get(i).getQuantity());
                            break;
                        }
                    }
                }

                //remove the item that out of stock
                for (int i = 0; i < fruitList.size(); i++) {
                    if (fruitList.get(i).getQuantity() == 0) {
                        fruitList.remove(i);
                    }
                }

                //ask for more
                if (!fruitList.isEmpty()) {
                    orderMore = va.ynVal();
                } else {
                    orderMore = false;
                }
            } while (orderMore == true);

            //calculate total
            for (int i = 0; i < order.size(); i++) {
                total += order.get(i).getAmount();
            }
            order.setTotal(total);

            //print the recipe
            System.out.println("Product | Quantity | Price | Amount");
            for (int i = 0; i < order.size(); i++) {
                System.out.println("        " + order.get(i).getName() + "        " + order.get(i).getQuantity() + "        " + order.get(i).getPrice() + "       " + order.get(i).getAmount() + "\n");
            }
            System.out.println("Total: " + order.getTotal());

            //get customer name
            String customerName = get.getCustomerName();
            order.setCustomerName(customerName);
            System.out.println();
            //add the order into the order table
            orderList.add(order);
            return orderList;
        } else {
            System.out.println("We are sold out. Good luck next time");
            System.out.println();
            return null;
        }
    }

    //PRINT OUT THE FRUIT LIST
    public void printFruitList(ArrayList<Fruit> fruitList) {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Quantity ++ | ++ Price ++ |");
        for (int i = 0; i < fruitList.size(); i++) {
            System.out.println("       " + (i + 1) + "      |      " + fruitList.get(i).getName() + "     |     " + fruitList.get(i).getQuantity() + "    |      " + fruitList.get(i).getPrice() + "$" + "\n");
        }
    }
}
