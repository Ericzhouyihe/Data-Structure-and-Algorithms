package LeetCode.数组;

/**
 * @ClassName t
 * @author: 周益和
 * @qq: 1552951165
 * @date: 2024/7/25
 * @description:
 */
/*
*  45. 跳跃游戏 II
*  */
public class t45 {
    
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums)); // 2
    }
    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
