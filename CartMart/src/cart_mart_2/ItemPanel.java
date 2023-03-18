/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class ItemPanel extends JPanel {

    int itemQuantity;
    public static int cartCount = 0;
    private static Order order;

    /**
     * constructor is called to create a new JPanel for each item to be
     * displayed
     *
     * @param itemNum
     * @param itemName
     * @param itemDesc
     * @param itemPrice
     * @param itemQty
     * @param orderQty
     */
    public ItemPanel(int itemNum, String itemName, String itemDesc, int itemPrice, int itemQty, int orderQty) {
        JLabel image = new javax.swing.JLabel();
        JLabel name = new javax.swing.JLabel();
        JLabel description = new javax.swing.JLabel();
        JLabel price = new javax.swing.JLabel();
        JTextField quantity = new javax.swing.JTextField();
        JButton incButton = new javax.swing.JButton();
        JButton decButton = new javax.swing.JButton();
        JButton addToCart = new javax.swing.JButton();
        JLabel lineTotal = new javax.swing.JLabel();
        lineTotal.setVisible(false);
        this.setBackground(Color.WHITE);
        itemQuantity = itemQty;
        if (order == null) {
            order = new Order();
        }
        try {
            ImageIcon pic = new ImageIcon(Cart_Mart_2.class.getResource("images/" + String.valueOf(itemNum) + ".jpg"));
            image.setIcon(pic);
        } catch (Exception e) {
            ImageIcon pic = new ImageIcon(Cart_Mart_2.class.getResource("images/missing.jpg"));
            image.setIcon(pic);
        }
        image.setText("");
        image.setMaximumSize(new java.awt.Dimension(100, 100));
        image.setMinimumSize(new java.awt.Dimension(100, 100));
        image.setPreferredSize(new java.awt.Dimension(100, 100));

        name.setText(itemName);
        name.setMaximumSize(new java.awt.Dimension(160, 20));
        name.setMinimumSize(new java.awt.Dimension(160, 20));
        name.setPreferredSize(new java.awt.Dimension(160, 20));
        name.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));

        description.setText(itemDesc);
        description.setMaximumSize(new java.awt.Dimension(160, 20));
        description.setMinimumSize(new java.awt.Dimension(160, 20));
        description.setPreferredSize(new java.awt.Dimension(160, 20));
        description.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));
        price.setText("$" + String.format("%.2f", (float) itemPrice / 100.0));
        quantity.setText(String.valueOf(orderQty));
        incButton.setText("+");
        decButton.setText("-");
        addToCart.setText("ADD");

        incButton.setPreferredSize(new java.awt.Dimension(41, 30));
        decButton.setPreferredSize(new java.awt.Dimension(41, 30));
        addToCart.setPreferredSize(new java.awt.Dimension(60, 30));
        lineTotal.setPreferredSize(new java.awt.Dimension(60, 30));
        quantity.setPreferredSize(new java.awt.Dimension(50, 30));
        quantity.setHorizontalAlignment(JTextField.CENTER);
        quantity.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));
        price.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));

        if (Cart_Mart_2.inCart) {
            addToCart.setPreferredSize(new java.awt.Dimension(80, 30));
            addToCart.setText("Update");
        }
        if (Cart_Mart_2.inReceipt) {
            incButton.setVisible(false);
            decButton.setVisible(false);
            addToCart.setVisible(false);
            lineTotal.setText(String.valueOf(25));

            lineTotal.setVisible(true);
        }
        incButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantity.setText(String.valueOf(incButtonMouseClicked(evt, Integer.valueOf(quantity.getText()))));
            }
        });
        decButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantity.setText(String.valueOf(decButtonMouseClicked(evt, Integer.valueOf(quantity.getText()))));
            }
        });
        addToCart.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (Integer.valueOf(quantity.getText()) != 0) {
                    Boolean itemInCart = false;
                    for (int i = 0; i < order.itemIdList.size(); i++) {
                        if (order.itemIdList.get(i) == itemNum) {
                            itemInCart = true;
                            order.qtyList.set(i, Integer.valueOf(quantity.getText()));
                        }
                    }
                    if (!itemInCart) {
                        cartCount++;
                        order.itemIdList.add(itemNum);
                        order.qtyList.add(Integer.valueOf(quantity.getText()));
                    }
                }
                if (Integer.valueOf(quantity.getText()) == 0 && Cart_Mart_2.inCart) {
                    for (int i = 0; i < order.itemIdList.size(); i++) {
                        if (order.itemIdList.get(i) == itemNum) {
                            if (Integer.valueOf(quantity.getText()) == 0) {
                                order.itemIdList.remove(i);
                                order.qtyList.remove(i);
                                cartCount--;
                                Cart_Mart_2.refresh(cartCount);
                            }
                        }
                    }
                }
                if (!Cart_Mart_2.inCart) {
                    Cart_Mart_2.refresh(cartCount);
                }
            }
        });

        javax.swing.GroupLayout itemPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(itemPanelLayout);
        itemPanelLayout.setHorizontalGroup(
                itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(itemPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(itemPanelLayout.createSequentialGroup()
                                                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(217, 217, 217))
                                        .addGroup(itemPanelLayout.createSequentialGroup()
                                                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(incButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(decButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(23, Short.MAX_VALUE))))
        );
        itemPanelLayout.setVerticalGroup(
                itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(itemPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(itemPanelLayout.createSequentialGroup()
                                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(incButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(decButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

    /**
     * this function increases the number in the quantity field by 1 for each
     * click
     *
     * @param evt
     * @param num
     * @return
     */
    private int incButtonMouseClicked(java.awt.event.MouseEvent evt, int num) {
        if (num == itemQuantity) {
            JOptionPane.showMessageDialog(null, String.valueOf(num) + " is the maximum allowed.");
            return num;
        }
        num++;
        return num;
    }

    /**
     * this function decreases the number in the quantity field by 1 for each
     * click
     *
     * @param evt
     * @param num
     * @return
     */
    private int decButtonMouseClicked(java.awt.event.MouseEvent evt, int num) {
        if (num == 0) {
            return num;
        }
        num--;
        return num;
    }
}
