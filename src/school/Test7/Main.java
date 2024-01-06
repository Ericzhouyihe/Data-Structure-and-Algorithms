package school.Test7;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 生成包含大量数据的数组
        int[] nums = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000000);
        }
        Arrays.sort(nums); // 对数组进行排序，以便使用二分查找算法

        // 在数组中查找某个元素
        int target = random.nextInt(1000000);

        // 使用二分查找算法进行查找，并记录运行时间和查找次数
        long start = System.currentTimeMillis();
        int index1 = binarySearch(nums, target);
        long end1 = System.currentTimeMillis();
        int count1 = index1 == -1 ? nums.length : index1 + 1;
        System.out.println("二分查找算法：");
        System.out.println("查找目标：" + target);
        System.out.println("运行时间：" + (end1 - start) + "ms");
        System.out.println("查找次数：" + count1);

        // 使用哈希查找算法进行查找，并记录运行时间和查找次数
        start = System.currentTimeMillis();
        int index2 = hashSearch(nums, target);
        long end2 = System.currentTimeMillis();
        int count2 = index2 == -1 ? nums.length : index2 + 1;
        System.out.println("哈希查找算法：");
        System.out.println("查找目标：" + target);
        System.out.println("运行时间：" + (end2 - start) + "ms");
        System.out.println("查找次数：" + count2);
    }

    //二分查找
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //哈希查找
    public static int hashSearch(int[] nums, int target) {
        int[] buckets = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int hash = nums[i] % nums.length;
            while (buckets[hash] != 0) {
                hash = (hash + 1) % nums.length;
            }
            buckets[hash] = nums[i];
        }
        int hash = target % nums.length;
        int count = 0;
        while (buckets[hash] != target && buckets[hash] != 0 && count < nums.length) {
            hash = (hash + 1) % nums.length;
            count++;
        }
        if (buckets[hash] == target) {
            return hash;
        } else {
            return -1;
        }
    }
}
