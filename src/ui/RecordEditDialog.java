package ui;

import database.Moviedao;
import database.OrderDao;
import database.ShowDao;
import database.StaffDao;
import sun.misc.JavaAWTAccess;
import take.Movie;
import take.Order;
import take.Show;
import take.Staff;
import util.CheckHandler;
import util.Constant;
import util.DateHandler;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class RecordEditDialog extends JDialog {
    private String recordType;
    private JPanel dialogPane;
    private JPanel combinedPane;
    private JPanel recordPane;
    private JPanel buttonBar;
    private JComboBox<String> roleBox;
    private JComboBox<String> hourBox;
    private JComboBox<String> minBox;
    private JComboBox<String> movieBox;
    private JDatePickerImpl datePicker;
    private JTable srcTable;
    private   int srcRowId;
    private JButton btnSave;
    private JButton btnClose;
    private JButton btnDelete;

    private List<JTextField> textFields;
    private List<Integer> moviesIds;

    public RecordEditDialog(String type, int itemId, JTable datatable, int rowID){
        recordType =type;
        textFields = new ArrayList<JTextField>();
        moviesIds = new ArrayList<Integer>();
        srcRowId = rowID;
        srcTable = datatable;
        initUI();
        setInitalData(itemId);//初始化表格数据
    }

    //初始化界面
    private void initUI(){
        dialogPane = new JPanel();
        dialogPane.setLayout(new BorderLayout());
        recordPane = new JPanel();
        buttonBar =new JPanel();
        btnClose = new JButton();
        btnSave = new JButton();
        btnDelete = new JButton();
        combinedPane = new JPanel();

        setTitle(recordType.equals("订单")? "删除" : "编辑/删除"+recordType);
        setResizable(false);
        Container contentPane = getContentPane();

        String[] currLabels = new String[0];

        //不同对象，布局不同
        if ("电影".equals(recordType)){
            currLabels = Constant.movieLables;
            recordPane.setLayout(new GridLayout(7,2,6,6));
            dialogPane.setBorder(new EmptyBorder(5,5,5,5));
        }
         if ("场次".equals(recordType)){
            currLabels = Constant.showLables;
            recordPane.setLayout(new GridLayout(6,2,6,6));
            dialogPane.setBorder(new EmptyBorder(5,5,5,5));
        }
         if ("订单".equals(recordType)){
            currLabels = Constant.orderLables;
            recordPane.setLayout(new GridLayout(4,2,6,6));
            dialogPane.setBorder(new EmptyBorder(5,5,5,5));
        }
         if ("用户".equals(recordType)){
            currLabels = Constant.staffLables;
            recordPane.setLayout(new GridLayout(4,2,6,6));
            dialogPane.setBorder(new EmptyBorder(5,5,5,5));
        }

        for(int i =0;i<currLabels.length;i++) {
            JLabel entryLabel = new JLabel();
            entryLabel.setText(currLabels[i] + " : ");
            entryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            JTextField entryField = new JTextField();
            if (recordType.equals("订单") || i == 0) {     //订单不可选中，id不能选
                entryField.setEnabled(false);
                entryField.setBackground(new Color(230, 230, 230));
            }

            recordPane.add(entryLabel);

            //数据框展示项目

            if ("场次".equals(recordType) && "电影名称".equals(currLabels[i])) {
                    List<Movie> movies = Moviedao.getMovies("", "");
                    String[] movieNames = new String[movies.size()];
                    for (int m = 0; m < movies.size(); m++) {
                        movieNames[m] = movies.get(m).getName();
                        moviesIds.add(movies.get(m).getMid());
                    }//for
                    movieBox = new JComboBox<String>(movieNames);
                    recordPane.add(movieBox);
                } else if ("电影".equals(recordType) && "上映时间".equals(currLabels[i])) {
                    combinedPane = new JPanel();
                    datePicker = DateHandler.getDatePicker();
                    datePicker.setPreferredSize(new Dimension(160, 30));
                    combinedPane.add(datePicker);
                    recordPane.add(combinedPane);
                } else if ("场次".equals(recordType) && "放映时间".equals(currLabels[i])) {
                    datePicker = DateHandler.getDatePicker();
                    datePicker.setPreferredSize(new Dimension(140, 20));
                    datePicker.setBorder(new EmptyBorder(10, 0, 0, 20));
                    recordPane.add(datePicker);
                    combinedPane = new JPanel();
//                combinedPane.add(datePicker);
                    hourBox = new JComboBox<String>(Constant.timeHours);
                    JLabel sepLabel1 = new JLabel("时");
                    JLabel sepLabel2 = new JLabel("分");
                    minBox = new JComboBox<>(Constant.timeMinutes);

                    combinedPane.add(hourBox);
                    combinedPane.add(sepLabel1);
                    combinedPane.add(minBox);
                    combinedPane.add(sepLabel2);
                    JLabel timeLabel = new JLabel("");
                    recordPane.add(timeLabel);
                    timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                    recordPane.add(combinedPane);
                } else if ("用户".equals(recordType) && "权限".equals(currLabels[i])) {
                    roleBox = new JComboBox<String>(Constant.userRoleDescs);
                    recordPane.add(roleBox);
            } else if ("订单".equals(recordType) && "订单数据".equals(currLabels[i])) {
                textFields.add(entryField);
            } else {
                recordPane.add(entryField);
                textFields.add(entryField);
            }
        }//for循环
            if (recordType.equals("订单")){
                JButton viewButton = new JButton("点击查看");
                viewButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        String orderData = textFields.get(3).getText();
                        if (orderData.length()>0){
                            new OrderShowDialog(orderData);
                        }//if
                    }
                });
                recordPane.add(viewButton);
            }//订单

            dialogPane.add(recordPane,BorderLayout.CENTER);


            buttonBar.setBorder(new EmptyBorder(15,5,5,5));
            buttonBar.setLayout(new GridBagLayout());
            ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[]{1.0,0.0,0.0};
            ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[]{0,80,75};


            if (!recordType.equals("订单")){
                btnSave.setText("保存修改");
                btnSave.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnSaveActionPerformed(e);
                    }
                });

                buttonBar.add(btnSave,new GridBagConstraints(1,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,5),0,0));


            }

            btnDelete.setText("删除"+recordType);
            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnDeleteActionPerformed(e);
                }
            });






            btnDelete.setFont(new Font("楷体", Font.PLAIN, 18));
            buttonBar.add(btnDelete,new GridBagConstraints(2,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,5),0,0));


            btnClose.setText("关闭");
            btnClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnCloseteActionPerformed(e);
                }
            });




              btnClose.setFont(new Font("楷体", Font.PLAIN, 18));
            buttonBar.add( btnClose,new GridBagConstraints(3,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,5),0,0));


            dialogPane.add(buttonBar,BorderLayout.SOUTH);
            contentPane.add(dialogPane,BorderLayout.CENTER);
            setSize(500,400);
            setLocationRelativeTo(getOwner());
            setVisible(true);
        }//UI


    //处理不同类型的数据到相应的数据库表格
        private void btnSaveActionPerformed(ActionEvent e){
            if (textFields.get(0).getText().length()==0){
                return;
            }//数据为0返回
            int itemId= Integer.parseInt(textFields.get(0).getText());
            boolean success  = false;

            if ("电影".equals(recordType)){
                Movie movie = new Movie();
                movie.setMid(itemId);
                movie.setName(textFields.get(1).getText());
                movie.setType(textFields.get(2).getText());
                movie.setDirector(textFields.get(3).getText());
                movie.setSource(textFields.get(4).getText());
                movie.setPublisher(textFields.get(5).getText());
                String totalContent = textFields.get(1).getText()+textFields.get(2).getText()
                        +textFields.get(3).getText()+textFields.get(4).getText();
                if (CheckHandler.containsDigit(totalContent)){
                    JOptionPane.showMessageDialog(this,"你的输入包含数字，输入非法");
                    return;
                }//判断输入非法
                movie.setReleaseDate(datePicker.getJFormattedTextField().getText());
                success=Moviedao.updateMovie(movie);

            }//电影

            if ("场次".equals(recordType)){
                Show show = new Show();
                show.setId(itemId);
                show.setMid(moviesIds.get(movieBox.getSelectedIndex()));
                if (!CheckHandler.isInteger(textFields.get(1).getText())){
                    JOptionPane.showMessageDialog(this,"输入放映厅号码必须为整数");
                    return;
                }else {
                    show.setHall(Integer.parseInt(textFields.get(1).getText()));
                }
               String time = datePicker.getJFormattedTextField().getText();
                String hour = hourBox.getSelectedItem().toString();
                String minute= minBox.getSelectedItem().toString();
                time+=" "+hour+":"+minute;
                show.setTime(time);
                if (!CheckHandler.isNumeric(textFields.get(2).getText())){
                    JOptionPane.showMessageDialog(this,"输入价格必须为整数");
                    return;
                }else{
                    show.setPrice(Double.parseDouble(textFields.get(2).getText()));
                }
                System.out.println(show.getHall()+" "+show.getPrice());
                success = ShowDao.updateShow(show);


            }//场次

            if ("用户".equals(recordType)){
                Staff user = new Staff();
                user.setUid(itemId);
                user.setUsername(textFields.get(1).getText());
                user.setPassword(textFields.get(2).getText());
                user.setRole(Constant.userRoleIds[roleBox.getSelectedIndex()]);
                success= StaffDao.updateUser(user);
            }//用户

            if (success){
                updateSrcTable();
                JOptionPane.showMessageDialog(this.dialogPane,"修改保存成功");
                dispose();
            }
        }//保存按钮函数

        private  void btnDeleteActionPerformed(ActionEvent e){
            //如果为空返回
            if (textFields.get(0).getText().length()==0){
                return;
            }
            boolean success = false;

            int itemId = Integer.parseInt(textFields.get(0).getText());

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
                ((DefaultTableModel)srcTable.getModel()).removeRow(srcRowId);
                //同步删除数据行
                JOptionPane.showMessageDialog(this.dialogPane,recordType+"删除成功");
                dispose();
            }

        }//删除按钮



        private void btnCloseteActionPerformed(ActionEvent e){
            dispose();
        }

        private void setInitalData(int itemId) {
            boolean queryFail = false; // 是否查询失败，true  失败
            if ("电影".equals(recordType)) {
                Movie movie = Moviedao.getMovie(itemId);
                if (movie != null) {
                    textFields.get(0).setText(movie.getMid() + "");
                    textFields.get(1).setText(movie.getName());
                    textFields.get(2).setText(movie.getType() + "");
                    textFields.get(3).setText(movie.getDirector() + "");
                    textFields.get(4).setText(movie.getSource() + "");
                    textFields.get(5).setText(movie.getPublisher() + "");
                    datePicker.getJFormattedTextField().setText(movie.getReleaseDate());
                } else {queryFail = true;}
            }//显示电影


            if ("场次".equals(recordType)) {
                Show show = ShowDao.getShow(itemId);
                if (show != null) {
                    textFields.get(0).setText(show.getId() + "");
                    textFields.get(1).setText(show.getHall() + "");
                    textFields.get(2).setText(show.getPrice() + "");
                    String[] timeMeta = show.getTime().trim().split(" ");
                    movieBox.setSelectedItem(Moviedao.getMovie(show.getMid()).getName());
                    datePicker.getJFormattedTextField().setText(timeMeta[0]);
                    int indextime=1;
                    if (timeMeta[indextime].length()==0){
                        indextime+=2;
                    }
                    String[] timeMeta2 = timeMeta[indextime].trim().split(":");
                    hourBox.setSelectedItem(timeMeta2[0]);
                    minBox.setSelectedItem(timeMeta2[1]);
                } else {
                    queryFail = true;
                }
            }//场次
                if ("订单".equals(recordType)) {
                    Order order = OrderDao.getOrder(itemId);
                    if (order != null) {
                        textFields.get(0).setText(order.getId() + "");
                        textFields.get(1).setText(order.getName());
                        textFields.get(2).setText(order.getPhone());
                        textFields.get(3).setText(order.getData());


                    } else {
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
                            roleBox.setSelectedIndex(index);
                        }
                    } else {
                        queryFail = true;
                    }//判断


                }//用户
                textFields.get(0).setEnabled(false);
                if (queryFail) {
                    JOptionPane.showMessageDialog(this.dialogPane, "未检索数据,请调整编号！");
                    return;
                }//失败就警告
            }


            private void updateSrcTable(){
                if (!recordType.equals("场次")){
                    int i = 1;
                    //更新表格中数据项
                    while (i<textFields.size()){
                        srcTable.setValueAt(textFields.get(i).getText(),srcRowId,i);
                        i++;
                    }


                    if (recordType.equals("用户")){
                        //单独更新用户权限，表格中数据项
                        srcTable.setValueAt(roleBox.getSelectedIndex(),srcRowId,3);
                    }//用户

                    if (recordType.equals("电影")){
                        srcTable.setValueAt(datePicker.getJFormattedTextField().getText(),srcRowId,6);

                    }//如果单独电影数据

                }else {//不为场次
                    srcTable.setValueAt(movieBox.getSelectedItem(),srcRowId,1);
                    srcTable.setValueAt(textFields.get(1).getText(),srcRowId,2);
                    String time = datePicker.getJFormattedTextField().getText();
                    String hour = hourBox.getSelectedItem().toString();
                    String minute=minBox.getSelectedItem().toString();
                    time += " "+hour  +" : "+minute;

                    srcTable.setValueAt(time,srcRowId,3);
                    srcTable.setValueAt(textFields.get(2).getText(),srcRowId,4);


                }

            }//更新查询表格




        }