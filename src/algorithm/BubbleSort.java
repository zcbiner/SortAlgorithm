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

    /**
     * 对冒泡排序进行优化，俗称鸡尾酒排序。
     * 从低到高再从高到底进行排序
     * @param arr
     * @return
     */
    public int[] sort1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    SortUtil.swap(arr, i, i + 1);
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    SortUtil.swap(arr, i, i - 1);
                }
            }
            left++;
        }
        return arr;
    }
}
