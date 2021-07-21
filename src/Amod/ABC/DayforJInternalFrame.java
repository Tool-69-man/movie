package Amod.ABC;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;

public class DayforJInternalFrame {
    public static void main(String[] args) throws Exception{
//        new  JFUI2();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // 设置窗口边框样式
                    BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
                    org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
                    UIManager.put("RootPane.setupButtonVisible", false);
                    new JFUI2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
//        SwingUtilities.updateComponentTreeUI(applet);//这里有错误，如果是JFrame应用程序，应该传入JFrame对象，如果是Applet程序，则传入JApplet对象
        JFrame jf = new JFrame("内部窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        new JFUI();
        jf.setSize(500,500);
        // 第 1 个 JPanel, 使用默认的浮动布局


        JDesktopPane jDesktopPane =new JDesktopPane();
        JInternalFrame jInternalFrame = createJInternalFrame();
        jDesktopPane.add(jInternalFrame);
        jf.add(jDesktopPane);
        try {
            jInternalFrame.setSelected(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

//        jf.add(panel01);
//        jf.setContentPane(panel01);
//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static JInternalFrame createJInternalFrame(){
        new  JFUI();
        JInternalFrame jInternal = new JInternalFrame( "内部窗口",  // title
                true,       // resizable
                true,       // closable
                true,       // maximizable
                true        // iconifiable
                );

        JPanel panel01 = new JPanel();
        JButton jButton = new JButton("内部窗口直接添加控件，当面版用");
        panel01.add(jButton);
        jInternal.add(panel01);
        jInternal.setSize(100,100);
        jInternal.setLocation(100,100);
        jInternal.setContentPane(panel01);
        jInternal.setVisible(true);


        return jInternal;
    }
}
