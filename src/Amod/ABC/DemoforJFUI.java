package Amod.ABC;

import javafx.scene.control.RadioButton;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Amod.ABC.JIconsmall.getIconSetWH;

public class DemoforJFUI {
    public static void main(String[] args) {
//        new JFUI2();/**/



//        new JFUI();

        new JFUI3();

//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    // 设置窗口边框样式
//                    BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//                    org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//                    UIManager.put("RootPane.setupButtonVisible", false);
//                    new JFUI2();
//                    new DemoforJFUI();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        new DemoforJFUI();
    }

    public DemoforJFUI(){
        JFrame jf = new JFrame("");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.setSize(900,600);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel(new GridLayout(0,1));

        JButton jButton = new JButton("name");
        jButton.setBounds(10,10,100,100);

        JLabel jLabel = new JLabel("文本+图片");
        jLabel.setIcon(getIconSetWH(15,192,108));
//        jLabel.setHorizontalAlignment(SwingConstants.LEADING);
        jLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        jLabel.setVerticalTextPosition(SwingConstants.TOP);
        jLabel.setIconTextGap(10);

        jLabel.setFont(new Font("微软雅黑",Font.TRUETYPE_FONT,15));

        JRadioButton radioButton12 = new JRadioButton("12");

        final JButton btn = new JButton();

        // 设置按钮的默认图片
        btn.setIcon(getIconSetWH(22,192,108));

        // 设置按钮被点击时的图片
        btn.setPressedIcon(getIconSetWH(23,192,108));

        // 不绘制边框
        btn.setBorderPainted(false);

        // 添加按钮点击事件监听器
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
            }
        });



        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.setSize(300,108);
        jTabbedPane.add("   1   ",new JLabel(getIconSetWH(30,150,80)));
        jTabbedPane.add("   2   ",new JLabel(getIconSetWH(29,150,80)));
        jTabbedPane.add("   3   ",new JLabel(getIconSetWH(28,160,80)));
        jTabbedPane.add("   4   ",new JLabel(getIconSetWH(27,132,80)));

        panel01.add(jTabbedPane);
        panel01.add(btn);
        panel01.add(jButton);
        panel01.add(jLabel);
        panel01.add(radioButton12);

//        jf添加组件的方法

        jf.setContentPane(panel01);


//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
