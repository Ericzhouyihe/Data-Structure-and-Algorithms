import java.util.Scanner;

public class Test001 {
    /*
    给一个数判断是否是回文数(正序和倒序读出来是一样的数字)
    是回文数输出true，不是输出false
    */

//    思路：先得出回文数再和原数进行比较
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数：");
        int input=sc.nextInt();
        int x=input;
        int num=0;
        while (input!=0){
            int data=input%10;
            input/=10;
            num=num*10+data;
        }
      // System.out.println(num);//此数是元素的倒序输出的数
        System.out.println("输入的数是否是回文数："+(x == num));
    }

}
