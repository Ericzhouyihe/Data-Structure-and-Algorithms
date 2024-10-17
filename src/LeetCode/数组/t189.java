package LeetCode.数组;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/17 20:56
 * @description
 */
public class t189 {
    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     *
     * 示例 2:
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     *
     */
    // public void rotate(int[] nums, int k) {
    // int n = nums.length;
    // if (n <= 1) {
    // return;
    // }
    // k = k % n;
    // reverse(nums, 0, nums.length - 1);
    // reverse(nums, 0, k - 1);
    // reverse(nums, k, nums.length - 1);
    // }
    
    // public void reverse(int[] nums, int left, int right) {
    // int n = right - left + 1;
    // for (int i = 0; i < n / 2; i++) {
    // int temp = nums[left + i];
    // nums[left + i] = nums[right - i];
    // nums[right - i] = temp;
    // }
    // }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
