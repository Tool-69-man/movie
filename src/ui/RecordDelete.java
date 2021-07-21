package ui;

import database.Moviedao;
import database.OrderDao;
import database.ShowDao;
import database.StaffDao;
import take.Movie;
import take.Order;
import take.Show;
import take.Staff;
import util.CheckHandler;
import util.Constant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class RecordDelete {
   private JPanel recordPane;
   private String recordType;

   private JPanel contentPane;
   private JPanel queryPane;
   private JLabel idLabel;
   private JTextField idField;
   private JButton btnQuery;
   private JPanel buttonBar;
   private JButton btnDel;

    private JFrame mainFrame;

    private List<JTextField> textFields;

    public RecordDelete(Container mainContent, String type, JFrame jFrame){
            recordType =type;
            textFields = new ArrayList<JTextField>();
            mainFrame = jFrame;
            initUI(mainContent);
    }

    public void initUI(Container mainContent) {
        mainContent.removeAll();
        contentPane = new JPanel(new BorderLayout());
        queryPane = new JPanel();
        recordPane = new JPanel();
        idLabel = new JLabel();
        idField = new JTextField();
        btnQuery = new JButton();
        btnDel = new JButton();
        queryPane.setLayout(new GridLayout(1, 3));
        idLabel.setText("输入" + recordType + "编号");
        idLabel.setFont(new Font("楷体", Font.PLAIN, 16));
        idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        queryPane.add(idLabel);
        queryPane.add(idField);

        btnQuery.setText("查询");
        btnQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnQueryActionPerformed(e);
            }
        });
//        queryPane.add(idLabel);
//        queryPane.add(idField);
//

        queryPane.add(btnQuery);
        contentPane.add(queryPane,BorderLayout.NORTH);

        String[] currLabels = new String[0];

        //添加查询结果展示区
        if ("电影".equals(recordType)) {
            currLabels = Constant.movieLables;
            recordPane.setLayout(new GridLayout(7, 2, 6, 6));
            contentPane.setBorder(new EmptyBorder(50, 150, 100, 300));
        }
        if ("场次".equals(recordType)) {
            currLabels = Constant.showLables;
            recordPane.setLayout(new GridLayout(5, 2, 6, 6));
            contentPane.setBorder(new EmptyBorder(100, 150, 150, 250));
        }

        if("订单".equals(recordType)){
            currLabels = Constant.orderLables;
            recordPane.setLayout(new GridLayout(4, 2, 6, 6));
            contentPane.setBorder(new EmptyBorder(100, 150, 200, 300));
        }

        if ("用户".equals(recordType)) {
            currLabels = Constant.staffLables;
            recordPane.setLayout(new GridLayout(4, 2, 6, 6));
            contentPane.setBorder(new EmptyBorder(100, 150, 200, 300));
        }



        for (int i = 0; i < currLabels.length; i++) {
            JLabel entryLabel = new JLabel();
            entryLabel.setText(currLabels[i] + ":");
            entryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            JTextField entryField = new JTextField();
            entryField.setEnabled(false);
            entryField.setBackground(new Color(230, 230, 230));

            recordPane.add(entryLabel);
            if (!(recordType.equals("订单") && currLabels[i].equals("订单数据"))) {
                recordPane.add(entryField);
            }

            textFields.add(entryField);

        } //for

        if ("订单".equals(recordType)){
            JButton viewButton = new JButton("点击查看");
            viewButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String orderData = textFields.get(3).getText();
                    if (orderData.length()>0){
                        new OrderShowDialog(orderData);
                    }//如果
                }
            });

            recordPane.add(viewButton);

        }//如果是订单
        contentPane.add(recordPane,BorderLayout.CENTER);

        //添加底部按钮行
        buttonBar = new JPanel();
        buttonBar.setBorder(new EmptyBorder(15,5,5,5));
        buttonBar.setLayout(new GridBagLayout());
        ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[]{1.0,0.0,0.0};
        ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[]{0,80,75};



//        btnDel.setText("删除"+recordType.toString());改动
        btnDel.setText("删除"+recordType);
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDeleteActionPerformed(e);
            }


        });



        btnQuery.setFont(new Font("楷体", Font.PLAIN, 16));


        btnDel.setFont(new Font("楷体", Font.PLAIN, 19));



        buttonBar.add(btnDel,new GridBagConstraints(1,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,5),0,0));
        contentPane.add(buttonBar,BorderLayout.SOUTH);
        contentPane.setVisible(true);
        mainContent.add(contentPane,BorderLayout.CENTER);


    }//UI

    private  void btnDeleteActionPerformed(ActionEvent e){
        //如果为空返回
        if (textFields.get(0).getText().length()==0){
            return;
        }
        boolean success = false;

        int itemId =(int) Integer.parseInt(textFields.get(0).getText());

        if ("电影".equals(recordType)){
            success = Moviedao.deleteMovie(itemId);
        }
        if ("场次".equals(recordType)){
            success = ShowDao.deleteShow(itemId);
        }
        if ("订单".equals(recordType)){
            String orderData = textFields.get(3).getText();
            List<String> usedSeats = CheckHandler.getSeats(orderData);
            ShowDao.removeUsedSeats(usedSeats);
            //将订单所涉及的座位重新释放到放映场次
            success = OrderDao.delectOredr(itemId);
        }
        if ("用户".equals(recordType)){
            success = StaffDao.deleteUser(itemId);
        }

        if (success){

            //同步删除数据行
            JOptionPane.showMessageDialog(null,"删除成功");

            new RecordQuery(contentPane,recordType,mainFrame);
            contentPane.setBorder(new EmptyBorder(0,50,100,50));
            mainFrame.setVisible(true);

        }

    }//删除按钮


    private void btnQueryActionPerformed(ActionEvent e){
        int itemId = -1;
        boolean  queryFail = false;
        try {
            String idVal = idField.getText();
            if (idVal.length()==0){
                JOptionPane.showMessageDialog(null,"请输入编号查询");
                return;
            }//判断
            itemId = Integer.parseInt(idVal);

        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"输入不正确，请输入整数");
            return;
        }

//        itemId = Integer.parseInt(idField.getText());
        if ("电影".equals(recordType)) {
            Movie movie = Moviedao.getMovie(itemId);
            if (movie != null) {
                textFields.get(0).setText(movie.getMid() + "");
                textFields.get(1).setText(movie.getName());
                textFields.get(2).setText(movie.getType() );
                textFields.get(3).setText(movie.getDirector());
                textFields.get(4).setText(movie.getSource() + "");
                textFields.get(5).setText(movie.getPublisher() + "");
                textFields.get(6).setText(movie.getReleaseDate()+"");
            } else {
                System.out.println("删除电影，对象为空报错");
                queryFail = true;
            }//if else
        }//显示电影



        if ("场次".equals(recordType)) {
            Show show = ShowDao.getShow(itemId);
            if (show != null) {
                textFields.get(0).setText(show.getId() + "");
                textFields.get(1).setText(Moviedao.getMovie(show.getMid()).getName() + "");
                textFields.get(2).setText(show.getPrice() + "");
                textFields.get(3).setText(show.getTime() + "");
                textFields.get(4).setText(show.getPrice() + "");
                textFields.get(4).setHorizontalAlignment(SwingConstants.LEFT);

            } else {
                System.out.println("删除场次，对象为空报错");
                queryFail = true;
            }
        }
        if ("订单".equals(recordType)) {
            Order order = OrderDao.getOrder(itemId);
            if (order != null) {
                textFields.get(0).setText(order.getId() + "");
                textFields.get(1).setText(order.getName());
                textFields.get(2).setText(order.getPhone());
                textFields.get(3).setText(order.getData());


            } else {
                System.out.println("删除订单，对象为空报错");
                queryFail = true;
            }//判断


        }//订单

        if ("用户".equals(recordType)) {
            Staff user = StaffDao.getStaff(itemId);
            if (user != null) {
                textFields.get(0).setText(user.getUid() + "");
                textFields.get(1).setText(user.getUsername());
                textFields.get(2).setText(user.getPassword());
                int index = CheckHandler.getSelectIndexById(user.getRole());
                if (index >= 0) {
                   textFields.get(3).setText(Constant.userRoleDescs[index]);
                }
            } else {
                System.out.println("删除用户，对象为空报错");
                queryFail = true;
            }//判断


        }//用户
        textFields.get(0).setEnabled(false);
        if (queryFail) {
            JOptionPane.showMessageDialog(this.contentPane, "未检索数据,请调整编号！");
            return;
        }//失败就警告


    }//查询btn


}
