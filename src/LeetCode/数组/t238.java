package LeetCode.数组;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/17 21:09
 * @description
 */
public class t238 {
    /**
     * 给你一个整数数组 nums，返回数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * <p>
     * 示例 2:
     * 输入: nums = [-1,1,0,-3,3]
     * 输出: [0,0,9,0,0]
     */
    
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        nums[0] = right[1];
        nums[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            nums[i] = left[i - 1] * right[i + 1];
        }
        
        return nums;
    }
}
