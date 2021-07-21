package Amod.ABC;

import javax.swing.*;

public class DayforImage {
    public static void main(String[] args) {
        new JFUI();

        JFrame jf = new JFrame("image插入");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.setSize(500,500);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();

//        JFormattedTextField jText = new JFormattedTextField((Document) JIconsmall.getBigImage(15));
//        panel01.add(jText);


        jf.add(panel01);
        jf.setContentPane(panel01);
//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
