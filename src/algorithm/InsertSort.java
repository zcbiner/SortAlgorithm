package algorithm;

/**
 * Created by zhong on 2017/10/31.
 */
public class InsertSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--) {
                SortUtil.swap(arr, j, j - 1);
            }
        }
        return arr;
    }

    /**
     * 优化方法
     */
    public int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i];
            int j;
            for (j = i; j > 0 && (arr[j - 1] > temp); j--) {
                arr[j] = arr[j -1];
            }
            arr[j] = temp;
        }
        return arr;
    }
}
