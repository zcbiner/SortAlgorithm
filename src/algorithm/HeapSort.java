package algorithm;

public class HeapSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
        int len = arr.length - 1;
        for (int i = len / 2 - 1; i >= 0; i--) {
            headAdjust(arr, i, len);
        }
        while (len >= 0) {
            SortUtil.swap(arr, 0, len--);
            headAdjust(arr, 0, len);
        }
        return arr;
    }

    private void headAdjust(int[] arr, int parent, int len) {
        int leftChild, rightChild, maxChild;
        while ((leftChild = 2 * parent + 1) <= len) {
            rightChild = leftChild + 1;
            maxChild = leftChild;
            // 将j指向左右子节点中的较大者
            if (maxChild < len && (arr[leftChild] < arr[rightChild])) {
                maxChild++;
            }

            if (arr[parent] < arr[maxChild]) {
                SortUtil.swap(arr, parent, maxChild);
                parent = maxChild;
            } else {
                break;
            }
        }
    }
}
