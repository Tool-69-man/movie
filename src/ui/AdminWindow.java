package ui;


import Amod.ABC.DayforPopupMenu;
import Amod.ABC.JIconsmall;
import util.Constant;
import util.GlobalVars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//后台主界面
public class AdminWindow extends JFrame {
    //面板
    public Container contentPane;
    //movie show,order,user,accountMenu
    //标签栏,菜单，二级菜单
    private JMenuBar menuBar;

    private JMenu movieMenu;
    private JMenuItem addMovie;
    private JMenuItem updateMovie;
    private JMenuItem deleteMovie;
    private JMenuItem queryMovie;

    private JMenu showMenu;
    private JMenuItem addShow;
    private JMenuItem updateShow;
    private JMenuItem deleteShow;
    private JMenuItem queryShow;

    private JMenu orderMenu;
    private JMenuItem deleteOrder;
    private JMenuItem queryOrder;

    private JMenu userMenu;
    private JMenuItem addUser;
    private JMenuItem updateUser;
    private JMenuItem deleteUser;
    private JMenuItem queryUser;

    //用户账号更改密码，退出
    private JMenu accountMenu;
    private JMenuItem updatePass;
    private JMenuItem exitAccount;

    public AdminWindow(){

        initUI();
    }

    private void initUI(){

//        setExtendedState(JFrame.MAXIMIZED_BOTH);

        menuBar = new JMenuBar();

        movieMenu = new JMenu();
        addMovie =new JMenuItem();
        updateMovie =new JMenuItem();
        deleteMovie =new JMenuItem();
        queryMovie = new JMenuItem();




        showMenu = new JMenu();
        addShow =new JMenuItem();
        updateShow =new JMenuItem();
        deleteShow=new JMenuItem();
        queryShow = new JMenuItem();




        orderMenu = new JMenu();
         queryOrder=new JMenuItem();
        deleteOrder =new JMenuItem();




        userMenu = new JMenu();
        addUser =new JMenuItem();
        updateUser =new JMenuItem();
        deleteUser =new JMenuItem();
        queryUser = new JMenuItem();




        accountMenu = new JMenu();
        updatePass =new JMenuItem();
        exitAccount =new JMenuItem();

        queryMovie.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\005\\3.jpeg",20,20));
        deleteMovie.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\005\\2.png",20,20));
        updateMovie.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\005\\4.png",20,20));
        addMovie.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\005\\1.jpeg",20,20));


        queryShow.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\005\\3.jpeg",20,20));
        deleteShow.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\005\\2.png",20,20));
        updateShow.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\005\\4.png",20,20));
        addShow.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\005\\1.jpeg",20,20));


        queryOrder.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\005\\3.jpeg",20,20));
        deleteOrder.setIcon(JIconsmall.geturlIconSetWH("X:\\apache-maven-3.8.1\\MOVIES\\jpg\\005\\2.png",20,20));





        movieMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        showMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        orderMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));

        userMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        accountMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));





        setTitle("订票后台");
          contentPane = getContentPane();
          contentPane .setLayout(new BorderLayout());


        {

            {
                movieMenu.setText("电影管理");
                queryMovie.setText("查询");
                queryMovie.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        queryMovieActionPerformed(e);
                    }
                });

                movieMenu.add(queryMovie);

               addMovie.setText("添加");
                addMovie.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addMovieActionPerformed(e);
                    }
                });
                movieMenu.add(addMovie);

                deleteMovie.setText("删除");
                deleteMovie.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteMovieActionPerformed(e);
                    }
                });
                movieMenu.add(deleteMovie);

                updateMovie.setText("更新");
                updateMovie.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateMovieActionPerformed(e);
                    }
                });
                movieMenu.add(updateMovie);


                menuBar.add(movieMenu);
            } //电影



            {
                showMenu.setText("场次管理");

                queryShow.setText("查询");
                queryShow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        queryShowActionPerformed(e);
                    }
                });

                showMenu.add(queryShow);

                addShow.setText("添加");
                addShow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addShowActionPerformed(e);
                    }
                });
                showMenu.add(addShow);

                deleteShow.setText("删除");
                deleteShow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteShowActionPerformed(e);
                    }
                });
                showMenu.add(deleteShow);

                updateShow.setText("更新");
                updateShow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateShowActionPerformed(e);
                    }
                });
                showMenu.add(updateShow);


                menuBar.add(showMenu);
            } //场次



            {
                orderMenu.setText("订单管理");
                queryOrder.setText("查询");
                queryOrder.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        queryOrderActionPerformed(e);
                    }
                });

                orderMenu.add(queryOrder);


                deleteOrder.setText("删除");
                deleteOrder.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteOrderActionPerformed(e);
                    }
                });
                orderMenu.add(deleteOrder);


                menuBar.add(orderMenu);
            } //订单

            {
                userMenu.setText("用户管理");
                queryUser.setText("查询");
                queryUser.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        queryUserActionPerformed(e);
                    }
                });

                userMenu.add(queryUser);

                addUser.setText("添加");
                addUser.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addUserActionPerformed(e);
                    }
                });
                userMenu.add(addUser);

                deleteUser.setText("删除");
                deleteUser.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteUserActionPerformed(e);
                    }
                });
                userMenu.add(deleteUser);

                updateUser.setText("更新");
                updateUser.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateUserActionPerformed(e);
                    }
                });
                userMenu.add(updateUser);


                menuBar.add( userMenu);
            } //用户

            {
                accountMenu.setText("用户管理");
                updatePass.setText("密码更改");
                updatePass.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateAccountActionPerformed(e);
                    }
                });

                accountMenu.add(updatePass);

                exitAccount.setText("退出系统");
                exitAccount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        exitAccountActionPerformed(e);
                    }
                });
                accountMenu.add(exitAccount);

            }//账号
            menuBar.add( accountMenu);

        }//主菜单

        setJMenuBar(menuBar);
//        setJMenuBar();

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
// 如果是鼠标右键，则显示弹出菜单
                if (e.isMetaDown()) {
                    DayforPopupMenu.showPopupMenu(e.getComponent(), e.getX(), e.getY());
                }
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

        setSize(800,600);
        setLocationRelativeTo(getOwner());
        setResizable(false);

        //登录后显示列表

        if(GlobalVars.userRole==Constant.MOVIE_ADMIN_ROLE){
            new RecordQuery(this.contentPane,"电影",this);
        }else  if(GlobalVars.userRole==Constant.SHOW_ADMIN_ROLE){
            new RecordQuery(this.contentPane,"场次",this);
        }else if(GlobalVars.userRole==Constant.ORDER_ADMIN_ROLE){
            new RecordQuery(this.contentPane,"订单",this);
        }else if(GlobalVars.userRole==Constant.FULL_ADMIN_ROLE || GlobalVars.userRole==Constant.ROOT_ADMIN_ROLE){
            new RecordQuery(this.contentPane,"电影",this);
        }

        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });


//        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);



    }//UI


    //电影 增删改查
    private void queryMovieActionPerformed(ActionEvent e) {
        new RecordQuery(this.contentPane,"电影",this);
        setVisible(true);
    }

    private void addMovieActionPerformed(ActionEvent e) {
        new RecordAdd(this.contentPane,"电影",this);
        setVisible(true);
    }

    private void updateMovieActionPerformed(ActionEvent e) {
        new RecordUpdate(this.contentPane,"电影",this);
        setVisible(true);
    }

    private void deleteMovieActionPerformed(ActionEvent e) {
        new RecordDelete(this.contentPane,"电影",this);
        setVisible(true);
    }

    //场次 增删改查
    private void queryShowActionPerformed(ActionEvent e) {
        new RecordQuery(this.contentPane,"场次",this);
        setVisible(true);
    }

    private void addShowActionPerformed(ActionEvent e) {
        new RecordAdd(this.contentPane,"场次",this);
        setVisible(true);
    }

    private void updateShowActionPerformed(ActionEvent e) {
        new RecordUpdate(this.contentPane,"场次",this);
        setVisible(true);
    }

    private void deleteShowActionPerformed(ActionEvent e) {
        new RecordDelete(this.contentPane,"场次",this);
        setVisible(true);
    }

//订单  查询，删除
    private void queryOrderActionPerformed(ActionEvent e) {
        new RecordQuery(this.contentPane,"订单",this);
        setVisible(true);
    }

    private void deleteOrderActionPerformed(ActionEvent e) {
        new RecordDelete(this.contentPane,"订单",this);
        setVisible(true);
    }

//管理员
    private void queryUserActionPerformed(ActionEvent e) {
        new RecordQuery(this.contentPane,"用户",this);
        setVisible(true);
    }

    private void addUserActionPerformed(ActionEvent e) {
        new RecordAdd(this.contentPane,"用户",this);
        setVisible(true);
    }

    private void updateUserActionPerformed(ActionEvent e) {
        new RecordUpdate(this.contentPane,"用户",this);
        setVisible(true);
    }

    private void deleteUserActionPerformed(ActionEvent e) {
        new RecordDelete(this.contentPane,"用户",this);
        setVisible(true);
    }

//更新密码，退出系统
    private void updateAccountActionPerformed(ActionEvent e) {
        new UpdatePassword(this.contentPane);
        setVisible(true);
    }

    private void exitAccountActionPerformed(ActionEvent e) {
        dispose();
    }



    //权限
    public void setViewVisable(int role){
        if (role==Constant.VISITOR_ROLE){
            menuBar.setEnabled(false);
        }
        if (role!=Constant.MOVIE_ADMIN_ROLE&&role<Constant.FULL_ADMIN_ROLE){
            movieMenu.setEnabled(false);
        }
        if (role!=Constant.SHOW_ADMIN_ROLE&&role<Constant.FULL_ADMIN_ROLE){
            showMenu.setEnabled(false);
        }
        if (role==Constant.ORDER_ADMIN_ROLE&&role<Constant.FULL_ADMIN_ROLE){
          orderMenu.setEnabled(false);
        }

        if (role < Constant.ROOT_ADMIN_ROLE){
            userMenu.setEnabled(false);
        }





    }



}
