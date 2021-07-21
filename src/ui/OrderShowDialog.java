package ui;

import Amod.ABC.JFUI3;
import ui.UIUP.Showtable;
import util.CheckHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OrderShowDialog extends JDialog {
    public OrderShowDialog(String orderData){
        new JFUI3();
        setTitle("查看订单详情");
        setResizable(false);
        Container contentPane =getContentPane();
        JPanel dialogpane =new JPanel(new BorderLayout());
//        dialogpane.setBorder(new EmptyBorder(20,20,20,20));
        dialogpane.add( new  Showtable(CheckHandler.showOrder(orderData)),BorderLayout.CENTER);
        contentPane.add(dialogpane,BorderLayout.CENTER);
        setSize(800,600);
        setResizable(false);
        setLocationRelativeTo(getOwner());
        setVisible(true);





//        initUI(orderData);





    }







    private void initUI(String orderData) {
        setTitle("查看订单详情");
        setResizable(false);
        Container contentPane =getContentPane();


        JPanel dialogpane =new JPanel(new BorderLayout());

        dialogpane.setBorder(new EmptyBorder(20,20,20,20));

        JLabel jLabel =new JLabel();
        jLabel.setVerticalAlignment(SwingConstants.TOP);
        jLabel.setPreferredSize(new Dimension(350,350));
        jLabel.setText(CheckHandler.showOrder(orderData));

        dialogpane.add(jLabel);
        contentPane.add(dialogpane,BorderLayout.CENTER);
        setSize(400,400);
        setResizable(false);
        setLocationRelativeTo(getOwner());
        setVisible(true);


    }


}
