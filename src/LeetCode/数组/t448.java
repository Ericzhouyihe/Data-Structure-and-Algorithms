package LeetCode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int  n = nums.length;
        List<Integer> numsList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0,num = 1; i < n; i++) {
            while (num < nums[i]){
                numsList.add(num++);
            }
            if (num == nums[i] ){
                num++;
            }else if(num > nums[i]) {
                if ((i + 1) ==  n){
                    while(num <= n){
                        numsList.add(num++);
                    }
                }else{
                    continue;
                }
            }
        }
        return numsList;
    }

    //暴力解法--超时了
    //public static List<Integer> findDisappearedNumbers(int[] nums) {
    //    int  n = nums.length;
    //    List<Integer> numsList = new ArrayList<>();
    //    for(int i = 0 ; i < n ; i++){
    //        numsList.add(i+1);
    //    }
    //    for(int i = 0;i < n;i++){
    //        numsList.remove((Object)nums[i]);
    //    }
    //    return numsList;
    //}

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,7,2,3,1};//1 2 2 3 3 4 7 8
        System.out.println(findDisappearedNumbers(nums));
    }
}
