package zuoshen.demo2;

import java.util.Arrays;

/**
 * @author 周益和
 * @ClassName test1GetMax
 * @qq 1552951165
 */
public class test1GetMax {
    // 二分的方式求最大值
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);   // 中点
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
    
    public static void main(String[] args) {
    
    }
    
}
