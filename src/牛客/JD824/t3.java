package 牛客.JD824;

import 回溯算法.Knapsack1;

import java.util.Scanner;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/10 20:41
 * @description
 */
public class t3 {
    /**
     * 有n根木棍排成一列,第i根木棍的长度为a;
     * 请你从中选出一个最长的子区间,使得区间内任意三根木棍都能构成三角形。只需要输出选出的区间端点即可。
     * 输入描述
     * 第一行一个整数n(3≤n≤106) , 表示木棍的数量。
     * 第二行n个整数，第i个整数a(1≤a≤109)表示第i根木棍的长度。
     *
     * 输出描述
     * 输出一行两个整数,表示最长的满足条件的区间的两个端点,如果有多个满足条件的区间,输出左端点最小的区间。保证答案存在。
     *
     * 示例
     * 输入
     * 3
     * 1 2 3
     * 输出
     * 1 2
     *
     * 输入
     * 9
     * 2 3 3 3 1 1 3 3 3
     * 输出
     * 1 4
     *
     * @param args
     */
    public static void slove(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (r < n) {
        
        }
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        slove(nums);
    }
}
