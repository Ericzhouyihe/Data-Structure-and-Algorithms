package LeetCode.双指针;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/19 16:50
 * @description
 */
public class t283 {
    /**
     * 给定一个数组 `nums`，编写一个函数将所有 `0` 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * 示例 1:
     *     输入: nums = [0,1,0,3,12]
     *     输出: [1,3,12,0,0]
     * 示例 2:
     *     输入: nums = [0]
     *     输出: [0]
     *
     * @param nums
     */
    
    
    /**
     * 双指针,一次遍历
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0,count = nums.length;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if(index < i){
                nums[index] = nums[i];
            }
            index++;
        }
        for (int i = index; i < count; i++) {
            nums[i] = 0;
        }
    }
}
