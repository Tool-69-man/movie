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

public class RecordAdd {
    private JPanel recordPane;
    private JPanel contentPane;
    private JPanel combinedPane;
    private JPanel btnBar;
    private JButton btnSave;
    private JComboBox<String> roleBox;
    private JComboBox<String> hourBox;
    private JComboBox<String> minBox;
    private JComboBox<String> movieBox;
    private JDatePickerImpl datePicker;
    private String recordType;
    private JFrame mainFram;

    private List<JTextField> textFields;
    private List<Integer> moviesIds;

    public RecordAdd(Container mainContent, String type, JFrame jFrame){
        textFields = new ArrayList<JTextField>();
        moviesIds = new ArrayList<Integer>();
        recordType =type;
        mainFram = jFrame;
        initUI(mainContent);
    }

    public void initUI(Container mainContent){
        mainContent.removeAll();
        contentPane = new JPanel(new BorderLayout());
//        contentPane.setBorder(new EmptyBorder(50,50,50,50));
        recordPane = new JPanel();
        btnBar = new JPanel();
        btnSave = new JButton();
        String[] currLabels = new String[0];

        //不同对象，布局不同
        if ("电影".equals(recordType)){
            currLabels = Constant.movieLables;
            recordPane.setLayout(new GridLayout(6,2,6,6));
            contentPane.setBorder(new EmptyBorder(100,150,150,300));
        }
        if ("场次".equals(recordType)){
            currLabels = Constant.showLables;
            recordPane.setLayout(new GridLayout(5,2,6,6));
            contentPane.setBorder(new EmptyBorder(100,150,200,250));
        }

        if ("用户".equals(recordType)){
            currLabels = Constant.staffLables;
            recordPane.setLayout(new GridLayout(3,2,6,6));
            contentPane.setBorder(new EmptyBorder(150,150,250,300));
        }

        for(int i =1;i<currLabels.length;i++) {
            JLabel entryLabel = new JLabel();
            JTextField entryField = new JTextField();
            entryLabel.setText(currLabels[i] + " : ");
            entryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            recordPane.add(entryLabel);

            if ("场次".equals(recordType) && "电影名称".equals(currLabels[i].trim())) {
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
//                datePicker.setBorder(new EmptyBorder(10, 0, 0, 20));
                recordPane.add(datePicker);
                combinedPane = new JPanel();
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
                roleBox = new JComboBox<String>(Constant.userRoleDescs);
                recordPane.add(roleBox);
            }  else {
                recordPane.add(entryField);
                textFields.add(entryField);
            }


        }//for




        contentPane.add(recordPane,BorderLayout.CENTER);
        btnBar.setBorder(new EmptyBorder(12,0,0,0));
        btnBar.setLayout(new GridBagLayout());
        ((GridBagLayout)btnBar.getLayout()).columnWeights = new double[]{1.0,0.0,0.0};
        ((GridBagLayout)btnBar.getLayout()).columnWidths = new int[]{0,85,80};

        btnSave.setText("添加");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSaveActionPerformed(e);
            }
        });




        btnSave.setFont(new Font("楷体", Font.PLAIN, 20));

        btnBar.add(btnSave,new GridBagConstraints(1,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,5),0,0));
        contentPane.add(btnBar,BorderLayout.SOUTH);
        mainContent.add(contentPane,BorderLayout.CENTER);


    }//UI

    private void btnSaveActionPerformed(ActionEvent e){
        if (CheckHandler.checkEmptyField(textFields)){
            JOptionPane.showMessageDialog(this.contentPane,"有些项为空，请输入内容");
            return;
        }

        boolean success = false;



        if ("电影".equals(recordType)){
            Movie movie = new Movie();

            movie.setName(textFields.get(0).getText());
            movie.setType(textFields.get(1).getText());
            movie.setDirector(textFields.get(2).getText());
            movie.setSource(textFields.get(3).getText());
            movie.setPublisher(textFields.get(4).getText());
            String totalContent = textFields.get(1).getText()+textFields.get(2).getText()
                    +textFields.get(3).getText()+textFields.get(4).getText();
            if (CheckHandler.containsDigit(totalContent)){
                JOptionPane.showMessageDialog(this.contentPane,"你的输入包含数字，输入非法");
                return;
            }//判断输入非法
            movie.setReleaseDate(datePicker.getJFormattedTextField().getText());
            success=Moviedao.addMovie(movie);

        }//电影

        if ("场次".equals(recordType)){
            Show show = new Show();

            show.setMid(moviesIds.get(movieBox.getSelectedIndex()));
            if (!CheckHandler.isInteger(textFields.get(0).getText())){
                JOptionPane.showMessageDialog(this.contentPane,"输入放映厅号码必须为整数");
                return;
            }else {
                show.setHall(Integer.parseInt(textFields.get(0).getText()));
            }
            String time = datePicker.getJFormattedTextField().getText();
            String hour = hourBox.getSelectedItem().toString();
            String minute= minBox.getSelectedItem().toString();
            time+=" "+hour+":"+minute;
            System.out.println("时间："+time);
            show.setTime(time);
            if (!CheckHandler.isNumeric(textFields.get(1).getText())){
                JOptionPane.showMessageDialog(this.contentPane,"输入价格必须为数字");
                return;
            }else{
                show.setPrice(Double.parseDouble(textFields.get(1).getText()));
            }
           show.setSeatsUsed("");
            success = ShowDao.addShow(show);


        }//场次

        if ("用户".equals(recordType)){
            Staff user = new Staff();
            user.setUsername(textFields.get(0).getText());
            user.setPassword(textFields.get(1).getText());
            user.setRole(Constant.userRoleIds[roleBox.getSelectedIndex()]);
            success= StaffDao.addUser(user);
        }//用户

        if (success){
            JOptionPane.showMessageDialog(this.contentPane,"添加成功");
            new RecordQuery(contentPane,recordType,mainFram);
            contentPane.setBorder(new EmptyBorder(0,50,100,50));
            mainFram.setVisible(true);
        }
    }//保存按钮函数

}
