package util;
//常量类
public class Constant {
    //管理员权限
    public static final int VISITOR_ROLE = 0;
    public static final int ONLY_VIEW_ROLE = 1;
    public static final int MOVIE_ADMIN_ROLE = 2;
    public static final int SHOW_ADMIN_ROLE = 3;
    public static final int ORDER_ADMIN_ROLE = 4;
    public static final int FULL_ADMIN_ROLE = 50;
    public static final int ROOT_ADMIN_ROLE = 99;

    //放映厅12*9
    public static final int HALL_ROW_NUM = 12;
    public static final int HALL_COLUMN_NUM = 9;

    //标签名称对应的数据库名称
    //电影，场次，订单，用户，票，权限，
    public static String[] movieLables={"电影编号","电影名称","电影类别","导演","来源国家","出版公司","上映时间"};
    public static String[] movieDBFields={"mid","name","type","director","source","publisher","release_Date"};

    public static String[] showLables={"场次编号","电影名称","放映厅","放映时间","票价（￥）"};
    public static String[] showDBFields={"id","mid","hall","time","price"};

    public static String[] orderLables={"订单编号","名字","电话","订单数据"};
    public static String[] orderDBFields={"id","name","phone","data"};

    public static String[] staffLables={"管理员编号","用户名","用户密码","权限"};
    public static String[] staffDBFields={"uid","username","password","role"};

    public static String[] ticketLables={"编号","电影名称","时间","票价","座位"};

    public static String[] userRoleDescs={"无管理权限","只能管理电影","只能管理场次","只能管理订单","完全管理权限","根管理权限"};
    public static int[] userRoleIds={ONLY_VIEW_ROLE ,MOVIE_ADMIN_ROLE,SHOW_ADMIN_ROLE,ORDER_ADMIN_ROLE,FULL_ADMIN_ROLE,ROOT_ADMIN_ROLE};



    //时间小时，分钟
    public static String[] timeHours={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
    public static String[] timeMinutes={"00","05","10","15","20","25","30","35","40","45","50","55"};




}
