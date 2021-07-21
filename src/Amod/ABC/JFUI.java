package Amod.ABC;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;

public class JFUI extends JFrame {
    public JFUI () {

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



//            try {
//                                       // 设置窗口边框样式
//                BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//                BeautyEyeLNFHelper.launchBeautyEyeLNF();
//                UIManager.put("RootPane.setupButtonVisible", false);
//                new JFUI2();
//                } catch (Exception e) {
//                e.printStackTrace();
//                }

//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e);

//        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//        try {
//            BeautyEyeLNFHelper.launchBeautyEyeLNF();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        UIManager.put("RootPane.setupButtonVisible", false);
//        add();


        }

//    }



//        EventQuxeue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//
//                    // 设置窗口边框样式
//                    BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//                    org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//                    UIManager.put("RootPane.setupButtonVisible", false);
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });






}
