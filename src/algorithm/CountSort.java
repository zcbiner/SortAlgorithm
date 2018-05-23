package algorithm;

/**
 * 计算排序
 */
public class CountSort {

    /**
     *   1.找出待排序的数组中最大和最小的元素
     *   2.统计数组中每个值为i的元素出现的次数，存入数组C的第i项
     *   3.对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
     *   4.反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
     */
    public static int[] sort(int[] arr, int max) {
        int[] c = new int[max];
        for (int i = 0; i < max; i++) {
            c[i] = 0;
        }

        for (int j = 0; j < arr.length; j++) {
            c[arr[j]]++;
        }

        for (int i = 1; i < max; i++) {
            c[i] += c[i - 1];
        }

        int[] result = new int[arr.length];
        for (int j = arr.length - 1; j >= 0; j--) {
            result[c[arr[j]] - 1] = arr[j];
            c[arr[j]] = c[arr[j]] -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 2, 3, 6, 8, 1, 5, 7, 4, 8};
        SortUtil.printArray(CountSort.sort(arr, 9));

    }
}
