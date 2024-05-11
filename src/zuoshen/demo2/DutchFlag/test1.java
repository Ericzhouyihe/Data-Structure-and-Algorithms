package zuoshen.demo2.DutchFlag;

import java.util.Arrays;

/**
 * @author zhouyihe
 * @ClassName test1
 * @qq 1552951165
 */
public class test1 {
    /*
      问题
      给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的
      数放在数组的右边。要求额外空间复杂度0(1)，时间复杂度0(N)
     */
    private static void method(int[] arr, int num) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (num > arr[j]) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
                i++;
            } else {
                j--;
            }
        }
    }
    
    /*
    问题二(荷兰国旗问题)
    给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放
    在数组的中间，大于num的数放在数组的 右边。要求额外空间复杂度0(1)，时间复杂度0(N)
    */
    private static void test(int[] arr, int num) {
        int l = -1;             // 左边界
        int r = arr.length;     // 右边界
        int i = 0;              // 索引
        while (i < arr.length - 1) {
            if (arr[i] < num) {
                if (i == l + 1) {
                    l++;
                } else {
                    swap(arr, i, ++l);
                }
                i++;
            } else if (arr[i] > num) {
                if (i == r - 1) {
                    r--;
                } else {
                    swap(arr, i, --r);
                }
            } else {
                i++;
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    
    
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 8, 1, 2, 3, 5};
        method(arr, 4);
        System.out.println("arr1 = " + Arrays.toString(arr));
        test(arr, 2);
        System.out.println("arr2 = " + Arrays.toString(arr));
    }
    
}
