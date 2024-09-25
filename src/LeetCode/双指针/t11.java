package LeetCode.双指针;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/19 22:02
 * @description
 */
public class t11 {
    /**
     *
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l + 1));
            if (height[l] < height[r]) {
                l++;
            }else {
                r--;
            }
        }
        return area;
    }
}
