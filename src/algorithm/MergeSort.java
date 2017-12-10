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
        if (array[middle] > array[middle + 1]) { // 加入这个判断，减少不必要的merge
            merge(array, start, middle, end);
        }
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


    // 自底向上进行排序
//    @Override
//    public int[] sort(int[] arr) {
//
//        for (int size = 1; size < arr.length; size += size) {
//
//            for (int i = 0; i + size < arr.length; i += size + size) {
//                merge(arr, i, i + size - 1, Math.min(i + size + size - 1, arr.length - 1));
//            }
//        }
//
//        return arr;
//    }
}
