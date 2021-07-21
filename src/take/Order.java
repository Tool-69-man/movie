package take;

public class Order {
    private int id;
    private String name;//订单人
    private String phone;//电话
    //订单数据
    //票之间用 ';'隔开
    //id,name,放映时间，价格，座位
    private String data;//  t.getShow()+" "+seat+"|"+t.getMovie()+"|"+t.getTime();    "1 1,1|1|2021-7-13 16:35:00"
    private String datetime;//订单生成时间

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getData() {
        return data;
    }

    public String getDatatime() {
        return datetime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDatatime(String datatime) {
        this.datetime = datatime;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
