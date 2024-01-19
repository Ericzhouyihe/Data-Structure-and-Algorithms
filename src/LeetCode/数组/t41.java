package LeetCode.数组;

public class t41 {
    //方法1:hash表
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

    //方法2:置换
    public static int firstMissingPositive(int[] nums) {
            int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        for(int i = 0;i < n;i++){
            if(nums[i] <= n){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i] ;
                nums[i] = temp;
            }
        }
        for(int i = 0;i < n;i++){
            if((i+1) != nums[i]){
                return i+1;
            }
        }
        return n+1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
