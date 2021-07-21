package Amod.ABC;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Day01forPanel {
    public static void main(String[] args) throws  Exception{
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    // 设置窗口边框样式
//                    BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//                    org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//                    UIManager.put("RootPane.setupButtonVisible", false);
////                    new JFUI2();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        JFrame jf = new JFrame("用户登录");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            new JFUI3();
        }catch (Exception ex){
            ex.printStackTrace();
        }


        jf.setSize(500,500);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();
        panel01.add(new JLabel("用户名"));
        panel01.add(new JTextField(10));

        // 第 2 个 JPanel, 使用默认的浮动布局
        JPanel panel02 = new JPanel();
        panel02.add(new JLabel("密   码"));
        panel02.add(new JPasswordField(10));

        // 第 3 个 JPanel, 使用浮动布局, 并且容器内组件居中显示
        JPanel panel03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel03.add(new JButton("登录"));
        panel03.add(new JButton("注册"));

        // 创建一个垂直盒子容器, 把上面 3 个 JPanel 串起来作为内容面板添加到窗口
//        Box vBox = Box.createVerticalBox();
//        Box vBox = Box.createHorizontalBox();

//        vBox.add(panel01);
//        vBox.add(panel02);
//        vBox.add(panel03);
//        jf.setContentPane(vBox);


//        jf.add(panel01,BorderLayout.NORTH);
//        jf.add(panel02,BorderLayout.CENTER);
//        jf.add(panel03,BorderLayout.SOUTH);
        JPanel mainPanel =new JPanel(new GridLayout(0,1));
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        mainPanel.add(panel01,BorderLayout.CENTER);
        mainPanel.add(panel02);
        mainPanel.add(panel03);
        jf.add(mainPanel,BorderLayout.CENTER);



//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
