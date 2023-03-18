/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

/**
 * Object class used to signify all attributes of a specific item
 *
 * @author david
 */
public class Item {

    private final int itemId;
    private final String itemName;
    private final String itemCategory;
    private final int itemPrice;
    private int itemQuantity;
    private final String itemDescription;
    private final String itemImage;
    public static ItemList inventory;

    /**
     * Constructor
     *
     * @param id unique number for the Item
     * @param name name of the Item
     * @param category category in which the Item is in
     * @param price price per unit of the Item
     * @param qty quantity per unit of the Item
     * @param desc description of the Item
     * @author david
     */
    //CONSTRUCTOR
    public Item(int id, String name, String category, int price, int qty, String desc) {
        this.itemId = id;
        this.itemName = name;
        this.itemCategory = category;
        this.itemPrice = price;
        this.itemQuantity = qty;
        this.itemDescription = desc;
        String fileName = String.valueOf(id) + ".jpg";
        this.itemImage = fileName;
    }

    //SETTERS
    /**
     * decreaseQty takes a value and decreases the quantity of the Item by that
     * value
     *
     * @param qty value to decrease the quantity by
     */
    public void decreaseQty(int qty) {
        this.itemQuantity -= qty;
    }

    //GETTERS
    /**
     * getItemId returns the id for an item
     *
     * @return itemId
     */
    public int getItemId() {
        return this.itemId;
    }

    /**
     * getItemName returns the name for an item
     *
     * @return itemName
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * getItemCategory returns the category for an item
     *
     * @return itemCategory
     */
    public String getItemCategory() {
        return this.itemCategory;
    }

    /**
     * getItemPrice returns the price per unit for an item
     *
     * @return itemPrice
     */
    public int getItemPrice() {
        return this.itemPrice;
    }

    /**
     * getItemQuantity returns the quantity per unit on hand for an item
     *
     * @return itemQuantity
     */
    public int getItemQuantity() {
        return this.itemQuantity;
    }

    /**
     * setItemQuantity changes the itemQuantity to the passed in value
     *
     * @param value - the value to change the quantity to
     */

    public void setItemQuantity(int value) {
        this.itemQuantity = value;
    }

    /**
     * getItemDescription returns the description for an item
     *
     * @return itemDescription
     */
    public String getItemDescription() {
        return this.itemDescription;
    }

    /**
     * getItemImage returns the image filename for an item
     *
     * @return itemImage
     */
    public String getItemImage() {
        return this.itemImage;
    }
}
