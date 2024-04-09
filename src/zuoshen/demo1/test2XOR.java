package zuoshen.demo1;

import org.junit.Test;

/**
 * @author 周益和
 * @ClassName test2XOR
 * @qq 1552951165
 */
public class test2XOR {
    // 真题:第一问:在一个数组中,已知只有一种数出现了奇数次,其他所有数都出现了偶数次,怎么找到这种数
    //第二问:在一个数组中,已知两种数出现了奇数次,其他所有数都出现了偶数次,怎么找到这两种数
    // 要求时间复杂度O(n) 空间复杂度O(1)
    @Test
    public void test1(){
        // 第一问解题思路:搞个eor一直异或到数组结尾,最后的结果就是要找的数,因为偶数次的数全异或成0了
        int[] arr = new int[]{1,1,2,2,3,4,4,5,5};
        int eor = 0;
        for (int i : arr) {
            eor = eor ^ i;
        }
        System.out.println("eor = " + eor);
    }
    
    @Test
    public void test2(){
        // 第二问解题思路:搞个eor一直异或到数组结尾,最后的结果是a^b,a,b是我们要找的两个数
        // 然后根据a^b的结果转换成二进制,二进制为1的位置就是a和b在该位置分别为0,1才能异或成1
        // 接着就新int一个eor1,这个eor1这次只和在这个位置为0(或为1)的数抑或,最后得到的必然是a,b中的某一个
        // 然后用eor1得到的结果和eor异或可得到另一个的结果
        int[] arr = new int[]{1,1,2,3,4,4,5,5};
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        System.out.println("eor = " + eor);
        
        // 取出eor最右的1
        int rightOne = eor & (~eor + 1);
        // 创建行的eor
        int eor1 = 0;
        for (int i : arr) {
            if ((i & rightOne) == 1){
                eor1 ^= i;
            }
        }
        System.out.println("a = " + eor1);
        System.out.println("b = " + (eor1 ^ eor));
    }
}
