package school.Test1;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //输入顺序表的初始值
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        //输入要插入的数据
        int x = sc.nextInt();
        int i = 0;
        while (i < list.size() && list.get(i) < x) {
            i++;
        }
        list.add(i, x);

        //遍历结果
        System.out.println("插入操作后顺序表的数据元素：");
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
