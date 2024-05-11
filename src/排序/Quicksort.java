package 排序;

import java.util.Arrays;

/**
 * @author zhouyihe
 * @ClassName Sort
 * @qq 1552951165
 */
public class Quicksort {
    
    // 快速排序
    private static void quickSort1(int[] arr, int l, int r) {
        // l >= r 时直接return
        if (l >= r) return;
        int i = l;
        int j = r;
        int key = arr[l];
        while (i < j) {
            while (i < j && key <= arr[j])
                j--;
            if (i < j)
                arr[i++] = arr[j];
            
            while (i < j && key > arr[i])
                i++;
            if (i < j)
                arr[j--] = arr[i];
        }
        
        // i==j
        arr[i] = key;
        quickSort1(arr, l, i - 1);// 递归调用
        quickSort1(arr, i + 1, r);// 递归调用
        
    }
    
    private static void quickSort2(int[] arr, int l, int r){
    
    }
    
    
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,2,1,6,3};
        quickSort1(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);
        System.out.println("arr1 = " + Arrays.toString(arr));
        System.out.println("arr2 = " + Arrays.toString(arr));
    }
}
