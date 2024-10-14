package LeetCode.子串;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/9 19:38
 * @description
 */
public class t239 {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     * <p>
     * 示例 1：
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * <p>
     * 示例 2：
     * 输入：nums = [1], k = 1
     * 输出：[1]
     */
    // 双端队列速度优化
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            // 当双端队列不为空且队列头部元素小于当前数组元素时，移除队列头部元素
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i]){
                deque.poll();
            }
            // 将当前数组元素的索引添加到队列尾部
            deque.push(i);
            // 当队列头部元素的索引超出窗口范围时，移除队列头部元素
            if (i >= k){
                if (deque.peekLast() <= i - k){
                    deque.pollLast();
                }
            }
            // 当窗口达到指定大小时，将当前窗口内的最大值记录到结果数组中
            if (i >= k - 1){
                res[i - k + 1] = nums[deque.peekLast()];
            }
        }
        return res;
    }
    
    //  双端队列解法
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     ArrayDeque<Integer> deque = new ArrayDeque<>();
    //     int n = nums.length;
    //     int[] res = new int[n - k + 1];
    //     int idx = 0;
    //     // 遍历数组元素，寻找每个窗口的最大值
    //     for (int i = 0; i < n; i++) {
    //         // 如果队列不为空，且队首元素不在当前窗口内，则移除队首元素
    //         while (!deque.isEmpty() && deque.peek() < i - k + 1) {
    //             deque.poll();
    //         }
    //         // 如果队列不为空，且队尾元素小于当前元素，则移除队尾元素,如果都比当前值小则移除到队列为空
    //         while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
    //             deque.pollLast();
    //         }
    //         // 将当前元素的索引加入队列
    //         deque.offer(i);
    //         // 如果当前元素已在窗口内，则将队首元素加入结果数组
    //         if (i >= k - 1){
    //             res[idx++] = nums[deque.peek()];
    //         }
    //     }
    //
    //     return res;
    // }
    
    // 超时了
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if (k == 1){
    //         return nums;
    //     }
    //     int n = nums.length;
    //     int currMax = Integer.MIN_VALUE;
    //     if (n < k) {
    //         for (int num : nums) {
    //             currMax = num > currMax ? num : currMax;
    //         }
    //         return new int[]{currMax};
    //     }
    //     int[] maxNum = new int[n - k + 1];
    //     for (int i = 0; i < k; i++) {
    //         if (nums[i] > currMax) {
    //             currMax = nums[i];
    //         }
    //     }
    //     maxNum[0] = currMax;
    //     int left = 1;
    //     int right = k;
    //     while (right < n){
    //         if (nums[right] > currMax) {
    //             currMax = nums[right];
    //         }
    //         if (nums[left - 1] == currMax) {
    //             currMax = Integer.MIN_VALUE;
    //             for (int i = left; i <= right; i++) {
    //                 if (nums[i] > currMax) {
    //                     currMax = nums[i];
    //                 }
    //             }
    //         }
    //         maxNum[left] = currMax;
    //         left++;
    //         right++;
    //     }
    //     return maxNum;
    // }
    
    
}
