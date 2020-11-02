package Functions;

import Entities.*;
import java.util.ArrayList;

public class ViewOrder {

    //PRINT OUT ORDERS
    public void viewOder(ArrayList<StoreOrder> orderList) {
        for (int i = 0; i < orderList.size(); i++) {
            orderList.get(i).orderDisplay();
        }
    }
}
