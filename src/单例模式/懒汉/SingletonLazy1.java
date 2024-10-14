package 单例模式.懒汉;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/11 20:28
 * @description 参考: https://blog.csdn.net/u014672511/article/details/79774847
 */

/**
 * 懒汉模式就是延迟加载，也叫懒加载。在程序需要用到的时候再创建实例，这样保证了内存不会被浪费。
 * 针对懒汉模式，这里给出了5种实现方式，有些实现方式是线程不安全的，也就是说在多线程并发的环境下可能出现资源同步问题
 */
public class SingletonLazy1 {
    private static SingletonLazy1 singletonLazy;
    
    private SingletonLazy1() {
    }
    
    private static SingletonLazy1 getInstance(){
        if (null == singletonLazy) {
            try {
                // 模拟在创建对象之前做一些准备工作
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singletonLazy = new SingletonLazy1();
        }
        return singletonLazy;
    }
}
