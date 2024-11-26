package java编程问题.一字符串数字和数学;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/15 22:51
 * @description
 */
public class t1 {
    /**
     * 统计重复的字符串数量
     */
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(countRepeat(s));
    }
    
    // hashmap记录字符出现的次数
    private static int countRepeat(String s) {
        int result = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return result;
    }
}
