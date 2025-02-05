package doubao;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/24 09:38
 * @description
 */
public class t1 {
    /**
     * # 问题描述
     * 多米诺骨牌游戏规则非常简单，将骨牌按一定间距的尺寸排成单行，或分行排成一片。推倒第一张骨牌，其余发生连锁反应依次倒下，或形成一条长龙，或形成一幅图案。
     * 小 A 觉得多米诺骨牌超级没意思，所以他想了点小花招。
     * 小 A 将 n 个多米诺骨牌放在一条线上，每一块都垂直竖立。他同时将一些骨牌向左或向右推倒。注意：不会出现连续向左或者向右推的情况。 每过一秒，被推向左边或右边的骨牌会将左边或右边的相邻骨牌推倒。当一个骨牌，其左边倒向它的骨牌数目与其右边倒向它的骨牌数目相等时，由于力的平衡，该骨牌将依然保持竖立。
     * 给定小 A 最初推骨牌的方向，求出最后依然保持竖立的骨牌数目和位置。
     *
     * ## 输入格式
     * 输入数据第一行包括一个整数 n（1≤n≤3000），表示这一行多米诺骨牌的数目。下一行包括一个长度为 n 的字符串，字符串的第 i 个字符意义如下：
     * “L”，第 i 个字符将要被向左推。
     * “R”，第 i 个字符将要被向右推。
     * “.”，第 i 个字符不会被推。
     *
     * ## 输出格式
     * 首先输出保持竖立的骨牌数目。如果保持竖立的骨牌数目不为 0，下一行输出保持竖立的骨牌的位置，骨牌位置从 1 到 n。
     * 每两个数之间用一个空格隔开，注意最后一个数后面没有空格。
     * **输入样例**
     * 14
     * .L.R...LR..L..
     * 5
     * R....
     * 1
     * .
     * **输出样例**
     * 4
     * 3 6 13 14
     * 0
     * 1
     * 1
     */
    public static String solution(int num, String data) {
        // Please write your code here
        return "-2";
    }
    
    public static void main(String[] args) {
        //  You can add more test cases here
        System.out.println(solution(14, ".L.R...LR..L..").equals("4:3,6,13,14"));
        System.out.println(solution(5, "R....").equals("0"));
        System.out.println(solution(1, ".").equals("1:1"));
    }
}
