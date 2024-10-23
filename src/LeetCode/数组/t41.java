package LeetCode.数组;

public class t41 {
    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     *
     * 示例 1：
     * 输入：nums = [1,2,0]
     * 输出：3
     * 解释：范围 [1,2] 中的数字都在数组中。
     *
     * 示例 2：
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * 解释：1 在数组中，但 2 没有。
     *
     * 示例 3：
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     * 解释：最小的正数 1 没有出现
     */
    
    
    // 方法1:hash表
    // public static int firstMissingPositive(int[] nums) {
    //     int n = nums.length;
    //     for(int i = 0;i < n;i++){
    //         if(nums[i] <= 0){
    //             nums[i] = n + 1;
    //         }
    //     }
    //     for(int i = 0;i < n;i++){
    //         int num = Math.abs(nums[i]);
    //         if(num <= n){
    //             nums[num - 1] = -Math.abs(nums[num - 1]);
    //         }
    //     }
    //     for(int i = 0;i < n;i++){
    //         if(nums[i] > 0){
    //             return i+1;
    //         }
    //     }
    //     return n+1;
    // }
    
    // 方法2:置换
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((i + 1) != nums[i]) {
                return i + 1;
            }
        }
        return n + 1;
    }
    
    
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 2, 2};
        System.out.println(firstMissingPositive(nums));
    }
}
