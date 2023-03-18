/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Order extends ItemList {

    public static ArrayList<Integer> qtyList;
    public static ArrayList<Integer> itemIdList;
    public static String historyToSave;
    public static int orderNumber;

    /**
     * Order is the object to maintain track of what the user adds to a cart
     */
    public Order() {
        qtyList = new ArrayList<>();
        itemIdList = new ArrayList<>();
    }

    /**
     * addItem adds an item to the order
     *
     * @param itemNum
     * @param qty
     */
    public void addItem(int itemNum, int qty) {
        qtyList.add(qty);
    }

    /**
     * getItem returns the item ID of a specific item in the order
     *
     * @param index
     * @return
     */
    public Item getItem(int index) {
        return itemList.get(index);
    }

    /**
     * getQty returns the quantity of a specific item in the order
     *
     * @param index
     * @return
     */
    public int getQty(int index) {
        return qtyList.get(index);
    }

    /**
     * saveOrder saves the order to the customer data file so it can be
     * retrieved and viewed at a later time
     */
    public static void saveOrder() {
        if (!Cart_Mart_2.oldOrder) {

            historyToSave = ReceiptPanel.orderForHistory.substring(0, ReceiptPanel.orderForHistory.length() - 1);

            try ( FileWriter fw = new FileWriter("src/cart_mart_2/resources/" + User.userName + ".txt", true);  BufferedWriter bw = new BufferedWriter(fw);  PrintWriter out = new PrintWriter(bw)) {
                out.println(orderNumber + ":" + historyToSave);
            } catch (Exception e) {
                System.out.println("An unexpected error occured.");
            }
        }
    }
}
