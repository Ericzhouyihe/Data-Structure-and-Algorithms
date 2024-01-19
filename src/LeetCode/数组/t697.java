package LeetCode.数组;

import java.util.ArrayList;
import java.util.List;

public class t697 {
    public static int findShortestSubArray(int[] nums) {
        int[] help = new int[50000];
        int degree = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int length = 0;
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0;i < nums.length;i++){
            help[nums[i]]++;
        }
        for(int i = 0;i < help.length;i++){
            if(help[i] >= degree){
                degree = help[i];
                numbers.add(i);
            }
        }
        for(int num:numbers){
            for(int i = 0;i < help.length;i++){
                if(help[i] == num){
                    length = i - length;
                    if(length < minLength){
                        minLength = length;
                    }
                }
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1};
        System.out.println(findShortestSubArray(nums));
    }
}
