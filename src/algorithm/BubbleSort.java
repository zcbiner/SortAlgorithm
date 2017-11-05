package algorithm;

/**
 * Created by zhong on 2017/11/1.
 */
public class BubbleSort implements ISort {

    @Override
    public int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length  - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortUtil.swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }
}
