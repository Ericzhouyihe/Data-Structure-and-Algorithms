package LeetCode.哈希;

import java.util.HashMap;

/**
 * @ClassName t1
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 2024/9/8
 * @description:
 */
public class t1 {
    /*
     * 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     *  */
    
    /*
     * 题目分析:
     * 1. 为了覆盖所有的结果路径，所以需要依次检查所有的元素
     * 2. 针对对应已选定的元素，尝试在输入中寻找与所选数字求和等于目标值的数字
     *
     * 暴力解:直接使用循环来多次遍历全部组合。
     * 哈希解:利用特别的数据结构来省略
     *  */
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int choose = nums[i];
            int diff = target - choose;
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(choose, i);
        }
        return nums;
    }
}
