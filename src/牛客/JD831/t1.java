package 牛客.JD831;

import javax.swing.text.StyledEditorKit;
import java.util.Scanner;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/10 19:36
 * @description
 */
public class t1 {
    /**
     * 问题描述
     * LYA 是一位热爱密码学的大学生。她最近在研究一种特殊的字母串加密方法。这种方法需要不断生成下一个字典序的字母串。然而，手动计算下一个字母串既耗时又容易出错
     * 。因此，LYA 希望开发一个程序来自动化这个过程。
     * 你的任务是帮助 LYA 编写一个程序，该程序能够接收一个小写字母组成的字符串，并生成按字典序排列的下一个相同长度的字符串。
     *
     * 输入格式
     * 输入包含一行，给出一个字符串S,字符串S仅由小写字母组成。
     *
     * 输出格式
     * 输出一行，包含与输入字符串长度相同的下一个字典序字母串。 如果不存在这样的字母串，则输出 -1。
     *
     * 样例输入
     * zz
     * 样例输出
     * -1
     * 样例输入
     * aa
     * 样例输出
     * ab
     */
    public static String nextString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = n - 1; i > 0; i--) {
            if (chars[i] != 'z') {
                chars[i]++;
                for (int j = i + 1; j < n; j++) {
                    chars[j] = 'a';
                }
                return new String(chars);
            }
        }
        return "-1";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        
        String result = nextString(s);
        System.out.println(result);
        
        scanner.close();
    }
    
}
