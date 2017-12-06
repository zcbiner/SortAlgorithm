package algorithm;

public class ShellSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
        int gap = arr.length / 2;
        while (gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap /= 2;
        }
        return new int[0];
    }
}
