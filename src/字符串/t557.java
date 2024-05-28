package 字符串;

import java.util.Arrays;

/**
 * @author 周益和
 * @ClassName t557
 * @qq 1552951165
 */
public class t557 {
    public static String solution(String s){
        String result = "";
        for (String str : s.split(" ")) {
            result += reverse(str) + " ";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
    
    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            chars[left] = (char) (chars[left] ^ chars[right]);
            chars[right] = (char) (chars[left] ^ chars[right]);
            chars[left] = (char) (chars[left] ^ chars[right]);
        }
        return String.valueOf(chars);
    }
    
    public static void main(String[] args) {
        String s = "hello world";
        s = solution(s);
        System.out.println("string = " + s);
    }
    
    
}
