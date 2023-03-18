/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class AccountPanel extends JPanel {

    String orderNumber = "";
    String orderDetails = "";

    /**
     * the function AccountPanel will store the previous orders from the
     * customers in a button labeled "view order details"
     *
     * @param on
     * @param od
     */
    public AccountPanel(String on, String od) {
        this.orderNumber = on;
        this.orderDetails = od;
        JLabel orderLabel = new javax.swing.JLabel();
        JButton viewOrder = new javax.swing.JButton();
        this.setBackground(Color.WHITE);
        orderLabel.setText(orderNumber);
        orderLabel.setPreferredSize(new java.awt.Dimension(160, 20));
        orderLabel.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));
        viewOrder.setText("View Order Details");
        viewOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println(orderNumber);
                Order order = new Order();
                String data[] = od.split(",");
                for (int i = 0; i < data.length; i += 2) {
                    order.itemIdList.add(Integer.valueOf(data[i]));
                    order.qtyList.add(Integer.valueOf(data[i + 1]));
                }
                Cart_Mart_2.changeView(3, 9);
            }
        });
        javax.swing.GroupLayout itemPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(itemPanelLayout);
        itemPanelLayout.setHorizontalGroup(
                itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(itemPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(orderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viewOrder)
                                .addContainerGap(282, Short.MAX_VALUE))
        );
        itemPanelLayout.setVerticalGroup(
                itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(itemPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(orderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(viewOrder))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
