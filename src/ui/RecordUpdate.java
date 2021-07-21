package ui;


import database.Moviedao;
import database.ShowDao;
import database.StaffDao;
import take.Movie;
import take.Show;
import take.Staff;
import util.CheckHandler;
import util.Constant;
import util.DateHandler;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RecordUpdate {
    private String recordType;
    private JLabel idLabel;
    private JTextField idField;
    private JPanel contentPane;
    private JPanel queryPane;
    private JComboBox<String> roleBox;
    private JComboBox<String> hourBox;
    private JComboBox<String> minBox;
    private JComboBox<String> movieBox;
    private JDatePickerImpl datePicker;
    private JPanel combinedPane;
    private JPanel recordPane;
    private JPanel buttonBar;
    private JButton btnSave;

    private List<JTextField> textFields;
    private List<Integer> moviesIds;
    public JFrame mainFrame;


    public RecordUpdate(Container mainContent, String type, JFrame jFrame){
        textFields = new ArrayList<JTextField>();
        recordType =type;
        moviesIds =new ArrayList<Integer>();
        mainFrame = jFrame;
        initUI(mainContent);
    }

    public void initUI(Container mainContent){
        mainContent.removeAll();
        contentPane = new JPanel(new BorderLayout());
recordPane = new JPanel();
        queryPane = new JPanel();
        idLabel = new JLabel();

        idField =new JTextField();
        buttonBar =new JPanel();
        btnSave = new JButton();
        queryPane.setLayout(new GridLayout(1,3));

        idLabel = new JLabel(recordType+"编号:");
        idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        idField = new JTextField();
        JButton queryBtn = new JButton("查询");
        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnQueryActionPerformed(e);
            }
        });


        queryPane.add(idLabel);
        queryPane.add(idField);
        queryPane.add(queryBtn);
        String[] currLabels = new String[0];

        //添加查询结果展示区
        if ("电影".equals(recordType)){
            currLabels = Constant.movieLables;
            recordPane.setLayout(new GridLayout(7,2,6,6));
            contentPane.setBorder(new EmptyBorder(50,150,100,300));
        }
        if ("场次".equals(recordType)){
            currLabels = Constant.showLables;
            recordPane.setLayout(new GridLayout(6,2,6,6));
            contentPane.setBorder(new EmptyBorder(100,150,150,250));
        }

        if ("用户".equals(recordType)){
            currLabels = Constant.staffLables;
            recordPane.setLayout(new GridLayout(4,2,6,6));
            contentPane.setBorder(new EmptyBorder(100,150,200,300));
        }

        for (int i = 0; i<currLabels.length;i++){
            JLabel entryLabel = new JLabel();
            entryLabel.setText(currLabels[i]+":");
            entryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            JTextField entryField = new JTextField();


            if (i==0){
                entryField.setEnabled(false);
                entryField.setBackground(new Color(230,230,230));
            }//i==0

            recordPane.add(entryLabel);


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
                datePicker.setPreferredSize(new Dimension(160, 30));
//                datePicker.setBorder(new EmptyBorder(10, 0, 0, 20));
                recordPane.add(datePicker);
                combinedPane = new JPanel();//重新赋值面板
//                combinedPane.add(datePicker);
                hourBox = new JComboBox<>(Constant.timeHours);
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
                roleBox = new JComboBox<>(Constant.userRoleDescs);
                recordPane.add(roleBox);
            } else  {
                recordPane.add(entryField);
                textFields.add(entryField);
            }


        }//循环

        contentPane.add(queryPane,BorderLayout.NORTH);
        contentPane.add(recordPane  ,BorderLayout.CENTER);

        buttonBar.setBorder(new EmptyBorder(15,5,5,5));
        buttonBar.setLayout(new GridBagLayout());
        ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[]{1.0,0.0,0.0};
        ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[]{0,80,75};

        btnSave.setText("保存修改");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSaveActionPerformed(e);
            }


        });


        queryBtn.setFont(new Font("楷体", Font.PLAIN, 16));

        btnSave.setFont(new Font("楷体", Font.BOLD, 16));

        idLabel.setFont(new Font("楷体", Font.PLAIN, 16));







        buttonBar.add(btnSave,new GridBagConstraints(1,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,5),0,0));
        contentPane.add(buttonBar,BorderLayout.SOUTH);
        contentPane.setVisible(true);
        mainContent.add(contentPane,BorderLayout.CENTER);

    }//UI




    private void btnSaveActionPerformed(ActionEvent e) {
        if (textFields.get(0).getText().length()==0){
            return;
        }//判断

        int itemId = Integer.parseInt(textFields.get(0).getText());
        boolean success = false;

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
                JOptionPane.showMessageDialog(this.contentPane,"你的输入包含数字，输入非法");
                return;
            }//判断输入非法
            movie.setReleaseDate(datePicker.getJFormattedTextField().getText());
            success=Moviedao.updateMovie(movie);

        }//电影


        if ("场次".equals(recordType)){
            Show show = new Show();
            show.setId(itemId);
            show.setMid(moviesIds.get(movieBox.getSelectedIndex()));
            if (!CheckHandler.isNumeric(textFields.get(1).getText())){
                JOptionPane.showMessageDialog(this.contentPane,"输入放映厅号码必须为整数");
                return;
            }else {
                show.setHall(Integer.parseInt(textFields.get(1).getText()));
            }
            String time = datePicker.getJFormattedTextField().getText();
            String hour = hourBox.getSelectedItem().toString();//改变 toString
            String minute= minBox.getSelectedItem().toString();//
            time+=" "+hour+":"+minute;
            show.setTime(time);
            if (!CheckHandler.isNumeric(textFields.get(2).getText())){
                JOptionPane.showMessageDialog(this.contentPane,"输入价格必须为整数");
                return;
            }else{
                show.setPrice(Double.parseDouble(textFields.get(2).getText()));
            }
//            System.out.println(show.getHall()+" "+show.getPrice());
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

            JOptionPane.showMessageDialog(this.contentPane,"修改成功");
            new RecordQuery(contentPane,recordType,mainFrame);

            contentPane.setBorder(new EmptyBorder(0,50,100,50));
            mainFrame.setVisible(true);
        }



    }//保存按钮执行


    private void btnQueryActionPerformed(ActionEvent e){
        System.out.println("进入查询");
        int itemId = -1;
        boolean  queryFail = false;
        try {
            String idVal = idField.getText();
            if (idVal.length()==0){
                JOptionPane.showMessageDialog(this.contentPane,"请输入编号查询");
                return;
            }//判断
            itemId = Integer.parseInt(idVal);

        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this.contentPane,"输入不正确，请输入整数");
            return;
        }

        itemId = Integer.parseInt(idField.getText());
        if ("电影".equals(recordType)) {
            Movie movie = Moviedao.getMovie(itemId);
            if (movie != null) {
                textFields.get(0).setText(movie.getMid() + "");
                textFields.get(1).setText(movie.getName());
                textFields.get(2).setText(movie.getType() );
                textFields.get(3).setText(movie.getDirector() );
                textFields.get(4).setText(movie.getSource() );
                textFields.get(5).setText(movie.getPublisher());
                datePicker.getJFormattedTextField().setText(movie.getReleaseDate());
            } else { queryFail = true;}

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
            } else { queryFail = true; }
        }//场次


//        if ("订单".equals(recordType)) {
//            Order order = OrderDao.getOrder(itemId);
//            if (order != null) {
//                textFields.get(0).setText(order.getId() + "");
//                textFields.get(1).setText(order.getName());
//                textFields.get(2).setText(order.getPhone());
//                textFields.get(3).setText(order.getData());
//
//
//            } else {
//                queryFail = true;
//            }//判断
//
//
//        }//订单

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
            JOptionPane.showMessageDialog(this.contentPane, "未检索数据,请调整编号！");
            return;
        }//失败就警告

        System.out.println("退出查询");
    }//查询btn


}
