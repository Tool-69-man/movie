package ui;


import Amod.ABC.JFUI;
import Amod.ABC.JFUI3;
import Amod.ABC.JIconsmall;
import database.StaffDao;
import javafx.beans.value.WeakChangeListener;
import take.Staff;
import ui.UIUP.Back;
import ui.UIUP.Demoforjianting;
import util.Constant;
import util.GlobalVars;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame {
    private JLabel userLable;
    private JTextField userField;
    private JLabel passLabel;
    private JPasswordField passField;
    private JButton orederButton;
    private JButton submitButton;


    public Login(){

        initUI();
    }

    private  void  initUI(){
        new JFUI3();
        //标题
       setUndecorated(true);
        setVisible(true);
        //获取窗体对象 getContentPane();
        Container welcomePane = getContentPane();

        welcomePane.setLayout(null);//new GridLayout(3,1)三行一列

        JLabel reback = new JLabel();
        reback.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\002\\cat.png",351,400));


        reback.setBounds(-67,200,350  ,400);


        reback.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                setUndecorated(true);
                new Demoforjianting();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



        welcomePane.add(reback);





        //添加用户名标签
        userLable = new JLabel();
        //沿x轴 右对齐
        userLable.setHorizontalAlignment(SwingConstants.RIGHT);
        userLable.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\002\\user.PNG",400,100));
        userLable.setBounds(340,310,400,100);

        welcomePane.add(userLable);
        //用户名输入框
        userField = new JTextField();
        userField.setBounds(630,330,240,40);
        welcomePane.add(userField);
        //密码标签和输入框
        passLabel = new JLabel();
        passLabel.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\002\\pass.PNG",360,80));

//        passLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passLabel.setBounds(360,370,400,100);
        welcomePane.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(630,400,240,40);
        welcomePane.add(passField);



        submitButton =new JButton("管理员登录");
        submitButton.setFont(new Font("华文行楷", Font.PLAIN, 22));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButtonActionPerformed(e);
            }
        });
        submitButton.setBounds(630,480,245,50);
        welcomePane.add(submitButton);


        //背景
        JLabel background = new JLabel();
        background.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\002\\line.png",900,600));

        background.setBounds(0,0,900,600);
        welcomePane.add(background);

//         welcomePane.setBounds(500,200,350,200);
        //管理员添加


        //返回窗体的所有者， 及设置该窗体相对他自己的位置
        setSize(900,600);
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

       Login login =  new Login();
       login.setVisible(true);
    }





}
