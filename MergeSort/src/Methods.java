import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Arrays;

public class Methods {

    public static void Sort(int[] array, int left, int right) {

        if (left < right) {
            int middle = (left + right) / 2;

            Sort(array, left, middle);
            Sort(array, middle + 1, right);

            merge(array, left, middle, right);
        }

    }

    public static void PrintArray(int[] array, String label) {
        System.out.print(label + ": ");
        System.out.print(Arrays.toString(array));

        System.out.println();
    }

    public static int[] GenerateRandomArray(int min, int max) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // int n = Integer.parseInt(input.readLine());

        return new Random().ints(1000, min, max).toArray();
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[middle + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i ++;
            } else {
                array[k] = R[j];
                j ++;
            }
            k ++;
        }

        while (i < n1) {
            array[k] = L[i];
            k ++;
            i ++;
        }

        while (j < n2) {
            array[k] = R[j];
            j ++;
            k ++;
        }

    }

    // arr left and right border
    // while left < right
    // INT mid = arr.length / 2
    // MergesSort(arr, LEFT, MID)
    // MergeSort(arr, MID+1, RIGHT)

    // merge()
    // n1 = mid + 1 - l
    // l[n1] = copy arr left [l+i]
    // n2 = r - mid
    // R[n2] = copy arr right[mid+j]

    // if (L < R) k ++ i ++ j ++


}
