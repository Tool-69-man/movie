package Amod.ABC;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame1 extends JFrame {



    public static void main(String[] args) throws  Exception {

//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    // 设置窗口边框样式
//                    BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//                    org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//                    UIManager.put("RootPane.setupButtonVisible", false);
////                    new MyFrame1();
                    MyFrame1 myFrame1 =new MyFrame1();
                    myFrame1.setVisible(true);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//                    new JFUI();


    }

    public MyFrame1(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);
    }


}
