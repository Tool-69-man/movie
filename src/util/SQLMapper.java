package util;
import take.Movie;
import take.Order;
import take.Show;
import take.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;

//执行结束后，赋值
public class SQLMapper {
    public  static void mapResToMovie(ResultSet res, Movie movie) throws SQLException {
        movie.setMid(res.getInt("mid"));
        movie.setName(res.getString("name"));
        movie.setType(res.getString("type"));
        movie.setReleaseDate(res.getString("release_date"));
        movie.setPublisher(res.getString("publisher"));
        movie.setSource(res.getString("source"));
        movie.setDirector(res.getString("director"));

    }

    public static void mapResToShows(ResultSet res, Show show)throws SQLException {
        show.setHall(res.getInt("hall"));
        show.setId(res.getInt("id"));
        show.setMid(res.getInt("mid"));
        show.setPrice(res.getDouble("price"));
        show.setSeatsUsed(res.getString("seats_used"));
        show.setTime(res.getString("time"));
    }
    public static void mapResToOrder(ResultSet res, Order order)throws SQLException {
        order.setData(res.getString("data"));
        order.setPhone(res.getString("phone"));
//        order.setDatetime(res.getString("da"));
        order.setId(res.getInt("id"));
        order.setName(res.getString("name"));
    }

    public static void mapResToUser(ResultSet res, Staff user)throws SQLException {
        user.setUid(res.getInt("uid"));
        user.setUsername(res.getString("username"));
        user.setPassword(res.getString("password"));
        user.setRole(res.getInt("role"));
    }


}
