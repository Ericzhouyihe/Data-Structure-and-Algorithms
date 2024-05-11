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
public class test4 {
    public static void solution(List<String> list,List<String> numbersList,List<String> abcdList){
        for(String str : list){
            if (str.matches("\\d+")){
                numbersList.add(str);
            }else if (str.matches("\\D+")){
                abcdList.add(str);
            }
        }
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("abc");
        list.add("456");
        list.add("def");
        list.add("789");
        list.add("ghi");
        
        List<String> numbersList = new ArrayList<String>();
        List<String> abcdList = new ArrayList<String>();
        
        solution(list,numbersList,abcdList);
        
        System.out.println("numbersList = " + numbersList);
        System.out.println("abcdList = " + abcdList);
    }
}
