package school.Test4;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i, d;
        int[] e = new int[1]; // 修改变量e的类型为int数组
        MyQueue myQueue = new MyQueue(); // 创建队列对象
        myQueue.InitQueue(); // 初始化队列

        Scanner in = new Scanner(System.in);
        System.out.printf("请输入队列的%d个元素：\n", MyQueue.QUEUESIZE);
        for (i = 0; i < MyQueue.QUEUESIZE; i++) { // 循环输入队列元素
            d = in.nextInt();
            myQueue.EntryQueue(d); // 入队操作
        }

        System.out.print("队列的元素为:");
        myQueue.QueueTraverse(); // 遍历队列中的元素

        System.out.printf("队列长度为：%d\n", myQueue.QueueLength()); // 获取队列长度

        int k = myQueue.QueueLength();
        System.out.printf("连续%d次由队头删除元素，队尾插入元素:\n", k / 2);
        for (i = 0; i < k / 2; i++) { // 连续删除队头元素并插入队尾元素
            if (!myQueue.DeQueue(e)) { // 如果队列为空，退出循环
                System.out.println("队空!");
                return;
            }
            System.out.printf("删除的队列的元素是：%d,请输入插入的元素：", e[0]); // 输出删除的队头元素
            d = in.nextInt();
            myQueue.EntryQueue(d); // 入队操作
        }

        System.out.println("新的队列元素为：");
        myQueue.QueueTraverse(); // 遍历队列中的元素

        int[] n = new int[1];
        if (myQueue.GetHead(n)) { // 获取对头元素值
            System.out.printf("对头元素为：%d\n", n[0]);
        } else {
            System.out.println("队空!");
            return;
        }

        myQueue.ClearQueue(); // 清空队列
        System.out.printf("清空队列后队列是否为空：%d\t(1:为空, 0:不为空)\n", myQueue.QueueEmpty() ? 1 : 0);

        myQueue.DestoryQueue(); // 销毁队列
        System.out.printf("销毁队列后:\n myQueue.base=%s \t myQueue.front=%d \t myQueue.rear=%d\t\n", myQueue.getBase() == null ? "null" : myQueue.toString(),
                myQueue.getFront(), myQueue.getRear());
    }
}