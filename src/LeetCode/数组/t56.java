package LeetCode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/14 22:57
 * @description
 */
public class t56 {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     *
     * 示例 1：
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 示例 2：
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(item -> item[0]));
        List<int[]> resList = new ArrayList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int currL = intervals[i][0];
            int currR = intervals[i][1];
            if (currL <= r){
                r = Math.max(r, currR);
            } else {
                int[] save = new int[2];
                save[0] = l;
                save[1] = r;
                resList.add(save);
                l = currL;
                r = currR;
            }
        }
        int[] save = new int[2];
        save[0] = l;
        save[1] = r;
        resList.add(save);
        
        int resLength = resList.size();
        int[][] res = new int[resLength][2];
        for (int i = 0; i < resLength; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
