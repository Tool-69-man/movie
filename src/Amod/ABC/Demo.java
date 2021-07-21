package Amod.ABC;

import java.util.Scanner;

public class Demo{
    public static void main(String[] arg){
        //输入
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        //星号
        //i<n i+=2
        int i=0;
        for( i=1;i<n-1;i++){
            for (int j=1;j<n-i;j++){
                System.out.print(" ");
            }
            if (i==n-2){
                System.out.println("n........");
                for (int i2=i-1;i2>0;i2--){
                    for(int j=0;j<=i-i2;j++){
                        System.out.print(" ");
                    }
                    for (int j=1;j<i2*2;j++){
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                return;
            }
            for(int j=1;j<i*2;j++){
                System.out.print("*");
            }
            System.out.println();
        }//

    }


}