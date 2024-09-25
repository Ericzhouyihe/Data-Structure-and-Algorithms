package 数据结构.Map.TreeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/23 11:09
 * @description
 */
public class Test1TreeMap {
    
    /*
     * 定义一个 Student 类，实现 Comparable 接口
     * 来对键进行排序
     *  */
    public static void main(String[] args) {
        // 1.创建 TreeMap 对象
        TreeMap<Test1Student, String> treeMap = new TreeMap<>(
                
                /*
                 * 比较器
                 * 优先级:
                 *   比较器(new Comparator,重写compare) > 自然排序(实现Comparable,重写compareTo方法)
                 *  */
                new Comparator<Test1Student>() {
                    @Override
                    public int compare(Test1Student o1, Test1Student o2) {
                        return -Double.compare(o1.getScore(), o2.getScore());
                    }
                }
        );
        
        // 2. 添加数据
        treeMap.put(new Test1Student("001", "张三", 99.1), "湖北");
        treeMap.put(new Test1Student("002", "李四", 88.2), "中国");
        treeMap.put(new Test1Student("003", "王五", 77.3), "中国");
        
        // 打印
        System.out.println(treeMap);
        
        // 3. 获取数据
        // System.out.println(treeMap.get(2)); // 取值
        
        // 4. 删除数据
        // treeMap.remove(2);
        
        // 5. 迭代
        for (Map.Entry<Test1Student, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
