package zuoshen.demo1;

import java.util.Arrays;

/**
 * @author 周益和
 * @ClassName LogarithmicDevice
 * @qq 1552951165
 */
public class LogarithmicDevice {
   
    
    
    
    /**
     * 对数器
     *
     */
    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    
    //for test
    public static int[] generateRandomArray(int maxSize,int maxValue){
        // Math.random -> [0,1) 所有的小数,等概率返回一个
        // Math.random * N  -> [0,N) 所有的小数,等概率返回一个
        // (int)(Math.random * N)  ->  [0,N-1] 所有的整数,等概率返回一个
        
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
    
    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    
    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * for Test
     * 进行数组对比的操作
     */
    private static boolean isSucceed(int testTime, int maxSize, int maxValue) {
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            // 自己写的插入排序的算法,修改算法也可以改这里
            insertionSort(arr1);
            comparator(arr2); // Arrays.sort();
            if(!isEqual(arr1,arr2)){
                printArray(arr3);
                // 打印arr1
                printArray(arr1);
                // 打印arr2
                printArray(arr2);
                return false;
            }
        }
        return true;
    }
    
    // 算法
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }
    
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    
    public static void main(String[] args) {
        int testTime = 500000;  // 测试50万次
        int maxSize = 100;      // 最大数组长度
        int maxValue = 100;      // 最大
        boolean result = isSucceed(testTime, maxSize, maxValue);
        // 输出测试结果
        System.out.println(result ? "Nice":"Fucking fucked!");
    }
    
}
