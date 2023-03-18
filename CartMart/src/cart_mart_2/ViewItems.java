/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * ViewItems creates the list of items using ItemPanel 
 * Constructor sets the layout
 *
 * @author david
 */
public class ViewItems extends JPanel {

    public ViewItems() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        this.setBackground(Color.WHITE);
    }

    /**
     * viewItemResults creates a panel for each item in the inventory list
     *
     * @param inventory
     */
    public void viewItemResults(ItemList inventory) {
        if (Cart_Mart_2.inAccount) {
            AccountPanel accountPanel = new AccountPanel(AccountView.orderNumber, AccountView.orderDetails);
            accountPanel.setMaximumSize(new Dimension(715, 50));
            add(accountPanel);
            return;
        }
        for (int i = 0; i < inventory.getCount(); i++) {
            // do not display an item that has a qty of 0
            if (inventory.getItem(i).getItemQuantity() != 0) {
                int itemNum = inventory.getItem(i).getItemId();
                String itemName = inventory.getItem(i).getItemName();
                String itemDesc = inventory.getItem(i).getItemDescription();
                int itemPrice = inventory.getItem(i).getItemPrice();
                int itemQty = inventory.getItem(i).getItemQuantity();
                int orderQty = 0;
                if (Cart_Mart_2.inCart) {
                    orderQty = Order.qtyList.get(i);
                }
                if (Cart_Mart_2.inReceipt) {
                    ReceiptPanel receiptPanel = new ReceiptPanel(itemName, itemPrice, itemNum);
                    receiptPanel.setMaximumSize(new Dimension(715, 50));
                    add(receiptPanel);
                } else {
                    ItemPanel itemPanel = new ItemPanel(itemNum, itemName, itemDesc, itemPrice, itemQty, orderQty);
                    add(itemPanel);
                }

            }
        }
        revalidate();
    }
}
