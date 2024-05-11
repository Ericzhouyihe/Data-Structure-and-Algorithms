package Test;

import java.util.*;

/**
 * @author 周益和
 * @ClassName test1
 * @qq 1552951165
 */
public class test2 {
    public static List<String> solution(Map<String,Integer> map){
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        List<String> names = new ArrayList<>();
        for(int i = 0; i < Math.min(3,list.size()); i++){
            names.add(list.get(i).getKey());
        }
        return names;
    }
    
    public static void main(String[] args) {
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        map.put("John",35);
        map.put("Bob",40);
        map.put("Alice",30);
        map.put("Tom",45);
        map.put("Jerry",50);
        
        List<String> newList = solution(map);
        System.out.println("newList = " + newList);
    }
}
