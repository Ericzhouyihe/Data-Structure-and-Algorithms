package school.Test1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] list = new int[10]; // 创建长度为10的顺序表
        Scanner input = new Scanner(System.in);

        // 使用一些值初始化顺序表
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }

        // 输出顺序表中的所有元素
        System.out.print("顺序表是：");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();

        // 查找顺序表中的最大值和最小值
        int max = list[0], min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
            if (list[i] < min) {
                min = list[i];
            }
        }
        System.out.println("最大值是 " + max);
        System.out.println("最小值是 " + min);

        // 在顺序表中查找一个值
        System.out.print("请输入要查找的数字：");
        int x = input.nextInt();
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == x) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println(x + "在顺序表中的位序是 " + index);
        } else {
            System.out.println(x + "不在顺序表中");
        }

        // 删除顺序表中的第8个元素
        for (int i = 7; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        list[list.length - 1] = 0; // 将最后一个元素设置为0
        System.out.print("删除第8个元素后，顺序表是：");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();

        // 在顺序表的第5个元素后插入一个新元素
        for (int i = list.length - 1; i > 5; i--) {
            list[i] = list[i - 1];
        }
        list[5] = 55;
        System.out.print("插入新元素后，顺序表是：");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();

        // 输出顺序表的长度
        System.out.println("顺序表的长度是 " + list.length);
    }
}
