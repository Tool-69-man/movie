package Amod.ABC;

import javax.swing.*;
import java.awt.*;

public class DayforJTabbedPane {
    public static void main(String[] args) throws Exception {

    new DayforJTabbedPane();
    }


    public DayforJTabbedPane(){

        new JFUI3();


        JFrame jf = new JFrame("asd ");

        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();



//        JTabbedPane jTabbedPane=new JTabbedPane(JTabbedPane.LEFT);
        JTabbedPane jTabbedPane=new JTabbedPane();
        jTabbedPane.setSize(400,400);





        ImageIcon imageIcon = new ImageIcon("X:\\JDBCMysql\\DayForJavaSql\\jpg\\1GQ34353-7.jpg");    // Icon由图片文件形成
        Image image = imageIcon.getImage();                         // 但这个图片太大不适合做Icon
//    为把它缩小点，先要取出这个Icon的image ,然后缩放到合适的大小
        Image smallImage = image.getScaledInstance(192,108,Image.SCALE_SMOOTH);
//    再由修改后的Image来生成合适的Icon
        ImageIcon smallIcon = new ImageIcon(smallImage);

        ImageIcon imageIcon2= new ImageIcon("X:\\JDBCMysql\\DayForJavaSql\\jpg\\347_170213185021_1.jpg");    // Icon由图片文件形成
        Image image2 = imageIcon2.getImage();                         // 但这个图片太大不适合做Icon
//    为把它缩小点，先要取出这个Icon的image ,然后缩放到合适的大小
        Image smallImage2 = image2.getScaledInstance(192,108,Image.SCALE_SMOOTH);
//    再由修改后的Image来生成合适的Icon
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        JButton iconButton = new JButton(smallIcon2);



        jTabbedPane.addTab("one",iconButton);
        jTabbedPane.addTab("two", JIconsmall.getIcon(16) ,new Label("Tab2"));

        jTabbedPane.addTab("three",JIconsmall.getIcon(14)  ,new Label("Tab3"),"this is tip3小提示");
        jTabbedPane.addTab("1",JIconsmall.getIcon(1)  ,new Label("Tab3"),"this is tip3小提示");
        jTabbedPane.addTab("2",JIconsmall.getIcon(2)  ,new Label("Tab3"),"this is tip3小提示");
        jTabbedPane.addTab("3",JIconsmall.getIcon(4)  ,new Label("Tab3"),"this is tip3小提示");
        jTabbedPane.addTab("4",JIconsmall.getIcon(5)  ,new Label("Tab3"),"this is tip3小提示");
        jTabbedPane.addTab("5",JIconsmall.getIcon(7)  ,new Label("Tab3"),"this is tip3小提示");
        jTabbedPane.addTab("6",JIconsmall.getIcon(9)  ,new Label("Tab3"),"this is tip3小提示");
        jTabbedPane.addTab("7",JIconsmall.getIcon(6)  ,new Label("Tab3"),"this is tip3小提示");
        jTabbedPane.addTab("8",JIconsmall.getIcon(14)  ,new Label("Tab3"),"this is tip3小提示");


//        jTabbedPane.addTab("8",JIconsmall.getIcon(14)  ,new ,"this is tip3小提示");

        //对jTabbedpane
        JScrollPane scrollPane2 =new  JScrollPane(jTabbedPane,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
       ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//        JScrollPane scrollPane =new  JScrollPane(jTabbedPane);


//        scrollPane2.setViewportView(jTabbedPane);


//        scrollPane2.setWheelScrollingEnabled(true);
//        panel01.add(jTabbedPane);

//        panel01.add(scrollPane2);
        scrollPane2.add(panel01);
        jf.setContentPane(scrollPane2);
//        N:\NAUTO\NieRAutomata\图片
        jf.add(panel01);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(500,500);
//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);





    }
}
