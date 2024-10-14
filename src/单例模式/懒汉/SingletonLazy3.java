package 单例模式.懒汉;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/11 20:32
 * @description
 */

/**
 * 可以看到，方式2达到了线程安全。但是缺点就是效率太低，是同步运行的，下个线程想要取得对象，就必须要等上一个线程释放，才可以继续执行。
 *
 * 那我们可以不对方法加锁，而是将里面的代码加锁，也可以实现线程安全。但这种方式和同步方法一样，也是同步运行的，效率也很低。
 */
public class SingletonLazy3 {
    private static SingletonLazy3 singletonLazy;
    
    private SingletonLazy3() {
    
    }
    
    public static SingletonLazy3 getInstance() {
        try {
            synchronized (SingletonLazy3.class) {
                if (null == singletonLazy) {
                    // 模拟在创建对象之前做一些准备工作
                    Thread.sleep(1000);
                    singletonLazy = new SingletonLazy3();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return singletonLazy;
    }
}
