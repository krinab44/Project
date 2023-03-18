/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class ReceiptPanel extends JPanel {

    private int lineTotal = 0;
    static public int orderTotal = 0;
    private int qty = 0;
    public static String orderForHistory = "";

    /**
     * constructor is called to create a new JPanel for each item to be
     * displayed
     *
     * @param name
     * @param price
     * @param item
     */
    public ReceiptPanel(String name, int price, int item) {
        JLabel nameLabel = new javax.swing.JLabel();
        JLabel priceLabel = new javax.swing.JLabel();
        JLabel totalLabel = new javax.swing.JLabel();
        JLabel qtyLabel = new javax.swing.JLabel();
        for (int i = 0; i < Order.itemIdList.size(); i++) {
            if (Order.itemIdList.get(i) == item) {
                qty = Order.qtyList.get(i);
                orderForHistory += String.valueOf(Order.itemIdList.get(i));
                orderForHistory += ",";
                orderForHistory += String.valueOf(Order.qtyList.get(i));
                orderForHistory += ",";
                break;
            }
            if (orderForHistory.length() < 4) {
                orderForHistory += String.valueOf(Order.itemIdList.get(i));
                orderForHistory += ",";
                orderForHistory += String.valueOf(Order.qtyList.get(i));
                orderForHistory += ",";
            }
        }

        lineTotal = price * qty;
        orderTotal += lineTotal;
        ReceiptView.orderTotal += lineTotal;
        this.setBackground(Color.WHITE);
        nameLabel.setText(name);

        priceLabel.setText("$" + String.format("%.2f", (float) price / 100.0));
        qtyLabel.setText(String.valueOf(qty));
        totalLabel.setText("$" + String.format("%.2f", (float) lineTotal / 100.0));

        nameLabel.setPreferredSize(new java.awt.Dimension(160, 20));
        priceLabel.setPreferredSize(new java.awt.Dimension(160, 20));
        totalLabel.setPreferredSize(new java.awt.Dimension(160, 20));
        qtyLabel.setPreferredSize(new java.awt.Dimension(160, 20));

        nameLabel.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));
        priceLabel.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));
        totalLabel.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));
        qtyLabel.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));

        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        qtyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout itemPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(itemPanelLayout);
        itemPanelLayout.setHorizontalGroup(
                itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(itemPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qtyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(224, Short.MAX_VALUE))
        );
        itemPanelLayout.setVerticalGroup(
                itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(itemPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                                        .addComponent(qtyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                                        .addComponent(totalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

}
