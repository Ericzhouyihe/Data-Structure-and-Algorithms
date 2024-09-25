package 数据结构.Map.LinkedHashMap;

import java.util.LinkedHashMap;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/19 11:18
 * @description LinkedHashMap 特点:有序 , 不重复 , 无索引
 */
public class Test2LinkedHashMap {
    public static void main(String[] args) {
        // 1.创建集合对象
        LinkedHashMap<Integer,String> hm = new LinkedHashMap<>();
        
        // 2.添加数据
        hm.put(3,"c");
        hm.put(1,"a");
        hm.put(2,"b");
        hm.put(2,"bb");
        
        System.out.println(hm);
    }
}
