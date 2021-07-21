package take;

public class Ticket {
    //票的属性

    private int id;
    private int show;//放映编号
    private String movie;//电影编号
    private String time;//放映时间
    private int seatRow;//座位行   12
    private int seatColumn;//座位列数 9
    private double price;//价格
    //方法


    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public int getShow() {
        return show;
    }

    public String getMovie() {
        return movie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public void setShow(int show) {
        this.show = show;
    }
}
