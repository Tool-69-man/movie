package Amod.Demotest;

import Amod.ABC.JFUI3;
import com.sun.org.apache.bcel.internal.generic.I2B;
import org.jb2011.swing9patch.fixtip.Demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//new org.jb2011.swing9patch.fixtip.Demo()
public class Demo01 {
    int i ;//图片数字

    public static void main(String[] args) {
        new JFUI3();
        new Demo01();
    }

    public Demo01(){


        JFrame jf = new JFrame("");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.setSize(1000,700);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel(new BorderLayout());

        JButton jButton= new JButton("demo01");
        JButton jnext= new JButton("next");
//        jf.add(new org.jb2011.swing9patch.fixtip.Demo());



        i=18;
        final Amod.Demo.photoframe.Demo[] demo = {new Amod.Demo.photoframe.Demo(i)};
        panel01.add(jButton,BorderLayout.NORTH);
        panel01.add(jnext,BorderLayout.SOUTH);
        jnext.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.setSize(1000,701);
                panel01.remove(demo[0]);
//                Dayfor.Swinglearn.Demo.photoframe.Demo demo1 = new  Dayfor.Swinglearn.Demo.photoframe.Demo(12);
                demo[0] = new Amod.Demo.photoframe.Demo(i++);
                panel01.add(demo[0],BorderLayout.CENTER);

            }

            @Override
            public void mousePressed(MouseEvent e) {

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

        jButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jf.setSize(1000,701);
                System.out.println("ad");
//           panel01.add( new Dayfor.Swinglearn.Demo.fixtip.Demo(),BorderLayout.CENTER);
                panel01.add(demo[0],BorderLayout.CENTER,1);
//           panel01.add( new Dayfor.Swinglearn.Demo.popup.Demo(),BorderLayout.CENTER);
//           panel01.add( new Dayfor.Swinglearn.Demo.toast.Demo(),BorderLayout.CENTER);
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

        jf.add(panel01);


        jf.setContentPane(panel01);
//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
