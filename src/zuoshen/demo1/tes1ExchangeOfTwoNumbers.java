package zuoshen.demo1;

import java.util.Arrays;

/**
 * @author 周益和
 * @ClassName tes1ExchangeOfTwoNumbers
 * @qq 1552951165
 */
public class tes1ExchangeOfTwoNumbers {
    // 两个数进行交换
    // 数组上两个数进行交换
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        
        // 方法1：使用第三个变量
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a + ", b = " + b);
        
        // 方法2：使用加减法
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + ", b = " + b);
        
        // 方法3：使用异或运算(条件是a和b的内存地址不能一样,即数组中拿同一个位置的数和自己进行交换,会把两个都换成0)
        /*
        * 异或运算:0-0:0 , 1-1:0 , 1-0:1
        * 规律:相同的数异或为0, 不同的数异或为1,0和任何数异或为任何数
        *  */
        a = a ^ b;
        b = a ^ b;//b = a ^ b ^ b = a ^ 0 = a
        a = a ^ b;//a = a ^ b ^ a = b ^ 0 = b
        System.out.println("a = " + a + ", b = " + b);
        
        // 即这种情况
        int[] arr = new int[]{1,2,3};
        arr[1] = arr[1] ^ arr[1];
        arr[1] = arr[1] ^ arr[1];
        arr[1] = arr[1] ^ arr[1];
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
