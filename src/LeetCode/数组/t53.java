package LeetCode.数组;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/14 22:33
 * @description
 */
public class t53 {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组是数组中的一个连续部分。
     * <p>
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * <p>
     * 示例 2：
     * 输入：nums = [1]
     * 输出：1
     * <p>
     * 示例 3：
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE; // 记录到目前为止的最优解
        int curr = 0; // 记录到目前为止的和
        for (int num : nums) {
            curr = curr > 0 ? curr + num : num;
            res = Math.max(res, curr);
        }
        
        return res;
    }
    
}
