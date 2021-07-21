package take;

public class Movie {
    //电影元素
    private int mid;//编号，主键
    private String name;
    private String type;//类别
    private String director;//导演
    private String source;//来源国家
    private String publisher;//出版公司
    private String releaseDate;//上映时间

    //getter setter


    public int getMid() {
        return mid;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDirector() {
        return director;
    }

    public String getSource() {
        return source;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }


    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
