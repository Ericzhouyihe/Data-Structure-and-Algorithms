package LeetCode.动态规划;

/**
 * @author 周益和
 * @ClassName t740
 * @qq 1552951165
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 删除并获得点数
 *
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class t740 {
    /*
     * 动态规划
     */
    public static int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        // 求数组中的最大值
        for(int val:nums){
            maxVal = Math.max(maxVal,val);
        }
        // 创建一个索引值对应数值的数组
        int[] sum = new int[maxVal + 1];
        // 计算索引对应位置值的总和--将所有相同的值进行相加
        for(int val:nums){
            sum[val] += val;
        }
        return rob(sum);
    }
    // 前面进行了按数的大小结合,后面进行动态规划的打家劫舍就行了
    public static int rob(int[] nums){
        int size = nums.length;
        // 按打家劫舍的动态规划来写,得先写出第一个数,第二个的数的值,再进行后续的动态规划
        int first = nums[0];
        int second = Math.max(nums[0],nums[1]);
        for(int i = 2;i<size;i++){
            int temp = second;
            second = Math.max(first + nums[i],second);
            first = temp;
        }
        return second;
    }
    
    
    // 排序+动态规划
    public static int deleteAndEarn1(int[] nums){
        int n = nums.length;
        int ans = 0;
        // 对数组排序
        Arrays.sort(nums);
        // 创建集合对数进行统计
        List<Integer> sum = new ArrayList<>();
        // 添加第一个数
        sum.add(nums[0]);
        int size = 1;
        for (int i = 1; i < n; ++i) {
            int val = nums[i];
            if (val == nums[i - 1]) {// 数组中的数和前一个数相等的情况下
                // 将前一个数的位置的数据再加上val(也就是相同的数加到一起)
                sum.set(size - 1, sum.get(size - 1) + val);
            } else if (val == nums[i - 1] + 1) {// 数组中的数是前一个数+1的时候
                // 在集合中添加这个数
                sum.add(val);
                // 集合的场地增加
                ++size;
            } else {// 不是这两种情况,即后面要么没数,要么后面的数和之前的数不相邻了,不影响前面的最大值结果
                // 求前面的最大值
                ans += rob1(sum);
                // 清空列表
                sum.clear();
                // 记录新的数
                sum.add(val);
                // 设置集合的长度
                size = 1;
            }
        }
        // 运行完之后,再运行最后一次求最大的操作后做加法加上
        ans += rob1(sum);
        return ans;
    }
    public static int rob1(List<Integer> nums) {
        // 集合的长度
        int size = nums.size();
        if (size == 1) {
            return nums.get(0);
        }
        // 打家劫舍的动态规划计算
        int first = nums.get(0), second = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums.get(i), second);
            first = temp;
        }
        return second;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        System.out.println(deleteAndEarn(nums));
        int[] nums1 = {2,2,3,3,3,4};
        System.out.println(deleteAndEarn(nums1));
        
        System.out.println(deleteAndEarn1(nums));
        System.out.println(deleteAndEarn1(nums1));
    }
}
