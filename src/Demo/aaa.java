package Demo;

import java.util.Scanner;

/**
 * 整数的原码,反码,补码的转换
 */
public class aaa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个数: ");
        long Original = scanner.nextLong();

        System.out.println("原始数字: " + Original);

        long inverseCode = Original ^ Long.MAX_VALUE;
        System.out.println("原码: " + Long.toBinaryString(Original));
        System.out.println("反码: " + Long.toBinaryString(inverseCode));

        long complementCode = inverseCode + 1;
        System.out.println("补码: " + Long.toBinaryString(complementCode));

    }
}
