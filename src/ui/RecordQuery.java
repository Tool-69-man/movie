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
import javax.swing.table.DefaultTableModel;
import javax.tools.JavaCompiler;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class RecordQuery {
    //查询

    private String recordType;
    private JTable recordTable;
    private JPanel contentPane;
    private JComboBox<String> queryBox;
    private JTextField queryValue;

    public RecordQuery(Container mainContent, String type, JFrame jFrame){
        recordType =type;
        initUI(mainContent);
    }

    public void initUI(Container mainContent){
        //移除面板控件
        //用户操作界面=》面板
        mainContent.removeAll();
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(50,50,50,50));



        //添加查询功能模块区域
        final JPanel queryPane = new JPanel();
        queryPane.setLayout(new GridLayout(1,3));
        String[] fields =null;
        if ("电影".equals(recordType)){
            fields = Constant.movieLables;
        }
        if ("场次".equals(recordType)){
            fields = Constant.showLables;
        }
        if ("订单".equals(recordType)){
            fields = Constant.orderLables;
        }
        if ("用户".equals(recordType)){
            fields = Constant.staffLables;
        }



        //添加查询结果显示表格

        queryBox = new JComboBox<String>(fields);
        queryValue = new JTextField();

        JButton queryBtn = new JButton("查询");
        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("chaxun");
                btnQueryActionPerformed(e);
            }
        });

        JButton resetBtn = new JButton("重置");
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("reset");
                btnResetActionPerformed(e);
            }
        });

        //点击表格内记录，将弹出编辑框
        queryPane.add(queryBox);
        queryPane.add(queryValue);
        queryPane.add(queryBtn);
        queryPane.add(resetBtn);
        contentPane.add(queryPane);

        //显示当前内容区
        final JPanel resultPane =new JPanel();
        resultPane.setPreferredSize(new Dimension(600,400));
        recordTable = new JTable();
        final BorderLayout borderLayout = new BorderLayout();
        borderLayout.setVgap(5);
        resultPane.setLayout(borderLayout);
        contentPane.add(resultPane);
        final JScrollPane scrollPane =new JScrollPane();
        resultPane.add(scrollPane);
        System.out.println("没有搜索的展示表");
        paintTable("","");

        scrollPane.setViewportView(recordTable);

        recordTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {//mousePressed   mouseClicked
                int row = recordTable.rowAtPoint(e.getPoint());
                int col = recordTable.columnAtPoint(e.getPoint());
                if (row>=0&&col>=0){
                    int item = (int )recordTable.getValueAt(row,0);
                    new RecordEditDialog(recordType,item,recordTable,row);
                }//判断是否越界
            }
        });

        contentPane.setVisible(true);
        mainContent.add(contentPane,BorderLayout.CENTER);
    }//UI


    //处理查询不同类型的数据
    private  void btnQueryActionPerformed(ActionEvent e){
        String field = "";
        if ("电影".equals(recordType)){
            field = Constant.movieDBFields[queryBox.getSelectedIndex()];
        }

        if ("场次".equals(recordType)){
            field = Constant.showDBFields[queryBox.getSelectedIndex()];
        }

        if ("订单".equals(recordType)){
            field = Constant.orderDBFields[queryBox.getSelectedIndex()];
        }
        if ("用户".equals(recordType)){
            field = Constant.staffDBFields[queryBox.getSelectedIndex()];
        }

        String value = queryValue.getText().trim();
        if(value.length()==0){
            JOptionPane.showMessageDialog(null,"请输入关键词再索引");
            return;
        }

        paintTable(field,value);
    }//查询表


    //重新加载数据库所有记录
        private void  btnResetActionPerformed(ActionEvent ex){
            System.out.println("重置表");

            paintTable("","");
//            btnQueryActionPerformed(e);
        }


    //获取特定表格
    private void paintTable(String field, String value){
        System.out.println("进入画图");
        DefaultTableModel model  = new DefaultTableModel();
        recordTable.setModel(model);
        recordTable.setEnabled(false);

        Object[][]  tbData = null;
        int i = 0 ;
        if("电影".equals(recordType)){
            List<Movie> movies = Moviedao.getMovies(field,value);
            tbData = new Object[movies.size()][Constant.movieLables.length];
            for(Movie m : movies){
                tbData[i][0] = m.getMid();
                tbData[i][1] = m.getName();
                tbData[i][2] = m.getType();
                tbData[i][3] = m.getDirector();
                tbData[i][4] = m.getSource();
                tbData[i][5] = m.getPublisher();
                tbData[i][6] = m.getReleaseDate();
                i++;
            }//电影赋值结果
            model.setDataVector(tbData,Constant.movieLables);
        }//结果为电影


        if("场次".equals(recordType)){
            List<Show> shows = ShowDao.getShows(field,value);
            tbData = new Object[shows.size()][Constant.showLables.length];
            for(Show s : shows){
                tbData[i][0] = s.getId();
                tbData[i][1] = Moviedao.getMovie(s.getMid()).getName();
                tbData[i][2] = s.getHall();
                tbData[i][3] = s.getTime();
                tbData[i][4] = s.getPrice();
                i++;
            }//赋值结果
            model.setDataVector(tbData,Constant.showLables);
        }//表格结果


        if("订单".equals(recordType)){
            List<Order> orders = OrderDao.getOrders(field,value);
            tbData = new Object[orders.size()][Constant.movieLables.length];
            for(Order order: orders){
                tbData[i][0] = order.getId();
                tbData[i][1] = order.getName();
                tbData[i][2] = order.getPhone();
                tbData[i][3] = order.getData();
                tbData[i][4] = order.getDatatime();
                i++;
            }//赋值结果
            model.setDataVector(tbData,Constant.orderLables);
        }//表格结果


        if("用户".equals(recordType)){
            List<Staff> staffs = StaffDao.getStaffs(field,value);
            tbData = new Object[staffs.size()][Constant.staffLables.length];
            for(Staff staff: staffs ){
                tbData[i][0] = staff.getUid();
                tbData[i][1] = staff.getUsername();
                tbData[i][2] = staff.getPassword();
//                tbData[i][3] = staff.getRole();

                //检测数据权限是否有效

                int index = CheckHandler.getSelectIndexById(staff.getRole());
                if (index>=0){
                    tbData[i][3] = Constant.userRoleDescs[index];
                }else{
                    tbData[i][3]="";
                }

                i++;

            }//赋值结果
            model.setDataVector(tbData,Constant.staffLables);
        }//表格结果



        System.out.println("退出画图");
    }



}
