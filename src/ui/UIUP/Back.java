package ui.UIUP;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Back {



        //大图的List集合
        public static List<Image> bigImages =new ArrayList<>();

        //大图变图标
        public   static List<ImageIcon> smallIcons =new ArrayList<ImageIcon>();

        public static String[]   jpg = new  String[100];




        public static void main(String[] args) {

        }


        public Back(){
        }

        public  static Image getBigImage(int i) {//获得图片
            for (int i2=0;i2<jpg.length;i2++){
                jpg[i2] ="X:\\apache-maven-3.8.1\\MOVIES\\jpg\\003\\3 ("+(i2+1)+").jpg";
            }



            for(String x :  jpg){//初始化 list集合    不能在构造中初始化，因为构造最后调用
                Image image =  Toolkit.getDefaultToolkit().getImage(x);//trim去除首尾空格
                bigImages.add(image);
            }
            return bigImages.get(i);


        }

        public static ImageIcon getIcon(int i){//图标，只有只有位置参数
            Image image =  getBigImage(i);
            Image smallImage = image.getScaledInstance(1920,1080,Image.SCALE_SMOOTH);

            ImageIcon smallIcon = new ImageIcon(smallImage);
            return smallIcon;
        }



        public static ImageIcon getIconSetWH(int i,int width,int height){//设置图标大小
            Image image =  getBigImage(i);
            Image smallImage = image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
//    再由修改后的Image来生成合适的Icon
            ImageIcon smallIcon = new ImageIcon(smallImage);
            return smallIcon;
        }


    }


