package Test;

import java.util.*;

/**
 * @author 周益和
 * @ClassName test1
 * @qq 1552951165
 */
public class test3 {
    public static Map<String,Integer> solution(List<String> list){
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String str : list){
            map.put(str,map.getOrDefault(str,0) + 1 ) ;
        }
        return map;
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");
        list.add("banana");
        list.add("grape");
        list.add("grape");
        
        Map<String,Integer> newMap = solution(list);
        System.out.println("newMap = " + newMap);
    }
}
