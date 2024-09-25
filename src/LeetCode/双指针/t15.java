package LeetCode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/19 22:24
 * @description
 */
public class t15 {
    
    /**
     * 给你一个整数数组 `nums` ，判断是否存在三元组 `[nums[i], nums[j], nums[k]]` 满足 `i != j`、`i != k` 且 `j != k` ，
     * 同时还满足 `nums[i] + nums[j] + nums[k] == 0` 。请你返回所有和为 `0` 且不重复的三元组。
     * <p>
     * **注意：**答案中不可以包含重复的三元组。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int right = n - 1;
            for (int left = i + 1; left < n; left++) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                while (left < right && nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
                if (left == right) {
                    break;
                }
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}