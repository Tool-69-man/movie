package util;

import java.sql.*;

//代码执行
public class SQLExec {
    private static Connection conn=null;//连接的SQLExec类全局变量

    public static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/cinema_tickets?"
            +"useUnicode=true&characterEncoding=UTF-8&useSSL=true";
    private static final String USER="root";
    private static final String PASSWORD="man69";
    //链接数据库
    public SQLExec(){


        if (conn == null){
            try{

                Class.forName(DBDRIVER);//加载数据库驱动程序，不需实例化

                //根据连接协议，用户名，密码连接数据库
             conn=DriverManager.getConnection(DBURL,USER,PASSWORD);

            }catch (Exception ex){
                ex.printStackTrace();
            }//异常判断
        }//没连接


    }//构造


    //提取,更新，插入数据
    public ResultSet select(String query)throws SQLException {
        ResultSet res =null;
        if(!query.equals("")) {
            PreparedStatement statement = conn.prepareStatement(query);
            res=statement.executeQuery();
        }
        return res;
    }

    public void update(String query)throws SQLException {

        if(!query.equals("")) {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.executeUpdate();
        }

    }


    public void insert(String query)throws SQLException {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.executeUpdate();
    }
}
