package algorithm;

import java.util.Random;

/**
 * Created by zhong on 2017/11/5.
 */
public class QuickSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
//        quickSort(arr, 0, arr.length - 1);
//        quickSort2(arr, 0, arr.length - 1);
        quickSort3(arr, 0, arr.length - 1);
//        quickSort4(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int p = partition(array, start, end);
        quickSort(array, start, p - 1);
        quickSort(array, p + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int tail = start - 1;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                SortUtil.swap(array, ++tail, i);
            }
        }
        SortUtil.swap(array, tail + 1, end);
        return tail + 1;
    }

    /***********************************************/

    private void quickSort2(int[] arr, int left, int right) {
        if (left >= right) return;

        int i = left, j = right, temp = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }

            if (i < j) {
                SortUtil.swap(arr, i, j);
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort2(arr, left, i - 1);
        quickSort2(arr, i + 1, right);
    }

    /********************************/
    /**
     * 优化快速排序
     * 1.合理选择枢轴
     * 2.小数组选用插入排序
     * 3.略去不必要的交换
     */

    private static void quickSort3(int[] arr, int left, int right) {
        if (arr.length < 16) {
            InsertSort insertSort = new InsertSort();
            insertSort.sort(arr);
            return;
        }

        if (left >= right) {
            return;
        }
        int p = partition3(arr, left, right);
        quickSort3(arr, left, p -1);
        quickSort3(arr, p + 1, right);
    }

    private static int partition3(int[] arr, int left, int right) {
        chossePivoKey(arr, left, right);
        int base = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] >= base) j--;
            arr[i] = arr[j];

            while (i < j && arr[i] < base) i++;
            arr[j] = arr[i];
        }
        arr[i] = base;
        return i;
    }

    /**
     * 枢轴d的选取尽可能随机
     * @param arr
     */
    private static void chossePivoKey(int[] arr, int left, int right) {
        SortUtil.swap(arr, left, (right - left) / 2);
    }

    /********************************/
    /**
     * 三路快排
     */
    private static void quickSort4(int[] arr, int left, int right) {
        if (left >= right) return;
        int[] ret = partition4(arr, left, right);
        quickSort4(arr, left, ret[0]);
        quickSort4(arr, ret[1], right);
    }

    private static int[] partition4(int[] arr, int left, int right) {
        int base = arr[left];
        int i = left;
        int j = right;
        int cur = i;
        while (cur <= j) {
            if (arr[cur] == base) {
                cur++;
            } else if (arr[cur] < base) {
                SortUtil.swap(arr, cur++, i++);
            } else {
                SortUtil.swap(arr, cur, j--);
            }
        }
        return new int[]{i - 1, j + 1};
    }
}
