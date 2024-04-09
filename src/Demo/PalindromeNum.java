package Demo;

import java.util.Scanner;

/*
判断一个整数是不是回文数
找出从1(>=1)开始的第1100个回文数
*/
public class PalindromeNum {


    public static void main(String[] args){
        int count = 0;
        int res = 0;
        for (int i = 1 ; i < Integer.MAX_VALUE ; i++){
            if (isPalindromeNum(i)) {
                count++;
            }
            if (count == 1100){
                res = i;
                break;
            }
        }
        System.out.println("第1100个回文数是 : " + res);
    }

    private static boolean isPalindromeNum(int number) {
        int temp = number;          //记录number的值
        int n = 0;                  //反转数字

        while(number!=0){
            int num = number%10;    //获取最后一位
            n = n*10+num;           //将刚获取到的数拼到最右边
            number = number/10;
        }

        if(n == temp){
            return true;
        }else{
            return false;
        }
    }
}
