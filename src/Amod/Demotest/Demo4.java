package Amod.Demotest;

import Amod.ABC.JFUI3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Demo4 {




    public static void main(String[] args) {
        new JFUI3();
        new Demo4();
    }

    public Demo4(){


        JFrame jf = new JFrame("");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.setSize(1000,700);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel(new BorderLayout());

        JButton jButton= new JButton("demo03");

//        jf.add(new org.jb2011.swing9patch.fixtip.Demo());




        panel01.add(jButton,BorderLayout.NORTH);

        jButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.setSize(1000,701);
                System.out.println("ad");
//           panel01.add( new Dayfor.Swinglearn.Demo.fixtip.Demo(),BorderLayout.CENTER);
//                panel01.add(demo[0],BorderLayout.CENTER,1);
//                panel01.add( new Dayfor.Swinglearn.Demo.popup.Demo(),BorderLayout.CENTER);
           panel01.add( new Amod.Demo.toast.Demo(),BorderLayout.CENTER);
            }

            @Override
            public void mousePressed(MouseEvent e) {



//           jf.pack();
//             Demo demo01=  new org.jb2011.swing9patch.fixtip.Demo();
//                demo01.setVisible(true);
//                demo01.setSize(300,300);
//                panel01.add(demo01);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                jf.setSize(1001,700);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });




        jf.setContentPane(panel01);
//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}


