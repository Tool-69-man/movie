package Amod.ABC;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;

public class Beautiful extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // 设置窗口边框样式
                    BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
                    BeautyEyeLNFHelper.launchBeautyEyeLNF();
                    UIManager.put("RootPane.setupButtonVisible", false);

                    Beautiful myFrame1 = new Beautiful();
                    myFrame1.setVisible(true);
                    myFrame1.setVisible(true);
                    myFrame1.setSize(500,500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Beautiful(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
