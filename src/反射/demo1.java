package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/15 14:13
 * @description 反射的使用-尝试
 */
public class demo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 1.获取反射对象
        
        // 使用Class.forName("类的全路径")方法：
        Class<?> myClass1 = Class.forName("反射.MyClass1");
        
        // 使用类名的.class语法：
        // Class<?> myClass2 = MyClass1.class;
        
        // 对象的getClass()方法：
        // MyClass1 myObj = new MyClass1();
        // Class<?> myClass3 = myObj.getClass();
        
        // 2. 创建对象实例
        Constructor<?> constructor = myClass1.getConstructor(String.class, int.class);
        Object myObject = constructor.newInstance("Hello", 123);
        if (myObject instanceof MyClass1) {
            ((MyClass1) myObject).display();
        }
        
        // 访问和修改字段
        Field field = myClass1.getDeclaredField("message"); // 写字段名
        field.setAccessible(true);
        field.set(myObject, "Hello world");
        ((MyClass1) myObject).display();
        
        // 调用方法
        Method method = myClass1.getMethod("setMessage", String.class);
        Object result = method.invoke(myObject, "Hello");
        ((MyClass1) myObject).display();
        
        // 可以使用Class.getDeclaredClasses()方法来获取类中的所有属性、方法、构造器等：
        // Class<?>[] classes = MyClass1.class.getDeclaredClasses();
        // for (Class<?> aClass : classes) {
        //     System.out.println(aClass.getName());
        // }
    }
}
