package LeetCode.子串;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/9 22:42
 * @description
 */
public class t76 {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * <p>
     * 示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     * <p>
     * 示例 2：
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 解释：整个字符串 s 是最小覆盖子串。
     * <p>
     * 示例 3:
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     */
    // 超时了
    // public static String minWindow(String s, String t) {
    //     int left = 0;
    //     int right = t.length() - 1;
    //     String res = "";
    //     while (right < s.length()) {
    //         String substring = s.substring(left, right + 1);
    //         while (has(count(substring), count(t))) {
    //             if (res.equals("") || substring.length() < res.length()) {
    //                 res = substring;
    //             }
    //             substring = s.substring(left + 1, right + 1);
    //             left++;
    //         }
    //         right++;
    //     }
    //
    //     return res;
    // }
    public static String minWindow(String s, String t) {
        int[] counts = new int[256];
        int[] target = count(t);
        int left = 0;
        int right = -1;
        
        int maxL = 0;
        int maxR = Integer.MAX_VALUE;
        
        while (left < s.length()) {
            if (has(counts, target)) {
                if (right - left < maxR - maxL) {
                    maxR = right;
                    maxL = left;
                }
                counts[s.charAt(left++)]--;
            } else {
                if (right == s.length() - 1) {
                    break;
                }
                counts[s.charAt(++right)]++;
            }
        }
        return maxR == Integer.MAX_VALUE ? "" : s.substring(maxL, maxR + 1);
    }
    
    static int[] count(String s) {
        int[] counts = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            counts[c]++;
        }
        return counts;
    }
    
    static boolean has(int[] s, int[] t) {
        for (int i = 0; i < 256; i++) {
            if (s[i] < t[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // String s = "ADOBECODEBANC";
        // String t = "ABC";
        // System.out.println(minWindow(s, t)); // BANC
        // System.out.println(minWindow(s, t).equals("BANC")); // BANC
        // System.out.println("-----------------------------");
        String s1 = "cabwefgewcwaefgcf";
        String t1 = "cae";
        System.out.println(minWindow(s1, t1)); // aa
        System.out.println(minWindow(s1, t1).equals("cwae")); // aa
    }
}
