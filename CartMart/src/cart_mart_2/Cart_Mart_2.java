/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cart_mart_2;

import inventory_manager.ManagerView;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cart Mart main
 *
 * @author david
 */
public class Cart_Mart_2 {

    static MainGUIFrame frame;
    static CartView cart;
    static loginView login;
    static WelcomePage welcome;
    static ReceiptView receipt;
    static Delivery_Info delivery;
    static PickUp pickUp;
    static CreateAccount create;
    static ManagerView manager;
    static AccountView account;
    static Boolean inCart = false;
    static Boolean inReceipt = false;
    static Boolean inAccount = false;
    static Boolean oldOrder = false;

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        final String file = "src/cart_mart_2/resources/inventoryList.json";
        var json = JsonReader.readJsonFromFile(file);
        //the replaceAll function call is needed to remove whitespaces from the string
        json = json.replaceAll("\\s+", " ");
        //generate the array of items from the database
        ItemList inventory = new ItemList(json);
        Item.inventory = inventory;
        //generate the actual store
        frame = new MainGUIFrame();
        //go to the login screen to start
        login = new loginView();
        login.setVisible(true);
        //the rest of the program is bouncing around the various views 
        //utilizing the background logic
    }

    public static void refresh(int count) {
        //need to update the cart counter
        frame.setCartText(count);
    }

    public static void printOrder() {
        //saves the order in a file for later viewing
        Order.saveOrder();
    }

    /**
     * got in too deep before realizing that we really needed an observer so
     * went this route views: 
     * 1: MainGUIFrame: ViewItems: ItemPanel 
     * 2: CartView
     * 3: ReceiptView 
     * 4: CreateAccount 
     * 5: LoginView 
     * 6: WelcomePage 
     * 7: PickUp 
     * 8: Delivery_Info 
     * 9: AccountView 
     * 10:Mgr application
     *
     * @param current
     * @param next
     */
    public static void changeView(int next, int current) {
        switch (next) {
            case 1:
                switch (current) {
                    case 2:

                        cart.setVisible(false);
                        frame.setVisible(true);
                        break;
                    case 7:
                        pickUp.setVisible(false);
                        frame.setVisible(true);
                        break;
                    case 8:
                        delivery.setVisible(false);
                        frame.setVisible(true);
                        break;
                }
                break;
            case 2:
                switch (current) {
                    case 1:
                        oldOrder = false;
                        inAccount = false;
                        cart = new CartView();
                        frame.setVisible(false);
                        cart.setVisible(true);
                        break;
                    case 2:

                        break;

                }
                break;
            case 3:
                switch (current) {
                    case 2:
                        cart.setVisible(false);
                        inCart = false;
                        inReceipt = true;
                        //create itemlist from order
                        ItemList orderList = new ItemList();
                        for (int item : Order.itemIdList) {
                            for (int i = 0; i < Item.inventory.getCount(); i++) {
                                if (item == Item.inventory.getItem(i).getItemId()) {
                                    orderList.addItem(Item.inventory.getItem(i));
                                    break;
                                }
                            }
                        }
                        receipt = new ReceiptView(orderList);
                        receipt.setVisible(true);
                        break;
                    case 9:
                        ReceiptView.orderTotal = 0;
                        account.setVisible(false);
                        inReceipt = true;
                        inAccount = false;
                        oldOrder = true;
                        orderList = new ItemList();
                        for (int item : Order.itemIdList) {
                            for (int i = 0; i < Item.inventory.getCount(); i++) {
                                if (item == Item.inventory.getItem(i).getItemId()) {
                                    orderList.addItem(Item.inventory.getItem(i));
                                    break;
                                }
                            }
                        }
                        receipt = new ReceiptView(orderList);
                        receipt.setVisible(true);
                        break;
                }
                break;
            case 4:
                switch (current) {
                    case 5:
                        create = new CreateAccount();
                        login.setVisible(false);
                        create.setVisible(true);
                        break;
                    case 9:
                        create = new CreateAccount();
                        account.setVisible(false);
                        create.setVisible(true);
                        break;
                }
                break;
            case 5:
                switch (current) {
                    case 4:
                        create.setVisible(false);
                        login.setVisible(true);
                        break;
                    case 6:
                        welcome.setVisible(false);
                        login.setVisible(true);
                        break;
                    case 9:
                        login = new loginView();
                        account.setVisible(false);
                        login.setVisible(true);
                        break;
                }
                break;
            case 6:
                switch (current) {
                    case 4:
                        welcome = new WelcomePage();
                        create.setVisible(false);
                        welcome.setVisible(true);
                        break;
                    case 5:
                        welcome = new WelcomePage();
                        login.setVisible(false);
                        welcome.setVisible(true);
                        break;
                    case 8:
                        delivery.setVisible(false);
                        welcome.setVisible(true);
                        break;
                    case 9:
                        account.setVisible(false);
                        welcome = new WelcomePage();
                        welcome.setVisible(true);
                        break;
                }
                break;
            case 7:
                switch (current) {
                    case 6:
                        pickUp = new PickUp();
                        welcome.setVisible(false);
                        pickUp.setVisible(true);
                        break;
                    case 8:
                        delivery = new Delivery_Info();
                        pickUp.setVisible(false);
                        delivery.setVisible(true);
                        break;
                }
                break;
            case 8:
                switch (current) {
                    case 6:
                        delivery = new Delivery_Info();
                        welcome.setVisible(false);
                        delivery.setVisible(true);
                        break;
                    case 7:
                        delivery = new Delivery_Info();
                        pickUp.setVisible(false);
                        delivery.setVisible(true);
                        break;
                }
                break;
            case 9:
                Order.itemIdList.clear();
                Order.qtyList.clear();
                switch (current) {
                    case 1:
                        account = new AccountView();
                        frame.setVisible(false);
                        account.setVisible(true);
                        break;
                    case 3:
                        account = new AccountView();
                        receipt.setVisible(false);
                        account.setVisible(true);
                        break;
                }
                break;
            case 10:
                switch (current) {
                    case 5: {
                        try {
                            manager = new ManagerView();
                        } catch (Exception ex) {
                            Logger.getLogger(Cart_Mart_2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    login.setVisible(false);
                    manager.setVisible(true);

                }
                break;
        }
    }
}
