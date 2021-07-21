package Amod.ABC;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DayforJMenuBar {
    public static void main(String[] args) {

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


        JFrame jf = new JFrame("标题栏");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.setSize(500,500);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();

        jf.add(panel01);

        //标题栏 JMenuBar JMenu  JMenuItem
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file =new JMenu("文件");
        JMenu edit =new JMenu("编辑");
        JMenu help =new JMenu("帮助");
//设置图标
        //        file.setIcon(JIconsmall.getIconSetWH(17,198,108));
//        edit.setIcon(JIconsmall.getIconSetWH(17,198,108));
//        help.setIcon(JIconsmall.getIconSetWH(17,198,108));



        //添加进入JMenuBar
        jMenuBar.add(file);
        jMenuBar.add(edit);
        jMenuBar.add(help);


        // file new MenuItem;
        JMenuItem newfile = new JMenuItem("新建");
        JMenuItem openfile= new JMenuItem("打开");
        JMenuItem exitfile= new JMenuItem("关闭");

        //MenuItem方法
        newfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("新建");
                new DayforNewJFame();
            }
        });

        //添加进入Menu
        file.add(newfile);
        file.add(openfile);
        file.addSeparator();
        file.add(exitfile);

        //edit中子菜单
        JMenuItem copy = new JMenuItem("复制");
        JMenuItem cut= new JMenuItem("剪接");
        JMenuItem put= new JMenuItem("粘贴");

        cut.setMnemonic(KeyEvent.VK_N);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));

        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("使用");
            }
        });

       jf.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
               if (e.getModifiersEx()==KeyEvent.CTRL_DOWN_MASK && e.getKeyCode()=='C'){
                   System.out.println("CTRL+C");

               }
           }
       });

        exitfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("被点击");
            }
        });

        edit.add(cut);
        edit.add(copy);
        edit.add(put);

        JMenuItem imageCut =new JMenuItem("截图");
        help.add(imageCut);
        JMenuItem select =new JMenuItem("查询");
        help.add(select);

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DayforGetOwner();
            }
        });


        imageCut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("截图");
                try {
                    new DayforImageCut();
                } catch (Exception e1) {
                    System.out.println("截图错误");
                }

            }
        }) ;



        jf.setJMenuBar(jMenuBar);

//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);



    }
}
