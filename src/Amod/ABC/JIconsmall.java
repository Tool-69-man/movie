package Amod.ABC;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JIconsmall {
//    static public Image bigImage;
//    static public ImageIcon smallIcon;

    //大图的List集合
    public static List<Image> bigImages =new ArrayList<>();

    //大图变图标
    public   static   List<ImageIcon> smallIcons =new ArrayList<ImageIcon>();

    public static String[]   jpg = new  String[]{

            "pngIcon\\left.png",//0

            "pngIcon\\start.png",//1
            "pngIcon\\stop.png",//2
            "pngIcon\\right.png",//3
            "pngIcon\\query.png",//4
            "pngIcon\\left(2).png",//5
            "pngIcon\\right(2).png",//6
            "pngIcon\\rightcolor.png",//7
            "pngIcon\\coloryello.png",//8

            "pngIcon\\startcolor1.png",//9
            "pngIcon\\leftcolor1.png",//10
            "pngIcon\\rightcolor1.png",//11
            "pngIcon\\stopcolor1.png",//12
            "pngIcon\\start3.png",//13


        "1GQ34353-7.jpg",
                "2b-nier_automata-game-girl-(14646).jpg ",
                "    2b-nier_automata-swords-game-art-(1021).jpg ",
                "   153_170110121135_1.jpg",
                "   226_151030100239_6.jpg",
                "  347_170213185021_1.jpg ",
                "  576b7427d7b98.jpg ",
                "  5879d114a9d38.jpg ",
                "   21627d4c-8d4d-4813-8af1-a1b31de48d6d.jpg",
                "  60533_nier_automata.jpg",
                "  60540_nier_automata.jpg",
                "  800487.png",
                "  60932337_p0.jpg",
                " 2016113011409478.jpg",
                "20161110100706931.jpg",
                "20170307105359348.jpg",
                "201705111415111465.jpg",
                "201612281349391312528.jpg",
                "201612281349399217192.jpg",
                "b44730c6-f5c7-478a-ba6c-5a69c0c6e6cb.jpg",
                "cosplay_sexy_2b_nier_automata_01.jpg",
                "konachan-com-233358-blindfold-breasts-cameltoe-cleavage-dk_senie-dress-gloves-gray_hair-katana-nier-panties-short_hair-sword-tears-thighhighs-underwear-weapon-white_hair.jpg",
                "Nier-Automata-4K-Wallpaper.jpg",
                "nier_automata-yorha_2b-katana-girl-(2019).jpg",
                "nier_automata-yorha_2b-sword-game-girl-art-(696).jpg",
                "nier_automata_2b__poster_v_1_by_arjash-dazhfah.jpg",
                "sagLCKbkAqgnpcs.jpg",
                "T93NaMG.png",
                "tumblr_static_1192xze0y8b48o8cwwsk8g8ok.jpg",
                "yorha-2b-9s-and-a2-(1089).jpg",
                "yorha_2b-art-nier_automata-girl-(694).jpg",
                "yorha_2b-eyepatch-nier_automata-(1052).jpg",
                "yorha_2b-game-art-nier_automata-(10510).jpg ",
                "yorha_2b-girl-art-katana-nier_automata-(209).jpg",
                " yorha_2b-katana-nier_automata-(10516).jpg",
                "yorha_2b-katana-nier_automata-(10831).jpg",
                "yorha_2b-katana-nier_automata-game-(10839).jpg",
                "yorha_2b-katana-sword-nier_automata-(1084).jpg",
                "yorha_2b-katana-sword-nier_automata-(1086).jpg",
                " yorha_2b-nier_automata-(10511).jpg",
                "yorha_2b-nier_automata-game-(10841).jpg",
                "yorha_2b-nier_automata-game-art-(10526).jpg",
                "yorha_2b-nier_automata-katana-(10523).jpg"
    };


    public static void main(String[] args) {
//        for(String x :  jpg){
//            Image image =  Toolkit.getDefaultToolkit().getImage("X:\\JDBCMysql\\DayForJavaSql\\jpg\\347_170213185021_1.jpg");
//            bigImages.add(image);
//        }
//        Image ima=getBigImage(1);
//        System.out.println(ima);

//        ImageIcon imageIcon = new ImageIcon("X:\\JDBCMysql\\DayForJavaSql\\jpg\\1GQ34353-7.jpg");    // Icon由图片文件形成
//        Image image = imageIcon.getImage();                         // 但这个图片太大不适合做Icon
////    为把它缩小点，先要取出这个Icon的image ,然后缩放到合适的大小
//        Image smallImage = image.getScaledInstance(192,108,Image.SCALE_SMOOTH);
////    再由修改后的Image来生成合适的Icon
//        ImageIcon smallIcon = new ImageIcon(smallImage);
//
////        Image image1 =new ;
//
//        List<Image> images =new ArrayList<Image>();
//        images.add(Toolkit.getDefaultToolkit().getImage("1GQ34353-7.jpg"));
//
//
//        JFrame jf = new JFrame("");
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        jf.setSize(500,500);
//        // 第 1 个 JPanel, 使用默认的浮动布局
//        JPanel panel01 = new JPanel();
//        JButton jButton =new JButton("图");
//
//
//
//        jButton.setIcon((new ImageIcon(images.get(0).getScaledInstance(192,108,Image.SCALE_SMOOTH))));
//
//        panel01.add(jButton);
//        jf.add(panel01);
//
////        jf.pack();
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);


//        //字符串数组
//        String[] jpg = new  String[]{
//                "1GQ34353-7.jpg",
//                "2b-nier_automata-game-girl-(14646).jpg ",
//                "2b-nier_automata-swords-game-art-(1021).jpg ",
//                "153_170110121135_1.jpg ",
//        "226_151030100239_6.jpg ",
//        " 347_170213185021_1.jpg ",
//        "  576b7427d7b98.jpg ",
//        "  5879d114a9d38.jpg ",
//        "   21627d4c-8d4d-4813-8af1-a1b31de48d6d.jpg",
//                "  60533_nier_automata.jpg",
//                "  60540_nier_automata.jpg",
//                "  800487.png",
//                "  60932337_p0.jpg",
//                " 2016113011409478.jpg",
//                "20161110100706931.jpg",
//                "20170307105359348.jpg",
//                "201705111415111465.jpg",
//                "201612281349391312528.jpg",
//                "201612281349399217192.jpg",
//                "b44730c6-f5c7-478a-ba6c-5a69c0c6e6cb.jpg",
//                "cosplay_sexy_2b_nier_automata_01.jpg",
//                "konachan-com-233358-blindfold-breasts-cameltoe-cleavage-dk_senie-dress-gloves-gray_hair-katana-nier-panties-short_hair-sword-tears-thighhighs-underwear-weapon-white_hair.jpg",
//                "Nier-Automata-4K-Wallpaper.jpg",
//                "nier_automata-yorha_2b-katana-girl-(2019).jpg",
//                "nier_automata-yorha_2b-sword-game-girl-art-(696).jpg",
//                "nier_automata_2b__poster_v_1_by_arjash-dazhfah.jpg",
//                "sagLCKbkAqgnpcs.jpg",
//                "T93NaMG.png",
//                "tumblr_static_1192xze0y8b48o8cwwsk8g8ok.jpg",
//                "yorha-2b-9s-and-a2-(1089).jpg",
//                "yorha_2b-art-nier_automata-girl-(694).jpg",
//                "yorha_2b-eyepatch-nier_automata-(1052).jpg",
//                "yorha_2b-game-art-nier_automata-(10510).jpg ",
//                "yorha_2b-girl-art-katana-nier_automata-(209).jpg",
//                " yorha_2b-katana-nier_automata-(10516).jpg",
//                "yorha_2b-katana-nier_automata-(10831).jpg",
//                "yorha_2b-katana-nier_automata-game-(10839).jpg",
//                "yorha_2b-katana-sword-nier_automata-(1084).jpg",
//                "yorha_2b-katana-sword-nier_automata-(1086).jpg",
//                " yorha_2b-nier_automata-(10511).jpg",
//                "yorha_2b-nier_automata-game-(10841).jpg",
//                "yorha_2b-nier_automata-game-art-(10526).jpg",
//                "yorha_2b-nier_automata-katana-(10523).jpg",
//
//        };
//
//

//
//        //大图的List集合
//        List<Image> bigImages =new ArrayList<Image>();
//
//
//
//        //大图变图标
//        List<ImageIcon> smallIcons =new ArrayList<ImageIcon>();

//// 方法一: 通过 java.awt.Toolkit 工具类来读取本地、网络 或 内存中 的 图片（支持 GIF、JPEG 或 PNG）
//Image image = Toolkit.getDefaultToolkit().getImage(String filename);
//Image image = Toolkit.getDefaultToolkit().getImage(URL url);
//Image image = Toolkit.getDefaultToolkit().createImage(byte[] imageData);
//
//// 方法二: 通过 javax.imageio.ImageIO 工具类读取本地、网络 或 内存中 的 图片（BufferedImage 继承自 Image）
//BufferedImage bufImage = ImageIO.read(File input);
//BufferedImage bufImage = ImageIO.read(URL input);
//BufferedImage bufImage = ImageIO.read(InputStream input);



//


    }
//    X:\JDBCMysql\DayForJavaSql\jpg\2b-nier_automata-swords-game-art-(1021).jpg
    public JIconsmall(){
    }

    public  static Image getBigImage(int i) {//获得图片
         for(String x :  jpg){//初始化 list集合    不能在构造中初始化，因为构造最后调用
          Image image =  Toolkit.getDefaultToolkit().getImage("X:\\JDBCMysql\\DayForJavaSql\\jpg\\"+x.trim());//trim去除首尾空格
          bigImages.add(image);
      }
        return bigImages.get(i);
    }




    public static ImageIcon getIcon(int i){//图标，只有只有位置参数
            Image image =  getBigImage(i);
            Image smallImage = image.getScaledInstance(192,108,Image.SCALE_SMOOTH);
//            Image smallImage = image.getScaledInstance(1600,900,Image.SCALE_SMOOTH);
//    再由修改后的Image来生成合适的Icon
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





    public static ImageIcon geturlIconSetWH(String url,int width,int height){//设置图标大小
        Image image =  Toolkit.getDefaultToolkit().getImage(url.trim());//trim去除首尾空格

        Image smallImage = image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
//    再由修改后的Image来生成合适的Icon
        ImageIcon smallIcon = new ImageIcon(smallImage);
        return smallIcon;
    }




}
