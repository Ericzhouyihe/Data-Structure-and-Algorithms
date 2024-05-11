package 动态规划.字符串;

import java.util.IdentityHashMap;

/**
 * @author 周益和
 * @ClassName t5
 * @qq 1552951165
 */
public class t5 {
    /**
     * 求最长回文子串--暴力法
     */
    public static String longestPalindrome(String str){
        int len = str.length();
        if (len < 2){
            return str;
        }
        int maxLen = 1;
        int begin = 0;
        
        // 将字符串转换成char数组,会比charAt()快一点,这一步非必须
        char[] chars = str.toCharArray();
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len;j++){
                if (chars[i] == chars[j]){
                    if (j - i + 1 > maxLen && isPalindromic(chars,i,j)){
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return str.substring(begin,begin + maxLen);
    }
    
    public static boolean isPalindromic(char[] chars,int left,int right){
        while (left < right){
            if (chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    /**
     * 动态规划法
     * @param str
     * @return
     */
    public static String solution(String str){
        int len = str.length();
        if (len < 2){
            return str;
        }
        
        int maxLen = 1;
        int begin = 0;
        
        // dp[i][j]表示 s[i..j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        for(int i = 0;i < len;i++){
            dp[i][i] = true;
        }
        
        char[] chars = str.toCharArray();
        // 左下角先填
        for (int j = 1;j < len;j++){
            for (int i = 0;i < j;i++){
                if (chars[i] != chars[j] ) {
                    dp[i][j] = false;
                }else{
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                
                //
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return str.substring(begin,begin + maxLen);
    }
    
    
    
    public static void main(String[] args) {
        String str = "abab";
        // 记录开始时间
        long startTime = System.nanoTime();
        System.out.println(longestPalindrome(str));
        // 记录结束时间
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        
        startTime = System.nanoTime();
        System.out.println(solution(str));
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
