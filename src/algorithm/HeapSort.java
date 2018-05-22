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

    /******************华丽分割线 下面另一种写法的堆排序*********************/

    private void heapify(int[] arr, int i, int size) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max = i;
        if (leftChild < size && arr[leftChild] > arr[max]) {
            max = leftChild;
        }
        if (rightChild < size && arr[rightChild] > arr[max]) {
            max = rightChild;
        }
        while (max != i) {
            SortUtil.swap(arr, i, size);
            heapify(arr, max, size);
        }
    }

    private int buildHeap(int[] arr, int n) {
        int heapSize = n;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }
        return heapSize;
    }

    public int[] heapSort(int arr[]) {
        int heapSize = buildHeap(arr, arr.length - 1);
        while (heapSize > 1) {
            SortUtil.swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
        return arr;
    }
}
