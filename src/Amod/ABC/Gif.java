package Amod.ABC;

import ui.Welcome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gif extends JFrame {
    public static void main(String[] args) {
        JFrame jf = new JFrame("A");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        jf.setSize(1920,1080);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();

        JButton jButton = new JButton("开始");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Gif();
            }
        });


        panel01.add( jButton);
//        jf添加组件的方法
        jf.add(panel01);
        jf.getContentPane().add(panel01);
        jf.setContentPane(panel01);


        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);



    }

    public Gif(){
        JFrame jf = new JFrame("");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.setSize(1920,1080);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();


        JLabel jLabel = new JLabel();
        jLabel.setIcon(JIconsmall.getIconSetWH(20,jf.getWidth(),jf.getHeight()));
        jLabel.setBounds(0,0,jf.getWidth(),jf.getHeight());

        panel01.add(jLabel);
//        jf添加组件的方法
        jf.add(panel01);
        jf.getContentPane().add(panel01);
        jf.setContentPane(panel01);

        jf.setLocationRelativeTo(null);
        jf.setVisible(true);





        new Thread(new Runnable() {
            @Override
            public void run() {

                show(jLabel, jf);
            }
        }).start();

//        jf.pack();

    }


    public void show(JLabel jLabel,JFrame jf){
        try {
            for (int i=0;i<1806;i+=10){//i=(i+1)%1804
                jLabel.setIcon(Gifimage.getIcon(i));
                Thread.sleep(1);
            }
            jf.setVisible(false);
            jf.dispose();
            Welcome welcome =  new Welcome();
            welcome.setVisible(true);

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }


}
