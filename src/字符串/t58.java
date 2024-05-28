package 字符串;

import java.util.Arrays;

/**
 * @author 周益和
 * @ClassName t58
 * @qq 1552951165
 */
public class t58 {
    
    public static void main(String[] args) {
        String s = "hello world";
        String[] s1 = s.split(" ");
        int res = s1[s1.length - 1].length();
        
        System.out.println("res = " + res);
        
        char[] c = s.toCharArray();
        for(int left = 0,right = c.length - 1;left<right;left++,right--){
            char temp= c[right];
            c[right] = c[left];
            c[left] = temp;
        }
        String string = Arrays.toString(c);
        System.out.println("string = " + string);
    }
}
