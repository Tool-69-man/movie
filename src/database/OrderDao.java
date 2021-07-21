package database;

import take.Order;
import util.QueryCreate;
import util.SQLExec;
import util.SQLMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    //获取多个满足条件的订单对象
    //返回orders List<Orders>
    //条件 有id
    public static List<Order> getOrders(String field, String value){
        List<Order> orders=new ArrayList<Order>();
        try{
            SQLExec sqlExec = new SQLExec();
            String query = "";
            if (field.trim().length()==0){
                query=QueryCreate.queryForResults("orders");
            }else if(field.equals("id")){
                query=QueryCreate.queryForResults("orders",field,Integer.parseInt(value));
            }else {
                query=QueryCreate.queryForResults("orders",field,value);
            }
            //获得结果
            ResultSet resultSet = sqlExec.select(query);

            Order order =null;
            while(resultSet.next()){
                order = new Order();
                SQLMapper.mapResToOrder(resultSet,order);
                orders.add(order);
            }//信息


        }catch (Exception ex){
            ex.printStackTrace();
        }//判断orders报错


        return orders;
    }


    //获取单个满足，输入id
    public static Order getOrder(int orderId){
        //用上一个函数获取
        //但返回List
        List<Order> orders = getOrders("id",orderId+"");
        Order order =null;
        if(orders.size()>0){
            order=orders.get(0);
        }//获取第一个数
        return order;
    }

    //添加新的订单
    public static boolean addOrder(Order order){
        boolean success =false;
        try{
            SQLExec sqlExec = new SQLExec();
            String query = QueryCreate.queryForAdd(order);
            sqlExec.insert(query);
            success = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return success;

    }

    //更新数据库
    public static boolean updateOrder(Order order){
        boolean success = false;
        try{
            SQLExec sqlExec = new SQLExec();
            String query=QueryCreate.queryForUpdate(order);
            sqlExec.update(query);
            success=true;
        }catch (Exception ex){
            ex.printStackTrace();
        }//更新报错
        return success;
    }


    //删除数据库
    public static boolean delectOredr(int orderId){
        boolean success = true;
        try{
            SQLExec sqlExec = new SQLExec();
            String query =QueryCreate.queryForDelete("orders","id",orderId);
            sqlExec.update(query);
            success = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }//删除数据库的判断

        return success;
    }



}
