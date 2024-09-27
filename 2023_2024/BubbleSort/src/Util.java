public class Util {
    public static int[] BS_sort_FF(int[] unsortedArray) {

        int[] arr = unsortedArray.clone();
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    public static int[] BS_sort_DW(int[] unsortedArray) {
        int[] arr = unsortedArray.clone();
        int n = arr.length;

        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < n-1; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                    swapped = true;
                }
            }
        } while (swapped);

        return arr;
    }

    public static void Swap(int[] arr, int index1, int index2) {

    }
}
