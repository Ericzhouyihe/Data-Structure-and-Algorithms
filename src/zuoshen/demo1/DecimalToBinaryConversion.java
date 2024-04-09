package zuoshen.demo1;

/**
 * @author 周益和
 * @ClassName DecimalToBinaryConversion
 * @qq 1552951165
 */
public class DecimalToBinaryConversion {
    // 十进制转换成二进制
    public static void main(String[] args) {
        
        int num = 10;
        
        // 直接通过java封装的方法转换
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toString(num, 2));
        System.out.println(String.format("%4s", Integer.toBinaryString(num)).replace(' ', '0'));
        
        
        // 按位与的方式转换
        for (int i = 31; i > 0; i--) {
            System.out.print(num^(1<<i));
        }
        
    }
}
