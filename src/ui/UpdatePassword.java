package ui;


import database.StaffDao;
import javafx.scene.control.PasswordField;
import util.GlobalVars;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UpdatePassword {
    private JPanel contentPane;
    private JPanel updatePane;
    private JLabel pwdLabel1;
    private JPanel buttonBar;
    private JLabel pwdLabel2;
    private JPasswordField pwdField1;
    private JPasswordField pwdField2;
    private JButton submitBtn;





    public UpdatePassword(Container mainContent){
        initUI(mainContent);
    }

    //初始化
    private void initUI(Container mainContent){
        mainContent.removeAll();
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(150,200,300,300));
        contentPane.setLayout(new BorderLayout());

        updatePane = new JPanel();
        pwdField1 = new JPasswordField();
        pwdField2 = new JPasswordField();
        pwdLabel1 = new JLabel();
        pwdLabel2 = new JLabel();
        pwdLabel2.setFont(new Font("楷体", Font.PLAIN, 16));
        buttonBar = new JPanel();
        submitBtn = new JButton();

        updatePane.setLayout(new GridLayout(2,2));

        pwdLabel1.setText("请输入新密码");
        pwdField1.setHorizontalAlignment(SwingConstants.RIGHT);
        updatePane.add(pwdLabel1);
        updatePane.add(pwdField1);

        pwdLabel2.setText("请再次输入新密码");
        pwdField2.setHorizontalAlignment(SwingConstants.RIGHT);
        updatePane.add(pwdLabel2);
        updatePane.add(pwdField2);

        contentPane.add(updatePane,BorderLayout.CENTER);

        buttonBar.setBorder(new EmptyBorder(12,0,0,0));
        buttonBar.setLayout(new GridBagLayout());
        ((GridBagLayout)buttonBar.getLayout()).columnWeights =new double[]{1.0,0.0,0.0};
        ((GridBagLayout)buttonBar.getLayout()).columnWidths =new int[]{0,85,80};

        submitBtn.setText("提交修改");
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButtonActionPerformed(e);
            }
        });


        submitBtn.setFont(new Font("楷体", Font.PLAIN, 18));
        pwdLabel1.setFont(new Font("楷体", Font.PLAIN, 16));

        buttonBar.add(submitBtn,new GridBagConstraints(1,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,5),0,0));

        contentPane.add(buttonBar,BorderLayout.SOUTH);
        contentPane.setVisible(true);
        mainContent.add(contentPane,BorderLayout.CENTER);


    }//UI

    private void submitButtonActionPerformed(ActionEvent e) {
        String pwdVal1 = String.valueOf(pwdField1.getPassword());
        String pwdVal2 = String.valueOf(pwdField2.getPassword());

        if (!pwdVal1.equals(pwdVal2)){
            JOptionPane.showMessageDialog(this.contentPane,"输入密码不一致");
            pwdField1.setText("");
            pwdField2.setText("");
            return;
        }

        if (pwdVal1.length()<6){
            JOptionPane.showMessageDialog(this.contentPane,"输入密码太短，最小长度为6");
            return;
        }
        boolean success = StaffDao.updateUserPass(GlobalVars.userId,pwdVal1);
        if (success){
            JOptionPane.showMessageDialog(this.contentPane,"密码修改成功");
        }//

    }//提交按钮

}//类
