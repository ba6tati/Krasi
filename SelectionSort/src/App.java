import java.io.IOException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws IOException {
        int[] arr = Util.GenerateRandomArray();

        Util.PrintArray(arr, "Unsorted Array");

        Util.SelectionSort(arr);

        Util.PrintArray(arr, "Sorted Array");

    }
}