package LeetCode.滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/20 14:49
 * @description
 */
public class t3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                left++;
                set.remove(s.charAt(left - 1));
            }
            set.add(s.charAt(right));
            right++;
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }
}
