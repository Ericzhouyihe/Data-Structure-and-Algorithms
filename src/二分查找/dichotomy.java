package 二分查找;

import java.util.Arrays;

public class dichotomy {

	// arr保证有序,二分查找
	public static boolean find(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		int L = 0;
		int R = arr.length - 1;
		while (L <= R) {
			int mid = (L + R) / 2;
			if (arr[mid] == num) {
				return true;
			} else if (arr[mid] < num) {
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return false;
	}

	//for test:测试要查找的数是否在此数组中
	public static boolean test(int[] sortedArr , int num) {
		for(int cur:sortedArr) {
			if(cur == num) {
				return true;
			}
		}
		return false;
	}

	// 生成随机数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	public static void main(String[] args) {
		int testTime = 500000;//测试次数
		int maxSize = 10;//数组的最大容量
		int maxValue = 100;//数据的大小限制
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			Arrays.sort(arr);
			int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
			if (test(arr, value) != find(arr, value)) {
				System.out.println("出错了！");
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "测试失败!");
	}
}
