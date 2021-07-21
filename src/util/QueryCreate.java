package util;

import take.Movie;
import take.Order;
import take.Show;
import take.Staff;

//查询命令，返回SQL代码
public class QueryCreate {
    //查询命令，获得表格所有记录
    public static String queryForResults(String tableName) {
        String str =  "  SELECT * from  "  + tableName;
        System.out.println(str);
        return str;
    }

    //用于生成基于整数项的查询命令
    public static String queryForResults(String tableName, String fieldName, int fieldVal) {
        String str =  "  SELECT * from  "  + tableName +  "  WHERE  "  + fieldName +  "  =  "  + fieldVal;
        System.out.println(str);
        return str;
    }

    //小数项的查询命令
    public static String queryForResults(String tableName, String fieldName, double fieldVal) {
        String str =  " SELECT * from  "  +  tableName +  " WHERE "  + fieldName +  " = "  + fieldVal;
        System.out.println(str);
        return str;
    }

    //String 的查询命令  用like的方法
    public static String queryForResults(String tableName, String fieldName, String fieldVal) {
        String str =  " SELECT * from  "  +  tableName +  " WHERE "  + fieldName +  " LIKE  '%"  + fieldVal.trim() +  "%'  " ;
        System.out.println(str);
        return str;
    }

    //=========================

    //生成用户身份
    public static String queryByCredential(String username, String password) {
        String str =  " SELECT * from staff  WHERE username =   '"  + username.trim() +  "'  AND password =  '"  + password.trim() + "'   " ;
        System.out.println(str);
        return str;
    }


    //==========================


    //更新电影记录命令
    public static String queryForUpdate(Movie movie) {
        String query =  " UPDATE movies SET name =  '"  + movie.getName()
                +  "' , type =  '"  + movie.getType()
                +  "' , director =  '"  + movie.getDirector()
                +  "' , source = '"  + movie.getSource()
                +  "' , publisher =  '"  + movie.getPublisher()
                +  "' , release_date =  '"  + movie.getReleaseDate()
                +  "'  WHERE mid =  "  + movie.getMid();//数字不用加 '  '
        System.out.println(query);
        return query;
    }

    //更新订单表格记录命令
    public static String queryForUpdate(Show show) {
        String query =  " UPDATE shows SET mid =  " 
                + show.getMid()
                +  " , hall= "  + show.getHall()
                +  " , time =  '"  + show.getTime() +  "'  "
                +  " , price =  "  + show.getPrice();
        if (show.getSeatsUsed() != null) {
            query +=  " , seats_used =  '"  + show.getSeatsUsed() +  "'  " ;
        }
        query +=  "  WHERE id = "  + show.getId();
        System.out.println(query);
        return query;
    }

    public static String queryForUpdate(Order order) {
        String query =  " UPDATE orders SET name =  '"
                + order.getName()
                +  "' , phone=  '"  + order.getPhone()+ "'  " ;
        if (order.getData() != null) {
            query +=  " , data= '"  + order.getData()+  "'  " ;
        }
        query +=  " WHERE id = "  + order.getId();
        System.out.println(query);
        return query;
    }

    //管理员权限
    public static String queryForUpdate(Staff user) {
        String query =  " UPDATE staff SET username =  '"  + user.getUsername()
                +  "' , password = '"  + user.getPassword()
                +  "' , role =  "  + user.getRole()
                +  " WHERE uid =  "  + user.getUid();
        System.out.println(query);
        return query;
    }


    //=======================

    //更新密码
    public static String queryForUpdatePass(int userId, String password) {
        String query =  " UPDATE staff SET password =  '"  + password.trim() +  "' WHERE uid =  "  + userId;
        System.out.println(query);
        return query;
        }


    //=======================


        //添加命令
    public static String queryForAdd(Movie movie){
       String query = " INSERT INTO movies  "  +
                " (name, type, director, source,publisher,release_date)  "  +
                " VALUES ( '"  +
               movie.getName()+ "' , '" +
               movie.getType()+ "' , '" +
               movie.getDirector()+ "' , '" +
               movie.getSource()+ "' , '" +
               movie.getPublisher()+ "' , '" +
               movie.getReleaseDate()+ "' ) " ;
        System.out.println(query);
        return query;
    }

    public static String queryForAdd(Show show){
        String query = " INSERT INTO shows  "  +
                 " (mid, hall, time, price,seats_used)  "  +
                 " VALUES ( "  +
                show.getMid()+ " , " +
                show.getHall()+ " , '" +
                show.getTime()+ "' , " +
                show.getPrice()+ " , '" +
                show.getSeatsUsed()+ "' ) " ;
        System.out.println(query);
        return query;
    }

    public static String queryForAdd(Order order){
        String query = " INSERT INTO orders  "  +
                 " (name, phone,data)  "  +
                 " VALUES ( '"  +
                order.getName()+ "' , '" +
                order.getPhone()+ "' , '" +
                order.getData()+ "' ) " ;
        System.out.println(query);
        return query;
    }

    public static String queryForAdd(Staff user){
        String query = " INSERT INTO staff  "  +
                 "  (username, password, role)  "  +
                 "  VALUES (  '"  +
                user.getUsername()+ "' , '" +
                user.getPassword()+ "' , " +
                user.getRole()+ " ) " ;//int
        System.out.println(query);
        return query;
    }



    //=====================


        //删除
    public static String queryForDelete(String tableName, String idField, int id){
        String query= " delete from  " +tableName+ "  WHERE  " +idField+ "  =  " +id;
        System.out.println(query);
        return query;
    }


}