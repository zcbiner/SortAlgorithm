package algorithm;

import java.util.Random;

/**
 * Created by zhong on 2017/10/31.
 */
public class SortUtil {

    /**
     * 判断排序算法是否有效
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr [i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] arrayCopy(int[] arr) {
        int[] sortArray = new int[arr.length];
        System.arraycopy(arr, 0, sortArray, 0, arr.length);
        return sortArray;
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static int[] randomArray(int length, int bound) {
        int[] a = new int[length];
//        System.out.print("原始数据：");
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            a[i] = random.nextInt(bound);
//            System.out.print(" " + a[i]);
        }
//        System.out.println();
        return a;
    }

    public static void sortTest(String sortName, ISort iSort, int[] arr) {
        int[] sortArray = arrayCopy(arr);
        System.out.println("排序名称：" + sortName);
        long time = System.currentTimeMillis();
        int[] sorted = iSort.sort(sortArray);
        long consumeTime = System.currentTimeMillis() - time;
        boolean isSorted = isSorted(sorted);
//        printArray(sorted);
        System.out.println("是否成功：" + (isSorted ? "true" : "false"));
        System.out.println("消耗时间：" + consumeTime + "ms");
    }

    public static void printArray(int[] arr) {
        System.out.print("排序数据：");
        for (int i : arr) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}
