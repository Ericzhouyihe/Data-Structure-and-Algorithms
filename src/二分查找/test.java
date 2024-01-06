package 二分查找;

import javax.xml.stream.FactoryConfigurationError;

/**
 * 简单的二分查找
 */
public class test {

    public static int binarySearch(int[] arr, int target){
        int L = 0;
        int R = arr.length - 1;
        while(L <= R){
            int mid = L + ((R - L ) >> 1);
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 1;
        int result = binarySearch(arr, target);
        System.out.println("result = " + result);
    }
}
