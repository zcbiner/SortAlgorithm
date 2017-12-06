package algorithm;

/**
 * Created by zhong on 2017/11/5.
 */
public class QuickSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
//        quickSort(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int p = partition(array, start, end);
        quickSort(array, start, p - 1);
        quickSort(array, p + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        int sentinel = array[start];
        int j = start;
        for (int i = start + 1; i < end; i++) {
            if (array[i] < sentinel) {
                SortUtil.swap(array, ++j, i);
            }
        }
        SortUtil.swap(array, j, start);
        return j;
    }

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
}
