package 动态规划;

/**
 * 最大字段和
 */
public class MaxSubArray {
   public static int maxSum(int[] a, int n) {
        // 定义一个变量sum用于存储最大和
        int maxSum = 0;
        // 定义一个变量b用于存储当前和
        int cs = 0;

        // 遍历数组a
        for (int i = 0; i < n; i++) {
            if (cs + a[i] < a[i]) {
                cs = a[i];
            // 否则b等于当前元素a[i]
            } else {
                cs += a[i];
            }

            // 如果b大于sum，则sum等于b
            if (cs > maxSum) {
                maxSum = cs;
            }
        }
        // 返回最大和
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {-2, 11, -4, 13, -5, -2,6};

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("数组a的最大连续子段和为：" + maxSum(a, a.length));
    }
}
