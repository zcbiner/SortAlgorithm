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

    /**
     * 使用二分查找法来减少比较操作的次数
     *
     * 当n较大时，二分插入排序的比较次数比直接插入排序的最差情况好得多，
     * 但比直接插入排序的最好情况要差，所当以元素初始序列已经接近升序时，
     * 直接插入排序比二分插入排序比较次数少。二分插入排序元素移动次数与直接插入排序相同，
     * 依赖于元素初始序列。
     * @param arr
     * @return
     */
    public int[] insertionSortDichotomy(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] > temp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
            }
            arr[left] = temp;
        }
        return arr;
    }
}
