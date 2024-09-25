package LeetCode.哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName t49
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 2024/9/8
 * @description:
 */
public class t49 {
    /*
     * 字母异位词分组
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词，
     *  */
    
    // 哈希表--排序法
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    
    // 哈希表--计数法(记录每个字母出现的次数)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Word, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Word w = new Word(str);
            if (map.containsKey(w)) {
                map.get(w).add(str);
            } else {
                List<String> s = new ArrayList<>();
                s.add(str);
                map.put(w, s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
    
    class Word {
        int[] counts;
        
        Word(String s) {
            final char[] chars = s.toCharArray();
            counts = new int[26];
            for (char c : chars) {
                int index = c - 'a';
                counts[index]++;
            }
        }
        public boolean equals(Object o) {
            return Arrays.equals(counts, ((Word) o).counts);
        }
        public int hashCode() {
            return Arrays.hashCode(counts);
        }
    }
}
