package zuoshen.demo1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 周益和
 * @ClassName test3InsertSort
 * @qq 1552951165
 */
public class test3InsertSort {
    // 插入排序
    public void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0-0有序的
        // 0-i想有序
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr,j,j+1);
            }
        }
    }
    // 交换方法
    public void swap(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    
    // 用来对比的
    public void comparator(int[] arr){
        Arrays.sort(arr);
    }
    
    @Test
    public void test1() {
        int[] arr1 = new int[]{2, 1, 5, 3, 4, 2};
        int[] arr2 = new int[]{2, 1, 5, 3, 4, 2};
        insertSort(arr1);
        comparator(arr2);
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }
}
