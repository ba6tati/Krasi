import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Util {
    static Random random = new Random();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static long BubbleSortFF(int[] unsortedArray) {

        long startTime = System.nanoTime();

        int[] arr = unsortedArray.clone();
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    Swap(arr, j, j+1);
                }
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static long BubbleSortDW(int[] unsortedArray) {
        long startTime = System.nanoTime();
        int[] arr = unsortedArray.clone();
        int n = arr.length;

        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < n-1; i++) {
                if (arr[i] > arr[i+1]) {
                    Swap(arr, i, i+1);

                    swapped = true;
                }
            }
        } while (swapped);

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000;
    }

    public static long SelectionSort(int[] unsortedArray) {
        long startTime = System.nanoTime();

        int[] arr = unsortedArray.clone();
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;

                Swap(arr, minIndex, i);
            }
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000;
    }

    public static long InsertionSort(int[] array) {
        long startTime = System.nanoTime();

        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = key;
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000;
    }

    public static void Swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static int[] GenerateRandomArray() throws IOException {
        int n = Integer.parseInt(input.readLine());

        return random.ints(n, 1, 100).toArray();
    }
}
