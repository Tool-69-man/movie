package database;

import take.Movie;
import util.QueryCreate;
import util.SQLExec;
import util.SQLMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Moviedao {
    //获取多个电影对象
    public static List<Movie> getMovies(String field, String value){//第一个为属性名，第二个属性值
        //创建movie LIST
        List<Movie> movies=new ArrayList<Movie>();

        try{
            SQLExec sqlExec=new SQLExec();//连接
            String query="";
            if (field.length()==0){
                query= QueryCreate.queryForResults("movies");//提取所有电影信息<=sql语句
            }else if (field.trim().equals("mid")){//
                query=QueryCreate.queryForResults("movies",field,Integer.parseInt(value));
                //将字符串转成数字，调用int 和double 重载函数
                //查看，修改，删除
            }else {
                query=QueryCreate.queryForResults("movies",field,value);//字符串
                //String 重载 一般检索用于查看
            }//获得sql

            ResultSet resultSet= sqlExec.select(query);
            Movie movie = null;
            while(resultSet.next()){
                movie = new Movie();//第一次初始化新的，第二次赋值
                SQLMapper.mapResToMovie(resultSet,movie);
                movies.add(movie);
            }//一次创建，初始化每个影片

        }catch (Exception ex){
            ex.printStackTrace();
        }//  //实现时，判断错误
        return movies;
    }


    //获取查询对象
    public static Movie getMovie(int movieId){
        List<Movie> movies = getMovies("mid",movieId+"");//将movieId变成String
        // 为什么不String movied? 要调用时传入String 其中要用equals函数
        //那这个方法也能省去 输入int,String 类型的报错判断？
        Movie movie = null;
        if (movies.size() > 0) {
            movie=movies.get(0);//获得
        }

        return movie;
    }

    //添加新的对象，返回booolean
    public static boolean addMovie(Movie movie){
        boolean success = false;
        try{
            String query="";
            SQLExec sqlExec = new SQLExec();
            //sql代码创建
            query=QueryCreate.queryForAdd(movie);//传入新电影
            //执行
            sqlExec.insert(query);
            System.out.println(query);
            success  = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }//判读添加报错
        return success;
    }


    //更新已有数据对象
    public static boolean updateMovie(Movie movie){
        boolean success =false;
        try{
            String equry=QueryCreate.queryForUpdate(movie);
            System.out.println(equry);//查看输入的sql代码
            SQLExec sqlExec=new SQLExec();
            sqlExec.update(equry);
            success=true;
        }catch (Exception ex){
            ex.printStackTrace();
        }//判断更新报错
        return success;

    }


    //删除已有电影数据
    public static boolean deleteMovie(int movieId){
        boolean success =false;
        try{
            String equry=QueryCreate.queryForDelete("movies","mid",movieId);
            System.out.println(equry);//查看输入的sql代码
            SQLExec sqlExec=new SQLExec();
            sqlExec.update(equry);
            success=true;
        }catch (Exception ex){
            ex.printStackTrace();
        }//判断更新报错
        return success;

    }

}
