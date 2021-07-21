package Amod.ABC;

import java.awt.event.*;
import javax.swing.border.*;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;

public class Text {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // 设置窗口边框样式
                    BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
                    org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
                    UIManager.put("RootPane.setupButtonVisible", false);
//                    new JFUI2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JFrame jf = new JFrame("Mouse");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container container = jf.getContentPane();
        jf.setSize(300,300);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();
        panel01.setBackground(new Color(220,025,255));
        JButton jButton =new JButton("MOUSE");

        new DayforMouse(jf,jButton);
        panel01.add(jButton);
//        jf.add(jButton);
        jf.add(panel01);
        jf.setContentPane(panel01);
//        jf.pack();

        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }


}
