package algorithm;


/**
 * Created by zhong on 2017/10/31.
 */
public class SelectSort implements ISort {

    @Override
    public int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
//            if (minIndex != i) {
                SortUtil.swap(arr, minIndex, i);
//            }
        }

        return arr;
    }
}
