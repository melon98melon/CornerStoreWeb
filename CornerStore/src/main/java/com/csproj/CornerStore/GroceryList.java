package com.csproj.CornerStore;
import java.util.ArrayList;

public class GroceryList {
    // list can only be up to 50 products
    // to add new item after 50 products, delete an item first
    ArrayList<String> list = new ArrayList<String>();

    //adds item to grocery list
    public void addItem(String product) {
        list.add(product);
        System.out.println("Item added");
    }

    //deletes item in grocery list
    public void deleteItem(int product) {
        list.remove(product);
        System.out.println("Item deleted");
    }

    //prints every item in the list
    public void viewList() {
        for (String product: list) {
            System.out.println(product);
        }
    }
}
