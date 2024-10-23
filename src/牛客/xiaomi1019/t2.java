package 牛客.xiaomi1019;

import java.util.*;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/19 17:03
 * @description
 */
public class t2 {
    /**
     * 第一种:可以将数变为他的a倍
     * 第二种:数字左循环一次
     * 纸上的数字为1
     * 输入a,和目标数,至少几步
     */
    static class State {
        int number;
        int steps;
        
        State(int number, int steps) {
            this.number = number;
            this.steps = steps;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int count = 0;
        int num = 1;
        System.out.println(minSteps(a, b));
    }
    
    private static int minSteps(int a, int b) {
        Queue<State> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        // 初始状态
        queue.offer(new State(1, 0));
        visited.add(1);
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            
            // 如果到达目标数字，返回步骤数
            if (current.number == b) {
                return current.steps;
            }
            
            // 乘以 a
            int multiplied = current.number * a;
            if (multiplied <= 1000000 && !visited.contains(multiplied)) {
                queue.offer(new State(multiplied, current.steps + 1));
                visited.add(multiplied);
            }
            
            // 左循环
            String str = String.valueOf(current.number);
            if (str.length() > 1) {
                String rotated = str.substring(1) + str.charAt(0);
                int rotatedNumber = Integer.parseInt(rotated);
                if (!visited.contains(rotatedNumber)) {
                    queue.offer(new State(rotatedNumber, current.steps + 1));
                    visited.add(rotatedNumber);
                }
            }
        }
        
        return -1; // 如果无法到达目标
    }
}
