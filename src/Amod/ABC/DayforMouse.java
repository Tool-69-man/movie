package Amod.ABC;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DayforMouse{
    public static int width;
    public  static int  height;





    public static void initUI(JFrame jf , JButton jButton,int  width,int  height) {
        jButton.addMouseListener(new MouseListener() {
            private int width=DayforMouse.width;

            @Override
            public void mouseClicked(MouseEvent e) {//按下并释放

            }

            @Override
            public void mousePressed(MouseEvent e) {//按下
                jf.setBounds(0,0,100,100);
//                JPanel jPanel02 =new JPanel();
//                jPanel02.setBackground(new Color(220,200,120));
//                jf.add(jPanel02);
                try {
                    for (int i=0;i<600;i+=2){
                        jf.setSize(width+i,height+i*2);
                        Thread.sleep(1);
                    }


                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {//释放

            }

            @Override
            public void mouseEntered(MouseEvent e) {//进入



            }

            @Override
            public void mouseExited(MouseEvent e) {//离开

            }
        });

    }


    public DayforMouse(JFrame jFrame,JButton jButton){


        new Thread(new Runnable() {
            @Override
            public void run() {
                width =jFrame.getWidth();
                height =jFrame.getHeight();
                initUI(jFrame,jButton,width,height);
            }
        }).start();



    }




}
