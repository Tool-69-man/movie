package ui.UIUP;

import Amod.ABC.Demo;
import Amod.ABC.Gif;
import Amod.ABC.JFUI2;
import Amod.ABC.JIconsmall;
import sun.plugin2.os.windows.Windows;
import ui.Login;
import ui.OrderWindow;
import ui.Welcome;
import xyz.cofe.perfomance.GetCounters;
import xyz.cofe.typeconv.GetWeight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Demoforjianting {
    int index =6;


    public static void main(String[] args) {
            new Demoforjianting();
    }

    public Demoforjianting(){



        new JFUI2();
        JFrame jf = new JFrame("");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(1000  ,800);


        jf.setUndecorated(true);
//        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(jf);
//        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel(null);

        JLabel back1= new JLabel(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\002\\cinme.jpg",1000,900));//背景1
        back1.setBounds(-100,-100,1000,900);
        back1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{


                    OrderWindow orderWindow = new OrderWindow();
                    orderWindow.setVisible(true);
                    back1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    jf.dispose();//当前窗口不可见
                }catch (Exception ex){
                    ex.printStackTrace();
                }//报错
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                back1.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });





        JLabel jl1 = new JLabel(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\002\\111(1).png",400,90));
        jl1.setBounds(0,600,500,70);//艺术字
        jl1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.dispose();
                new GifMovies();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jl1.setCursor(new Cursor(Cursor.HAND_CURSOR));

//                    URL classUrl = this.getClass().getResource("");
//                    Image imageCursor = Toolkit.getDefaultToolkit().getImage(classUrl);
//                   yishuzi.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(, new Point(0, 0), "cursor"));

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        JLabel jl2 = new JLabel();//登录
        jl2.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\002\\login4.png",200,200));
        jl2.setBounds(800,0,200 ,200);
        jl2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.dispose();
                Login login =  new Login();
                login.setVisible(true);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jl2.setCursor(new Cursor(Cursor.HAND_CURSOR));

//                    URL classUrl = this.getClass().getResource("");
//                    Image imageCursor = Toolkit.getDefaultToolkit().getImage(classUrl);
//                   yishuzi.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(, new Point(0, 0), "cursor"));

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });




        index = 0;//初始第一张
        int num = 10; //图片数量
        JLabel jlleft = new JLabel();
        jlleft.setBounds(720,500,100,100);
        jlleft.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\002\\leftcolor.png",100,100));
        jlleft.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                back1.setBounds(0,0,1000,800);
//                panel01.remove(back1);

                if (index == 0){
                    index=num;
                }else{
                    index--;
                }


//                JLabel back1 = new JLabel();
                back1.setIcon(Back.getIconSetWH(index,1000,800));
                back1.setLocation(0,0);
//                panel01.add(back1);


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                jf.setSize(1001,800);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jlleft.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



        JLabel jright = new JLabel();
        jright.setBounds(900,500,100,100);
        jright.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\002\\rightcolor.png",100,100));

        jright.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

//                panel01.remove(back1);

                back1.setBounds(0,0,1000,800);
                if (index == num){
                    index = 0;
                }else{
                    index++;
                }
//                JLabel back1 = new JLabel();
                back1.setIcon(Back.getIconSetWH(index,1000,800));
//                panel01.add(back1);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                jf.setSize(1000,801);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jright.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });




        jf.setResizable(false);

        panel01.add(jl1);
        panel01.add(jl2);
        panel01.add(jlleft);
        panel01.add(jright);
        panel01.add(back1);



//        jf添加组件的方法
        jf.add(panel01);
//        jf.getContentPane().add(panel01);
//        jf.setContentPane(panel01);
//        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(jf);


//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }






}
