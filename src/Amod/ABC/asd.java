package Amod.ABC;

import javax.swing.*;

public class asd {
    public static void main(String[] args) {
        JFrame jf = new JFrame("");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.setSize(500,500);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel(null);

        JButton jButton = new JButton("sa");
        JButton jButton2 = new JButton("saqwe");
        jButton.setBounds(100,100,100,100);
        jButton2.setBounds(200,200,100,100);
        panel01.add(jButton);
        panel01.add(jButton2);
        jf.add(panel01);
        jf.setContentPane(panel01);
//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
