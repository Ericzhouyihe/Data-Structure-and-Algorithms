package 二分查找;

import java.util.Arrays;

//有序数组中找到满足条件<=num 的 最右的数 所在的位置
public class BSNearRight {
	//找到最右位置的二分查找
	public static int getMostLeftIndex(int[] arr , int num) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		int L = 0;
		int R = arr.length-1;
		int ans = -1;
		while(L <= R) {
			int mid = (L + R)/2;
			if(arr[mid] <= num) {
				ans = mid;
				L = mid +1;
			}else{
				R = mid - 1;
			}
		}
		return ans;
	}

	//for test:测试要查找的数所在位置
	public static int test(int[] sortedArr , int num) {
		for(int i = sortedArr.length - 1 ; i >= 0;i--) {
			if(sortedArr[i] <= num){
				return i;
			}
		}
		return -1;
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
			if (test(arr, value) != getMostLeftIndex(arr, value)) {
				System.out.println("出错了！");
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "测试失败!");
	}
}
