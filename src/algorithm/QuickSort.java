package algorithm;

/**
 * Created by zhong on 2017/11/5.
 */
public class QuickSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return new int[0];
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
}
