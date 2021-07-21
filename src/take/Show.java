package take;

public class Show {
    private int id;//放映编号
    private int mid;//电影编号
    private int hall;//放映厅编号
    private double price;//不同的价格
    private String time;//放映时间
    private String seatsUsed;//被预定的座位用','隔开   " 1,1 2,3 12,9 "    12,9

    public int getMid() {
        return mid;
    }

    public double getPrice() {
        return price;
    }


    public int getHall() {
        return hall;
    }

    public int getId() {
        return id;
    }

    public String getSeatsUsed() {
        return seatsUsed;
    }

    public String getTime() {
        return time;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeatsUsed(String seatsUsed) {
        this.seatsUsed = seatsUsed;
    }

    public void setTime(String time) {
        this.time = time;
    }
}



