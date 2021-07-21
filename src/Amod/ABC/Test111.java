package Amod.ABC;

public class Test111 {

    private int a ;

    static{
        System.out.println("static");
    }

    public Test111(){

        a = 22;

        System.out.println("构造");
    }


    public static void asd(){
        System.out.println("asf");
    }

    public static void main(String[] args) {
        asd();
        new Test111();

        try{

            Class.forName("swinglearn.Test111");

        }catch(Exception e){

        }


    }

}
