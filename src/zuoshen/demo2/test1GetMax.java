package zuoshen.demo2;

import java.util.Arrays;

/**
 * @author 周益和
 * @ClassName test1GetMax
 * @qq 1552951165
 */
public class test1GetMax {
    /**
     * 对数器
     *
     */
    // for test
    public static int comparator(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-1];
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
            // 自己写的插入排序的算法,修改算法也可以改这里
            int res = getMax(arr1);
            int right = comparator(arr2); // Arrays.sort();
            if(!(res == right)){
                printArray(arr2);
                // 打印arr1
                System.out.println("res = " + res);
                // 打印arr2
                System.out.println("right = " + right);
                return false;
            }
        }
        return true;
    }
    
    
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
        int testTime = 500000;  // 测试50万次
        int maxSize = 100;      // 最大数组长度
        int maxValue = 100;      // 最大
        boolean result = isSucceed(testTime, maxSize, maxValue);
        // 输出测试结果
        System.out.println(result ? "Nice":"Fucking fucked!");
    }
    
}
