package Amod.ABC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DayforAdmin extends JFrame{
    Container containerPane;

    public static void main(String[] args) {
        new DayforAdmin();
    }

    public DayforAdmin(){
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
        new JFUI3();
//        new Gif();


        containerPane = getContentPane();
        JFrame jf = new JFrame("admin");

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();
        //设为空
        panel01.setLayout(null);

        //用户名，密码，性别 标签
        JLabel admin = new JLabel("姓名:");
        JLabel pass = new JLabel("密码:");
        JLabel sex = new JLabel("性别:");
        admin.setBounds(100,50,30,30);
        pass.setBounds(100,100,30,30);
        sex.setBounds(100,150,30,30);

        //文本框
        JTextField jTextField = new JTextField();
        JPasswordField jPasswordField = new JPasswordField();
        jTextField.setBounds(165,50,140,30);
        jPasswordField.setBounds(165,100,140,30);


        //单选 男，女
        JRadioButton man = new JRadioButton("男");
        JRadioButton wonmen = new JRadioButton("女");
        //按钮组
        ButtonGroup group = new ButtonGroup();
        group.add(man);
        group.add(wonmen);
        //单选按钮位置
        man.setBounds(170,150,50,30);
        wonmen.setBounds(250,150,50,30);
        //默认选中
        man.setSelected(true);
        //注册重置按钮
        JButton jb =new JButton("注册");
        JButton jb2 =new JButton("重置");
        jb.setBounds(135,200,70,30);
        jb2.setBounds(240,200,70,30);
        //注册不为空就成功
        jb.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                //不为空
                boolean flag = false;
                String name = jTextField.getText();
                String password = new String (jPasswordField.getPassword());
                if (!name.equals("")&&!password.equals("")){
//                    JOptionPane.showMessageDialog(jf,"success","注册提示框",JOptionPane.PLAIN_MESSAGE);
                    new DayforAdmin2(containerPane);
                    setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(jf,"不能为空","注册提示框",JOptionPane.WARNING_MESSAGE);
                }//判断是否出错

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        jb2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTextField.setText(null);
                jPasswordField.setText(null);
                man.setSelected(true);//单选组中必须有有一个选中
                wonmen.setSelected(false);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



        panel01.add(admin);
        panel01.add(sex);
        panel01.add(pass);
        panel01.add(wonmen);
        panel01.add(man);
        panel01.add(jPasswordField);
        panel01.add(jTextField);
        panel01.add(jb);
        panel01.add(jb2);
        jf.add(panel01);
        jf.setBounds(100,100,444,600);
//        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

}
