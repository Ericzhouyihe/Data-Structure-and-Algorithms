package 单例模式.懒汉;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/11 20:32
 * @description
 */

/**
 * 从结果看来，这种方式不能保证线程安全，为什么呢？我们假设有两个线程A和B同时走到了‘代码1’，
 * 因为此时对象还是空的，所以都能进到方法里面，线程A首先抢到锁，创建了对象。
 * 释放锁后线程B拿到了锁也会走到‘代码2’，也创建了一个对象，因此多线程环境下就不能保证单例了。
 * <p>
 * 让我们来继续优化一下，既然上述方式存在问题，那我们在同步代码块里面再一次做一下null判断不就行了，这种方式就是我们的DCL双重检查锁机制。
 */

// 单例模式的懒汉实现5--线程安全
// 通过设置同步代码块，使用DCL双检查锁机制
// 使用双检查锁机制成功的解决了单例模式的懒汉实现的线程不安全问题和效率问题
// DCL 也是大多数多线程结合单例模式使用的解决方案
public class SingletonLazy5 {
    /**
     * 这里注意到在定义singletonLazy的时候用到了volatile关键字，这是为了防止指令重排序的，为什么要这么做呢，我们来看一个场景：
     *
     * 代码走到了 singletonLazy = new SingletonLazy5();
     * 看起来是一句话，但这并不是一个原子操作（要么全部执行完，要么全部不执行，不能执行一半），这句话被编译成8条汇编指令，大致做了3件事情：
     *
     * 1.给SingletonLazy5的实例分配内存。
     *
     * 2.初始化SingletonLazy5的构造器
     *
     * 3.将singletonLazy对象指向分配的内存空间（注意到这步instance就非null了）。
     *
     * 由于Java编译器允许处理器乱序执行（out-of-order），以及JDK1.5之前JMM（Java Memory Medel）中Cache、寄存器到主内存回写顺序的规定，
     * 上面的第二点和第三点的顺序是无法保证的，也就是说，执行顺序可能是1-2-3也可能是1-3-2，如果是后者，并且在3执行完毕、2未执行之前，
     * 被切换到线程二上，这时候singletonLazy因为已经在线程一内执行过了第三点，singletonLazy已经是非空了，所以线程二直接拿走singletonLazy，
     * 然后使用，然后顺理成章地报错，而且这种难以跟踪难以重现的错误估计调试上一星期都未必能找得出来。
     *
     * DCL的写法来实现单例是很多技术书、教科书（包括基于JDK1.4以前版本的书籍）上推荐的写法，实际上是不完全正确的。
     * 的确在一些语言（譬如C语言）上DCL是可行的，取决于是否能保证2、3步的顺序。
     * 在JDK1.5之后，官方已经注意到这种问题，因此调整了JMM、具体化了volatile关键字，因此如果JDK是1.5或之后的版本，
     * 只需要将singletonLazy的定义加上volatile关键字，就可以保证每次都去singletonLazy都从主内存读取，
     * 并且可以禁止重排序，就可以使用DCL的写法来完成单例模式。
     * 当然volatile或多或少也会影响到性能，最重要的是我们还要考虑JDK1.42以及之前的版本，所以单例模式写法的改进还在继续。
     *
     */
    private static volatile SingletonLazy5 singletonLazy;
    
    private SingletonLazy5() {
    
    }
    
    public static SingletonLazy5 getInstance() {
        try {
            if (null == singletonLazy) {
                // 模拟在创建对象之前做一些准备工作
                Thread.sleep(1000);
                synchronized (SingletonLazy5.class) {
                    if (null == singletonLazy) {
                        singletonLazy = new SingletonLazy5();
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return singletonLazy;
    }
}
