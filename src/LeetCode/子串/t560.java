package LeetCode.子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/25 14:42
 * @description
 */
public class t560 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * 子数组是数组中元素的连续非空序列。
     * <p>
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     * <p>
     * 提示：
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n];
        int count = 0;
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            count += map.getOrDefault(sums[i] - k,0);
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        
        return count;
    }
}
