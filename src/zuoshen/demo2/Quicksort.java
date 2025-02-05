package zuoshen.demo2;

import java.util.Arrays;

/**
 * @author zhouyihe
 * @ClassName Quicksort
 * @qq 1552951165
 */
public class Quicksort {
    
    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    
    // arr[l...r]排好序
    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);    // < 区
            quickSort(arr, p[1] + 1, R);    // > 区
        }
    }
    
    // 这是处理一个arr[l...r]的函数
    // 默认以arr[r]做划分,arr[r] -> p
    // 返回等于区域(左边界,右边界),所以返回一个长度为2的数组res,res[0] res[1]
    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;   //< 区右边界
        int more = R;   //> 区左边界
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }
    
    // 两个数交换位置
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 1, 5, 8, 7, 6};
        quickSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        
        
    }
}