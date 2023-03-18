/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

/**
 * InventorySort both filters and sorts a given ItemList
 *
 * @author david
 */
public class InventorySort {

    public ItemList list;
    public ItemList filteredList;
    private ItemList savedList;

    /**
     * Constructor for sorting InventorySort takes a given ItemList and sorts it
     * based on a given criteria The calling function can then access the sorted
     * list via public reference of list
     *
     * @param itemList an ItemList to be sorted
     * @param code what Item parameter is used to sort by 1: name, 2: category,
     * 3: price
     */
    InventorySort(ItemList itemList, int code) {
        this.list = itemList;
        this.savedList = itemList;
        sortList(code);
    }

    /**
     * Constructor for filtering InventorySort takes a given ItemList and
     * filters it based on a given criteria The calling function can then access
     * the sorted list via public reference of filteredList
     *
     * @param itemList an ItemList to be sorted
     * @param code what Item parameter is used to sort by 1: name, 2: category,
     * 3: price
     * @param cond the value used for filtering, i.e. search parameter
     */
    InventorySort(ItemList itemList, int code, String cond) {
        this.list = itemList;
        filterList(code, cond);
    }

    /**
     * sortList() will sort the item list with the resulting list being the same
     * length as the initial
     *
     * @param val
     */
    private void sortList(int val) {
        list = savedList;
        switch (val) {
            //sort by price low to high
            case 0:
                for (int i = 0; i < list.getCount(); i++) {
                    for (int j = i + 1; j < list.getCount(); j++) {
                        if (list.getItem(i).getItemPrice() > list.getItem(j).getItemPrice()) {
                            Item temp = list.getItem(i);
                            list.setItem(list.getItem(j), i);
                            list.setItem(temp, j);
                        }
                    }
                }
                break;
            //sort by price high to low
            case 1:
                for (int i = 0; i < list.getCount(); i++) {
                    for (int j = i + 1; j < list.getCount(); j++) {
                        if (list.getItem(i).getItemPrice() < list.getItem(j).getItemPrice()) {
                            Item temp = list.getItem(i);
                            list.setItem(list.getItem(j), i);
                            list.setItem(temp, j);
                        }
                    }
                }
                break;
            //sort by name A to Z
            case 2:
                for (int i = 0; i < list.getCount(); i++) {
                    for (int j = i + 1; j < list.getCount(); j++) {
                        if (list.getItem(i).getItemName().compareTo(list.getItem(j).getItemName()) > 0) {
                            Item temp = list.getItem(i);
                            list.setItem(list.getItem(j), i);
                            list.setItem(temp, j);
                        }
                    }
                }
                break;
            //sort by name Z to A
            case 3:
                for (int i = 0; i < list.getCount(); i++) {
                    for (int j = i + 1; j < list.getCount(); j++) {
                        if (list.getItem(j).getItemName().compareTo(list.getItem(i).getItemName()) > 0) {
                            Item temp = list.getItem(i);
                            list.setItem(list.getItem(j), i);
                            list.setItem(temp, j);
                        }
                    }
                }
                break;
            case 4:
                break;
            case 5:
                ItemList tempList = new ItemList();
                for (int i = 0; i < list.getCount(); i++) {
                    if (list.getItem(i).getItemCategory().compareTo("Bakery") == 0) {
                        tempList.addItem(list.getItem(i));
                    }
                }
                list = tempList;
                break;
            case 6:
                tempList = new ItemList();
                for (int i = 0; i < list.getCount(); i++) {
                    if (list.getItem(i).getItemCategory().compareTo("Dry Grocery") == 0) {
                        tempList.addItem(list.getItem(i));
                    }
                }
                list = tempList;
                break;
            case 7:
                tempList = new ItemList();
                for (int i = 0; i < list.getCount(); i++) {
                    if (list.getItem(i).getItemCategory().compareTo("Frozen") == 0) {
                        tempList.addItem(list.getItem(i));
                    }
                }
                list = tempList;
                break;
            case 8:
                tempList = new ItemList();
                for (int i = 0; i < list.getCount(); i++) {
                    if (list.getItem(i).getItemCategory().compareTo("Meat") == 0) {
                        tempList.addItem(list.getItem(i));
                    }
                }
                list = tempList;
                break;
            case 9:
                tempList = new ItemList();
                for (int i = 0; i < list.getCount(); i++) {
                    if (list.getItem(i).getItemCategory().compareTo("Produce") == 0) {
                        tempList.addItem(list.getItem(i));
                    }
                }
                list = tempList;
                break;
            case 10:
                tempList = new ItemList();
                for (int i = 0; i < list.getCount(); i++) {
                    if (list.getItem(i).getItemCategory().compareTo("Refrigerated") == 0) {
                        tempList.addItem(list.getItem(i));
                    }
                }
                list = tempList;
                break;
        }
    }

    /**
     * filterList() will remove items within the list that do meet the criteria
     * selected by the user
     *
     * @param code
     * @param cond
     */
    private void filterList(int code, String cond) {

        switch (code) {
            case 1:
                int count1 = 0;

                for (int i = 0; i < list.getCount(); i++) {
                    if (list.getItem(i).getItemName().toLowerCase().contains(cond.toLowerCase())) {
                        count1++;
                    }
                }
                ItemList temp = list;
                filteredList = new ItemList();
                int m = 0;
                int n = 0;
                while (m < count1) {
                    if (temp.getItem(n).getItemName().toLowerCase().contains(cond.toLowerCase())) {
                        filteredList.addItem(temp.getItem(n));
                        n++;
                        m++;
                    } else {
                        n++;
                    }
                }
                break;
            case 2:
                int count2 = 0;
                for (int i = 0; i < list.getCount(); i++) {
                    if (list.getItem(i).getItemCategory().compareTo(cond) == 0) {
                        count2++;
                    }
                }
                temp = list;
                filteredList = new ItemList();
                m = 0;
                n = 0;
                while (m < count2) {
                    if (temp.getItem(n).getItemCategory().compareTo(cond) == 0) {
                        filteredList.addItem(temp.getItem(n));
                        n++;
                        m++;
                    } else {
                        n++;
                    }
                }
                break;
            case 3:
        }
    }
}
