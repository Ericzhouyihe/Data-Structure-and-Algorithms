package 牛客.JD831;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/10 19:46
 * @description
 */
public class t2 {
    /**
     * 问题描述
     * LYA是一位图书馆管理员，她负责整理一排书架上的图书。书架上有n 本互不相同的书，每本书都有一个唯一的编号。
     * LYA希望将这些书按照编号从小到大排列，但她只能使用两种整理方法：
     * 1.选择相邻的两本书，交换它们的位置。
     * 2.选择相邻的三本书，将它们的顺序完全颠倒。
     * LYA发现，无论书架上的书如何排列，总是可以通过有限次上述操作将所有书排列成升序。
     * 然而，她注意到如果只使用第一种方法，整理过程会变得非常繁琐，就像冒泡排序一样低效。
     * 为了提高效率，LYA决定尽可能多地使用第二种方法，只在必要时才使用第一种方法。
     * 现在，她想知道在将所有书排列成升序的前提下，最少需要使用多少次第一种方法。
     * 样例输入
     * 4
     * 2
     * 4
     * 3
     * 1
     * 样例输出
     * 1
     *
     * 解题思路
     * 第一种方式只交换相邻的的两个数,每次移动一格
     * 第二种方式倒序三个数,相当与间隔的数进行交换,每次移动两格
     * 已知要求第一种方式的最少次数,即求 需要进行奇数次移动的书的数量
     * 所以直接排序后,将正确的索引记录下来,和本来的索引进行比较即可
     *
     */
    private static int minSwapOperations(int n, int[] books) {
        int[] cloneBooks = books.clone();
        Arrays.sort(cloneBooks);
        Map<Integer, Integer> positionMap = new HashMap<>();
        
        // 创建书籍编号到最终位置的映射
        for (int i = 0; i < n; i++) {
            positionMap.put(cloneBooks[i], i);
        }
        
        int oddMoves = 0;
        
        // 统计需要奇数次移动的书的数量
        for (int i = 0; i < n; i++) {
            if (Math.abs(i - positionMap.get(books[i])) % 2 == 1) {
                oddMoves++;
            }
        }
        
        // 返回最少需要的第一种操作次数
        return oddMoves / 2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] books = new int[n];
        
        for (int i = 0; i < n; i++) {
            books[i] = scanner.nextInt();
        }
        
        System.out.println(minSwapOperations(n, books));
    }
}
