package school.Test4;

public class MyQueue {
    private int[] base;// 存储队列元素的数组
    private int front; // 队头指针
    private int rear;// 队尾指针
    public static final int  QUEUESIZE = 10;//队列容量大小

    public MyQueue() {
        base = new int[QUEUESIZE];// 动态分配数组空间
        front = rear = 0;// 初始化队头和队尾指针
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int[] getBase() {
        return base;
    }

    public void setBase(int[] base) {
        this.base = base;
    }

    // 初始化队列
    public void InitQueue() {
        base = new int[QUEUESIZE];
        front = rear = 0;
    }

    // 入队操作
    public boolean EntryQueue(int e) {
        if (rear - front== QUEUESIZE) { // 队列已满
            return false;
        }
        base[rear % QUEUESIZE] = e; // 将元素插入队尾
        rear++; // 队尾指针加1
        return true;
    }

    // 判断队列是否为空
    public boolean QueueEmpty() {
        if (front == rear) { // 队头指针等于队尾指针时队列为空
            return true;
        }
        return false;
    }

    // 获取队列长度
    public int QueueLength() {
        return rear - front; // 队列长度为队尾指针减去队头指针
    }

    // 获取队头元素值
    public boolean GetHead(int[] e) {
        if (front == rear) { // 队列为空
            return false;
        }
        e[0] = base[front]; // 获取队头元素值
        front++; // 队头指针加1
        return true;
    }

    // 销毁队列
    public void DestoryQueue() {
        base = null; // 释放数组空间
        front = rear = 0; // 将队头和队尾指针置为0
    }

    // 清空队列
    public void ClearQueue() {
        front = rear = 0; // 将队头和队尾指针置为0
    }

    // 出队操作
    public boolean DeQueue(int[] e) {
        if (front == rear) { // 队列为空
            return false;
        }
        e[0] = base[front]; // 获取队头元素值
        front++; // 队头指针加1
        return true;
    }

    // 遍历队列中的元素
    public void QueueTraverse() {
        if (QueueEmpty()) { // 队列为空
            System.out.println("队列为空");
            return;
        }
        int i = front ;
        while (i != rear ) { // 遍历队列中的元素
            System.out.print(base[i % QUEUESIZE] + " ");
            i++; // 下一个元素的位置
        }
        System.out.println();
    }
}