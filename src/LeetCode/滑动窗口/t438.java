package LeetCode.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/25 09:48
 * @description
 */
public class t438 {
    
    // 优化速度
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int slen = s.length();
        int plen = p.length();
        int[] count = count(p, 0, plen - 1);
        int[] count1 = count(s, 0, plen - 2);
        for (int i = 0; i <= slen - plen; i++) {
            ++count1[s.charAt(i + plen - 1) - 'a'];
            if (Arrays.equals(count, count1)) {
                res.add(i);
            }
            --count1[s.charAt(i) - 'a'];
        }
        return res;
    }
    
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int slen = s.length();
        int plen = p.length();
        int[] count = count(p, 0, plen - 1);
        for (int i = 0; i <= slen - plen; i++) {
            int[] count1 = count(s, i, i + plen - 1);
            // 自定义比较是否相等的方法
            // if (isSame(count, count1)) {
            //     res.add(i);
            // }
            // 使用Arrays.equals()方法
            if (Arrays.equals(count, count1)) {
                res.add(i);
            }
        }
        return res;
    }
    
    
    public int[] count(String s, int start, int end) {
        int[] res = new int[26];
        for (int i = start; i <= end; i++) {
            res[s.charAt(i) - 'a']++;
        }
        return res;
    }
    
    private boolean isSame(int[] count, int[] count1) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != count1[i]) {
                return false;
            }
        }
        return true;
    }
}
