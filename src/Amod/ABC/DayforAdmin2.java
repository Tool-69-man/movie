package Amod.ABC;

import javax.swing.*;
import java.awt.*;

public class DayforAdmin2 {
    public DayforAdmin2(Container mainContent){
       initUI(mainContent);
    }

    public void initUI(Container mainContent){
        JFrame jFrame = new JFrame("set");

        mainContent.removeAll();

        JPanel jPanel = new JPanel();
        jPanel.setVisible(true);
        JButton btn01 = new JButton("Button01");
        JButton btn02 = new JButton("Button02");
        JButton btn03 = new JButton("Button03");
        JButton btn04 = new JButton("Button04");
        JButton btn05 = new JButton("Button05");
        JButton btn06 = new JButton("Button06");
        JButton btn07 = new JButton("Button07");

        // 创建第一个水平箱容器
        Box hBox01 = Box.createHorizontalBox();
        hBox01.add(btn01);
        hBox01.add(Box.createVerticalGlue());
        hBox01.add(btn02);
        hBox01.add(btn03);

        // 创建第二水平箱容器
        Box hBox02 = Box.createHorizontalBox();
        hBox02.add(btn04);
        hBox02.add(Box.createHorizontalGlue()); // 添加一个水平方向胶状的不可见组件，撑满剩余水平空间
        hBox02.add(btn05);
        // 创建第二水平箱容器
        Box hBox03 = Box.createHorizontalBox();
        hBox03.add(Box.createRigidArea(new Dimension(100,100)));
        hBox03.add(btn06);
//                hBox03.add(Box.createVerticalGlue()); // 添加一个水平方向胶状的不可见组件，撑满剩余水平空间
        hBox03.add(btn07);

        // 创建一个垂直箱容器，放置上面两个水平箱（Box组合嵌套）
        Box vBox = Box.createVerticalBox();
        vBox.add(hBox01);
//                vBox.add();
        vBox.add(hBox02);
        vBox.add(hBox03);

        // 把垂直箱容器作为内容面板设置到窗口
//        mainContent.add(vBox);
//        mainContent.setVisible(true);
//        setContentPane(vBox);
        jPanel.add(vBox);
        jPanel.setSize(500,500);
        mainContent.add(jPanel);
        jFrame.setContentPane(mainContent);
        jFrame.setSize(500,500);
        jFrame.setVisible(true);
//        jf.setSize(500,500);
////                jf.pack();
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);
    }


}
