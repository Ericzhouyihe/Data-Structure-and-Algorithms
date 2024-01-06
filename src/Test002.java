import java.util.Scanner;

public class Test002 {
   /*
    给定两个整数，被除数和除数（都是正数，且不超过int的范围）
    要求得到两数相除的商和余数，不能使用乘法，除法和%运算符
    */
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("请输入被除数：");
      int dividend= sc.nextInt();
      System.out.println("请输入除数：");
      int divisor= sc.nextInt();
      int count=0;
      while (dividend>=divisor){
         dividend-=divisor;
         count++;
      }
      System.out.println("商为："+count);
      System.out.println("余数为："+dividend);
   }
}
