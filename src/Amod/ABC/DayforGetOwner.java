package Amod.ABC;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DayforGetOwner extends JDialog{
//    public static void main(String[] args) {
//        JFrame jf = new JFrame("获取其他");
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        jf.setSize(500,500);
//        // 第 1 个 JPanel, 使用默认的浮动布局
//        JPanel panel01 = new JPanel();
//        JMenuBar jMenuBar = new JMenuBar();
//        JMenu file =new JMenu("文件");
//        jMenuBar.add(file);
//        JMenuItem newfile = new JMenuItem("新建");
////        newfile.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////
////                initUI("asd");
////            }
////        });
//        file.add(newfile);
//        jf.setJMenuBar(jMenuBar);
//        jf.add(panel01);
//        jf.setContentPane(panel01);
////        jf.pack();
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);
//    }

    public DayforGetOwner(){

        new  JFUI();
        initUI("asda");
    }

    private void  initUI(String orderdata){
        setTitle("查看订单");
        setSize(400,400);
        Container container =getContentPane();
        JPanel jPanel02 =new JPanel(new BorderLayout());
        jPanel02.setBorder(new EmptyBorder(20,20,20,20));
        JLabel jLabel =new JLabel();
        jLabel.setText(orderdata);
        jLabel.setVerticalAlignment(SwingConstants.TOP);
        jLabel.setPreferredSize(new Dimension(350,350));
        jPanel02.add(jLabel);
        container.add(jPanel02,BorderLayout.CENTER);
        setResizable(false);
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }

}
