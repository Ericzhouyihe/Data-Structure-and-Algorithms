package 字符串;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 周益和
 * @ClassName t389
 * @qq 1552951165
 */
public class t389 {
    
    public static void main(String[] args) {
        char theDifference1 = findTheDifference1("a", "aa");
        char theDifference2 = findTheDifference2("a", "aa");
        char theDifference3 = findTheDifference3("a", "aa");
        System.out.println("theDifference1 = " + theDifference1);
        System.out.println("theDifference2 = " + theDifference1);
        System.out.println("theDifference3 = " + theDifference1);
    }
    
    // map
    public static char findTheDifference1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        // 遍历map，找出值为-1的key
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == -1) {
                return entry.getKey(); // 返回值为-1的key
            }
        }
        return 0;
    }
    
    // 数组
    public static char findTheDifference2(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }
    
    // 求和
    public static char findTheDifference3(String s, String t) {
        int as = 0,at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }
}
