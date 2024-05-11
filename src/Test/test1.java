package Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 周益和
 * @ClassName test1
 * @qq 1552951165
 */
public class test1 {
    public static List<String> solution(List<String> list){
        Set<String> set = new LinkedHashSet<String>(list);
        return new ArrayList<>(set);
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
        
        List<String> newList = solution(list);
        System.out.println("newList = " + newList);
    }
}
