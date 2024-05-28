package 字符串;

/**
 * @author 周益和
 * @ClassName t
 * @qq 1552951165
 */
public class t392 {
    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.equals("")) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (n == -1) {
                return false;
            }
            n = search(s.charAt(i), t, n);
        }
        return true;
    }
    
    public static int search(char c, String t, int index) {
        for (; index < t.length(); index++) {
            if (c == t.charAt(index)) {
                return index;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        String s = "b";
        String t = "c";
        System.out.println(isSubsequence(s, t));
    }
    
}
