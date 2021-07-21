package ui;


import database.StaffDao;
import take.Staff;
import util.GlobalVars;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Welcome extends JFrame {
    private JLabel userLable;
    private JTextField userField;
    private JLabel passLabel;
    private JPasswordField passField;
    private JButton orederButton;
    private JButton submitButton;


    public Welcome(){
//        new JFUI3();
        initUI();
    }

    private  void  initUI(){
        //标题
        setTitle("电影购票系统");
//        setSize(1800,1600);
        setVisible(true);
        //获取窗体对象 getContentPane();
        Container welcomePane= getContentPane();



        welcomePane.setLayout(new GridLayout(3,1));//new GridLayout(3,1)三行一列
        setVisible(true);
//        顶部面板
        JPanel topPane = new JPanel();
        topPane.setBorder(new EmptyBorder(60,0,0,0));//new EmptyBorder(60,0,0,0)
//        topPane.setBounds(100,100,800,60);
//        topPane.setBackground(Color.GRAY);

        JLabel welcomeLable = new JLabel("欢迎光临影院在线订票系统");
        //显示字体
        welcomeLable.setFont(new Font("Serif",Font.PLAIN,20));
        topPane.add(welcomeLable);

        //中间和底部的面板
        JPanel midPane  = new JPanel();
        JPanel btmPane  = new JPanel();
        midPane.setLayout(new GridLayout(1,2));
        midPane.setBorder(new EmptyBorder(0,100,0,100));
//
//        //订票面板
        JPanel custPane = new JPanel();
        custPane.setLayout(new GridLayout(2,1));
        custPane.setBorder(new EmptyBorder(40,0,40,50));
        JLabel helloLabel = new JLabel("你好，顾客");
        custPane.add(helloLabel);

        orederButton = new JButton("开始订票");
        orederButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //进入订票
                orderButtonActionPerformed(e);
            }
        });//order触发器
        custPane.add(orederButton);


        midPane.add(custPane);//中间面板加入订票面板

        //管理员面板
        JPanel adminpane = new JPanel();
        adminpane.setBorder(new EmptyBorder(40,0,40,0));
        adminpane.setLayout(new GridLayout(3,2));
        //添加用户名标签
        userLable = new JLabel("用户名:");
        //沿x轴 右对齐
        userLable.setHorizontalAlignment(SwingConstants.RIGHT);
        adminpane.add(userLable);
        //用户名输入框
        userField = new JTextField();
        adminpane.add(userField);
        //密码标签和输入框
        passLabel = new JLabel("密   码:");
        passLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        adminpane.add(passLabel);

        passField = new JPasswordField();
        adminpane.add(passField);

        adminpane.add(new JLabel());

        submitButton =new JButton("管理员登录");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButtonActionPerformed(e);
            }
        });
        adminpane.add(submitButton);



        //管理员添加
        midPane.add(adminpane);
//        midPane.setBackground(Color.pink);
//
//        btmPane.setBackground(Color.yellow);


        welcomePane.add(topPane);
        welcomePane.add(midPane);
        welcomePane.add(btmPane);
        //返回窗体的所有者， 及设置该窗体相对他自己的位置
        setSize(800,600);
        setLocationRelativeTo(getOwner());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();//关闭窗体时，不显示当前窗体
            }
        });

//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }



    private void submitButtonActionPerformed(ActionEvent e) {

        String username = userField.getText();//从输入框得用户名和密码
        String password = String.valueOf(passField.getPassword());
        if(username.equals("")){
            JOptionPane.showMessageDialog(this,"用户名不能为空");
            return;
        }
        try{
            Staff user = StaffDao.getUserByCredential(username,password);

            if (user == null){
                JOptionPane.showMessageDialog(this,"用户名或密码不正确");
                return;
            }
            //将登录的管理员id,name,role存入GlobalVars全局变量
            GlobalVars.userId = user.getUid();
            GlobalVars.userName = user.getUsername();
            GlobalVars.userRole  = user.getRole();

            //管理员后台
            AdminWindow main = new  AdminWindow();
            main.setViewVisable(GlobalVars.userRole);
            this.dispose();

        }catch (Exception ex){
            ex.printStackTrace();
        }//报错

    }

    private void orderButtonActionPerformed(ActionEvent e){
        System.out.println("提交表单");
        try{
            OrderWindow orderWindow = new OrderWindow();
            orderWindow.setVisible(true);
            this.dispose();//当前窗口不可见
        }catch (Exception ex){
            ex.printStackTrace();
        }//报错

    }//提交

    public static void main(String[] args) {

        Welcome welcome =new Welcome();
        welcome.setVisible(true);
    }





}
