package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 周益和
 * @ClassName test1
 * @qq 1552951165
 */
public class test6 { public static Map<String,String> solution(List<String> list){
    Map<String,String> map = new HashMap<String,String>();
    for (String str:list){
        String[] parts = str.split("\\s*,\\s*");
        if(parts.length == 2){
            map.put(parts[1],parts[0]);
        }
    }
    return map;
}
   
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("John Doe,john@doe.com");
        list.add("Bob Smith,bob@smith.com");
        list.add("Alice Johnson,alice@johnson.com");
        
        Map<String,String> map = solution(list);
        
        System.out.println("map = " + map);
    }
}
