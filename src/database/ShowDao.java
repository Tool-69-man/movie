package database;

import take.Show;
import util.QueryCreate;
import util.SQLExec;
import util.SQLMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShowDao {
    //获取多个
    public static List<Show> getShows(String field, String value){
        List<Show> shows=new ArrayList<Show>();
        try{
            SQLExec sqlExec = new SQLExec();
            String query = "";
            if (field.trim().length()==0){
                query=QueryCreate.queryForResults("shows ");
            }else if (field.trim().equals("id")|| field.trim().equals("mid")||field.trim().equals("hall")){//多个整型查询
                query=QueryCreate.queryForResults("shows",field,Integer.parseInt(value));
            }else if(field.trim().equals("price")){//小数查询
                query=QueryCreate.queryForResults(" shows ",field,Double.parseDouble(value));
            }else {
                query=QueryCreate.queryForResults(" shows ",field,value);
            }
            ResultSet res=sqlExec.select(query);
            Show show =null;
            while (res.next()){
                show=new Show();
                SQLMapper.mapResToShows(res,show);
                shows.add(show);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }//获取多个判断
        return shows;
    }
    //获取单个
    public static Show getShow(int showId){
        List<Show> shows = getShows("id",showId+"");
        Show show =null;
        if (shows.size()>0){
            show=shows.get(0);
            }
            return show;
    }
    public static boolean addShow(Show show){
        boolean success = false;
        try{
            String equry="";
            SQLExec sqlExec = new SQLExec();
            //sql代码创建
            equry=QueryCreate.queryForAdd(show);
            //执行
            sqlExec.insert(equry);
            System.out.println(equry);
            success  = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }//判读添加报错
        return success;
    }


    //更新已有数据对象
    public static boolean updateShow(Show show){
        boolean success =false;
        try{
            String equry=QueryCreate.queryForUpdate(show);
            System.out.println(equry);//查看输入的sql代码
            SQLExec sqlExec=new SQLExec();
            sqlExec.update(equry);
            success=true;
        }catch (Exception ex){
            ex.printStackTrace();
        }//判断更新报错
        return success;

    }


    //删除已有
    public static boolean deleteShow(int showId){
        boolean success =false;
        try{
            String equry=QueryCreate.queryForDelete(" shows ","id",showId);
            System.out.println(equry);//查看输入的sql代码
            SQLExec sqlExec=new SQLExec();
            sqlExec.update(equry);
            success=true;
        }catch (Exception ex){
            ex.printStackTrace();
        }//判断更新报错
        return success;

    }


    public static void removeUsedSeats(List<String> usedSeatList){
        for (String usedSeat:usedSeatList){
            System.out.println(usedSeat);
            String[] seatMeta = usedSeat.split(" ");
            int showId = Integer.parseInt(seatMeta[0]);
            String seat = seatMeta[1];
            //提取数据库放映场次座位信息
            Show show =ShowDao.getShow(showId);
            String usedSeats = show.getSeatsUsed();
            if(usedSeats.length()>0){
                //从占用列表删除该座位
                usedSeats=(" "+usedSeats+" ").replace(" "+seat+" ", "").trim();
                System.out.println("usedSeats:"+usedSeats);
                show.setSeatsUsed(usedSeats);
                ShowDao.updateShow(show);
            }//执行座位代码

        }//每个座位的操作
    }




}
