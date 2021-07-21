package Amod.ABC;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DayforJToolBar {
    public static void main(String[] args) throws Exception{
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // 设置窗口边框样式
                    BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
                    org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
                    UIManager.put("RootPane.setupButtonVisible", false);
//                    new JFUI2();
                    new DayforJToolBar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
//        new JFUI2();


    }


    public DayforJToolBar(){
        JFrame jf = new JFrame("工具栏");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        new JFUI();
        jf.setSize(500,500);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel(new BorderLayout());
        //工具栏
        JToolBar jToolBar =new JToolBar();
        jToolBar.setSize(100,30);
        jToolBar.setBorderPainted(false);

        jToolBar.setBackground(  new Color(255,245,238));
        //工具栏按钮图标
        JButton start =new JButton(JIconsmall.getIconSetWH(13,30,30));
        JButton left =new JButton(JIconsmall.getIconSetWH(10,30,30));
        JButton right =new JButton(JIconsmall.getIconSetWH(11,30,30));
        JButton query =new JButton(JIconsmall.getIconSetWH(4,30,30));
        JButton stop =new JButton(JIconsmall.getIconSetWH(12,30,30));

        Color stopstart      = new Color(220,230,240);
        Color stopstart2      = new Color(162,181,205);
        Color leftright      = new Color(220,223,227);

        start.setBackground(stopstart2 );
        right.setBackground(leftright);
        left.setBackground(leftright);
        stop.setBackground(stopstart );
//        right.setBackground(Color.get);


        //添加到工具栏
        jToolBar.add(left);
        jToolBar.add(start);
        jToolBar.add(right);
        jToolBar.addSeparator();
        jToolBar.add(query);

//        panel01.setBackground(Color.YELLOW);
        //分割符，方向，可拖动，边距，边框
//        jToolBar.setFloatable(true);
//        jToolBar.setOrientation(SwingConstants.VERTICAL);//SwingConstants.VERTICAL   wingConstants.HORIZONTAL
//        jToolBar.setSize();
        jToolBar.setBorderPainted(false);
//        jToolBar.setBackground(Color.YELLOW);
//        jToolBar.setMargin();//Insets
        //按钮触发
        //start 变成 stop
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("start->stop");
//                start.setIcon(JIconsmall.getIconSetWH(2,30,30));
                jToolBar.remove(1);

                jToolBar.add(stop,1);
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("stop->start");

                jToolBar.remove(1);

                jToolBar.add(start,1);
            }
        });


        panel01.add(jToolBar,BorderLayout.PAGE_START);
        jf.add(panel01);
        jf.setContentPane(panel01);
//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

}
