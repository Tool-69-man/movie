/*
 * Created by JFormDesigner on Sat Jul 10 11:27:26 CST 2021
 */

package Amod.ABC;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Brainrain
 */
public class Beauti extends JFrame {
    public static void main(String[] args) {
        new Beauti();
    }

    public Beauti() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

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
                String name = jTextField.getText();
                String password = new String (jPasswordField.getPassword());
                if (!name.equals("")&&!password.equals("")){
                    JOptionPane.showMessageDialog(jf,"success","注册提示框",JOptionPane.PLAIN_MESSAGE);
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
