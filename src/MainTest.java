import algorithm.*;

/**
 * Created by zhong on 2017/10/31.
 */
public class MainTest {

    public static void main(String[] args) {

        int[] rawArray = SortUtil.randomArray(10000, 1000);

        ISort bubbleSort = new BubbleSort();
        SortUtil.sortTest("冒泡排序", bubbleSort, rawArray);

        ISort selectSort = new SelectSort();
        SortUtil.sortTest("选择排序", selectSort, rawArray);

        ISort insertSort = new InsertSort();
        SortUtil.sortTest("插入排序", insertSort, rawArray);

        ISort mergeSort = new MergeSort();
        SortUtil.sortTest("归并排序", mergeSort, rawArray);

        ISort quickSort = new QuickSort();
        SortUtil.sortTest("快速排序", quickSort, rawArray);
    }

}
