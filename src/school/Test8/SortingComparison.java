package school.Test8;

import java.util.Random;

public class SortingComparison {
    private static int bubbleSortComparisons = 0;
    private static int quickSortComparisons = 0;

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                bubbleSortComparisons++;
            }
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            if (nums[i] <= pivot) {
                i++;
            } else if (nums[j] > pivot) {
                j--;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
            quickSortComparisons++;
        }
        int pivotIndex = j;
        nums[left] = nums[pivotIndex];
        nums[pivotIndex] = pivot;
        return pivotIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[100000];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000000);
        }

        int[] bubbleSortNums = nums.clone();
        long bubbleSortStartTime = System.nanoTime();
        bubbleSort(bubbleSortNums);
        long bubbleSortEndTime = System.nanoTime();

        int[] quickSortNums = nums.clone();
        long quickSortStartTime = System.nanoTime();
        quickSort(quickSortNums, 0, quickSortNums.length - 1);
        long quickSortEndTime = System.nanoTime();

        System.out.println("冒泡排序:");
        System.out.println("时间: " + (bubbleSortEndTime - bubbleSortStartTime) + " ns");
        System.out.println("比较次数: " + bubbleSortComparisons);

        System.out.println("快速排序:");
        System.out.println("时间: " + (quickSortEndTime - quickSortStartTime) + " ns");
        System.out.println("比较次数: " + quickSortComparisons);
    }
}
