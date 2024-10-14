package 单例模式.懒汉;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/11 20:32
 * @description
 */

/**
 * 经过测试之后可以发现前面的创建方式的hashCode不都是一样的，
 * 说明在多线程环境下，产生了多个对象，不符合单例模式的要求。
 *
 * 那么如何使线程安全呢？第二种方法，我们使用synchronized关键字对getInstance方法进行同步。
 */
public class SingletonLazy2 {
    private static SingletonLazy2 singletonLazy;
    
    private SingletonLazy2() {
    
    }
    
    public static synchronized SingletonLazy2 getInstance() {
        try {
            // 模拟在创建对象之前做一些准备工作
            Thread.sleep(1000);
            singletonLazy = new SingletonLazy2();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return singletonLazy;
    }
}
