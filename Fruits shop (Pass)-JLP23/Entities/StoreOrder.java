package Entities;

import java.util.ArrayList;

public class StoreOrder extends ArrayList<Fruit> {
    
    private String customerName;
    private int total;

    public StoreOrder() {
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    //ORDER DISPLAY FORMAT
    public void orderDisplay() {
        System.out.println();
        System.out.println("Customer: " + this.getCustomerName());
        System.out.println("Product | Quantity | Price | Amount");
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).getName() + "   |   " + this.get(i).getQuantity() + "    |   " + this.get(i).getPrice() + "    |   " + this.get(i).getAmount());
        }
        System.out.println("Total: " + this.getTotal());
        System.out.println();
    }
}
