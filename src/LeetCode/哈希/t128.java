package LeetCode.哈希;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 21:51
 * @description:
 */
public class t128 {
    /**
     * 最长连续序列
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列(不要求序列元素在原数组中连续)的长度。
     * 请你设计并实现时间复杂度为0(n)的算法解决此问题。
     */
    
    
    // hash表的方法
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int count = 0;
        int res = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {// 不存在前一个,则这个数为序列的头
                count = 1;
                int temp = i;
                while (set.contains(temp + 1)) {// 存在下一个,则这个数为序列中间的数
                    temp++;
                    count++;
                }
                // 结束了上面到了最后一个数
                res = Math.max(res, count);
            }
        }
        return res;
    }
    
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int count = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 0) {
                // 重复元素 不操作
            } else if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
