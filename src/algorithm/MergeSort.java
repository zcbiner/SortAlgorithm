package algorithm;

/**
 * Created by zhong on 2017/11/1.
 * 归并排序
 */
public class MergeSort implements ISort {

    @Override
    public int[] sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start >= end) return;

        int middle = (start + end) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        merge(array, start, middle, end);
    }

    private void merge(int[] array, int start, int middle, int end) {
        int[] aux = new int[end - start + 1];
        System.arraycopy(array, start, aux, 0, end - start + 1);

        int left = start;
        int right = middle + 1;
        for (int k = start; k <= end; k++) {

            if (left > middle) {
                array[k] = aux[right - start];
                right++;
            } else if (right > end) {
                array[k] = aux[left - start];
                left++;
            } else if (aux[left - start] > aux[right - start]) {
                array[k] = aux[right - start];
                right++;
            } else {
                array[k] = aux[left - start];
                left++;
            }
        }
    }

}
