package Test;

import java.util.*;

/**
 * @author 周益和
 * @ClassName test1
 * @qq 1552951165
 */
public class test5 {
    public static  Map<String,Double> solution(Map<String,List<Integer>> map){
        Map<String,Double> averages = new HashMap<>();
        
        for (Map.Entry<String,List<Integer>> entry : map.entrySet()){
            List<Integer> score = entry.getValue();
            double average = score.stream().mapToInt(Integer::intValue).average().orElse(0);
            averages.put(entry.getKey(),average);
        }
       
        return averages;
    }
    
    public static void main(String[] args) {
        Map<String,List<Integer>> map = new LinkedHashMap<>();
        map.put("John",List.of(85,90,95));
        map.put("Bob",List.of(80,85,90));
        map.put("Alice",List.of(95,100,105));
        
        Map<String,Double> newMap = solution(map);
        System.out.println("newMap = " + newMap);
    }
}
