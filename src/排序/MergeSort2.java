package 排序;

import java.util.Arrays;

/**
 * 归并排序
 * 非递归实现
 */
public class MergeSort2 {
    //非递归方法实现
    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        //设置每次的组长
        int step = 1;
        //标志排序结束的位置
        int N = arr.length;
        while (step < N) {
            //L为左组开始的索引
            int L = 0;
            while (L < N) {
                //记录每个左组右组的中间索引值M
                int M = 0;
                //算出L到数组最后还有多少个数,
                //看这些数是否能组成一个完整的左组,没有就将剩的数都当左组
                if (N - L >= step) {
                    M = L + step - 1;
                }else {
                    M = N - 1;
                }

                //当M到数组尾部时,最后一个左组没有相应的右组,该左组不参与此次排序
                if(M == N -1) {
                    break;
                }

                //一个左组算完,开始算对应的右组
                //R为右组开始的索引
                int R = 0;
                //判断是否有足够的数组成完整的右组,没有就将剩的数都当右组
                if(N - 1 - M >= step) {
                    R = M + step;
                }else {
                    R = N - 1;
                }

                //左右组进行一次排序
                merge(arr,L,M,R);

                //如果R == N-1(即arr.length-1),那么下一个左组的L=R+1=N=arr.length就越界了
                if(R == N -1) {
                    break;
                }else {
                    L = R + 1;
                }
            }

            //为了防止出现溢出
            if(step > N/2) {
                break;
            }

            //步长按1,2,4,8,16...扩大,可以加快排序速度
            step *= 2;
        }
    }

    public static void merge(int[] arr, int L, int M, int R) {

        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while(p1 <= M && p2 <= R ) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++]:arr[p2++];
        }

        while(p1 <= M) {
            help[i++] = arr[p1++];
        }

        while(p2 <= R) {
            help[i++] = arr[p2++];
        }

        for(i = 0;i < help.length;i++) {
            arr[L+i] = help[i];
        }
    }


    //计数器和测试方法

    // for test
    public static int[] generateRanNomArray(int maxSize, int maxValue) {
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

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRanNomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
