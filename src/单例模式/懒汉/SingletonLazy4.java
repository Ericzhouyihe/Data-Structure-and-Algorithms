package 单例模式.懒汉;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/11 20:32
 * @description
 */

/**
 * 我们来继续优化代码，我们只给创建对象的代码进行加锁，但是这样能保证线程安全么？
 */
public class SingletonLazy4 {
    private static SingletonLazy4 singletonLazy;
    
    private SingletonLazy4() {
    
    }
    
    public static SingletonLazy4 getInstance() {
        try {
            if (null == singletonLazy) {
                // 模拟在创建对象之前做一些准备工作
                Thread.sleep(1000);
                synchronized (SingletonLazy4.class) {
                    singletonLazy = new SingletonLazy4();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return singletonLazy;
    }
}
