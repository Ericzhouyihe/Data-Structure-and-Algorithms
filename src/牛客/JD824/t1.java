package 牛客.JD824;

import java.util.Scanner;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/10 20:26
 * @description
 */
public class t1 {
    /**
     * 输入只一个n（-10100 <= n <= 10100）,输出0 ～ n有多少个数是100的倍数。
     */
    private static int slove(int n) {
        int res = 0;
        // for (int i = 1; i <= n; i++) {
        //     if (i % 100 == 0) {
        //         res++;
        //     }
        // }
        int num = 0;
        if (n > 0){
            num = 100;
            while (num <= n) {
                res++;
                num += 100;
            }
        }else {
            num = -100;
            while (num >= n) {
                res++;
                num -= 100;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(slove(n));
    }
    
    
}
