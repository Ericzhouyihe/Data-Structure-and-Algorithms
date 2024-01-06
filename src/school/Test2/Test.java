package school.Test2;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.addFirst(50);
        myLinkedList.addFirst(30);
        myLinkedList.addFirst(10);

        myLinkedList.addLast(70);
        myLinkedList.addLast(90);
        myLinkedList.addLast(100);

        myLinkedList.insert(3,50);
        myLinkedList.insert(4,70);
        myLinkedList.insert(5,80);

        System.out.println("单链表中数据为");
        myLinkedList.display();

        System.out.println("单链表中是否有48："+myLinkedList.contains(48));
        System.out.println("单链表中是否有30："+myLinkedList.contains(30));

        myLinkedList.removeFirstKey(50);
        System.out.println("删除第一个50后，单链表数据为：");
        myLinkedList.display();
        System.out.println("单链表长度为"+myLinkedList.size());

        myLinkedList.removeAllKey(70);
        System.out.println("删除所有的70后，单链表数据为：");
        myLinkedList.display();
        System.out.println("单链表长度为"+myLinkedList.size());
    }
}
