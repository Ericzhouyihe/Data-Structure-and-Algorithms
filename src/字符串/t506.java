package 字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 周益和
 * @ClassName t506
 * @qq 1552951165
 */
public class t506 {
    public static String[] findRelativeRanks(int[] score) {
        int len = score.length;
        int[] sortArr = Arrays.copyOf(score, len);
        Arrays.sort(sortArr);
        Map<Integer,Integer> map = new HashMap<>();
        int ranking = 1;
        for(int i = len - 1;i >= 0;i--){
            map.put(sortArr[i],ranking++);
        }
        String[] res = new String[len];
        for(int i = 0 ;i < len;i++){
            if(map.get(score[i]) == 1){
                res[i] = "Gold Medal";
            }else if(map.get(score[i]) == 2){
                res[i] = "Silver Medal";
            }else if(map.get(score[i]) == 3){
                res[i] = "Bronze Medal";
            }else{
                res[i] = String.valueOf(map.get(score[i]));
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] data = {5,4,3,2,1};
        String[] relativeRanks = findRelativeRanks(data);
        System.out.println("relativeRanks = " + Arrays.toString(relativeRanks));
    }
}
