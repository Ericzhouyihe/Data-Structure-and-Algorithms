package 牛客.duoyi;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/9 20:32
 * @description
 */
public class t1 {
    /**
     * 全是1,-1的数组,求最长 >0 的序列
     */
    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,1,1};
        
        System.out.println(solve(nums));
    }
    
    // 动态规划就行了
    
    /**
     * 当右指针移动到某一个位置的时候,比较当前的和 + 此位置的数 是否 >0
     * 若 >0 更新最大长度和最大和
     * <0 时 考虑相加后是否比原来大,如果比原来大就继续加后面的数,比原来小则左指针直接移到右指针位置开始新的计算
     * @param nums
     * @return
     */
    private static int solve(int[] nums) {
        int curr = 0;
        int maxLen = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(curr + nums[right] > 0){
                curr += nums[right];
                right++;
                maxLen = Math.max(maxLen, right - left);
            }else {
            
            }
        }
        return maxLen;
    }
}
