package database;

import take.Staff;
import util.QueryCreate;
import util.SQLExec;
import util.SQLMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDao {
    //获取多个
    public static List<Staff> getStaffs(String field, String value){
        List<Staff> users =new ArrayList<Staff>();
        try{
            String query="";
            SQLExec sqlExec = new SQLExec();
            if(field.length()==0){
                query = QueryCreate.queryForResults("staff");
            }else if (field.trim().equals("uid")||field.trim().equals("role")){
                query = QueryCreate.queryForResults("staff",field,Integer.parseInt(value));
            }else {
                query = QueryCreate.queryForResults("staff",field,value);
            }
            ResultSet resultSet = sqlExec.select(query);
            Staff user =null;
            while(resultSet.next()){
                user = new Staff();
                SQLMapper.mapResToUser(resultSet,user);
                users.add(user);
            }//获取Staff全部信息,塞进list

        }catch (Exception ex){
            ex.printStackTrace();
        }//Staff的获取测试

        return  users;
    }


    //获取单个
    public static Staff getStaff(int userid){
       List<Staff> users = getStaffs("uid",userid+"");
       Staff user =null;
       if (users.size()>0){
           user = users.get(0);
       }
        return user;
    }

    //管理员登录验证
    public static Staff getUserByCredential(String username, String password){
        Staff user =null;
        try{
            String query = QueryCreate.queryByCredential(username,password);
            SQLExec sqlExec = new SQLExec();
            ResultSet resultSet = sqlExec.select(query);
            while (resultSet.next()){
            user = new Staff();
                SQLMapper.mapResToUser(resultSet,user);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }



        return user;
    }


    //添加
    public  static boolean addUser(Staff user){
        boolean success =true;
        try{
            String query=QueryCreate.queryForAdd(user);
            SQLExec sqlExec =new SQLExec();
            sqlExec.insert(query);
            success = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return success;
    }

    //更新管理员数据
    public static boolean updateUser(Staff user){
        boolean success =true;
        try{
            String query=QueryCreate.queryForUpdate(user);
            SQLExec sqlExec =new SQLExec();
            sqlExec.update(query);
            success = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return success;
    }

    //更新管理密码
    public  static  boolean updateUserPass(int userid,String password){
        boolean success =true;
        try{
            String query=QueryCreate.queryForUpdatePass(userid,password);
            SQLExec sqlExec =new SQLExec();
            sqlExec.update(query);
            success = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return success;
    }
    //删除
    public static boolean deleteUser(int userId){
        boolean success =true;
        try{
            String query=QueryCreate.queryForDelete("Staff","uid",userId);
            SQLExec sqlExec =new SQLExec();
            sqlExec.update(query);
            success = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return success;
    }


}
