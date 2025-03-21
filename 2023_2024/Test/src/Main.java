import java.io.IOException;
//import javafx.util.Pair;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = Util.GenerateRandomArray();

        System.out.println("Bubble sort with FF: " + Util.BubbleSortFF(arr));
        System.out.println("Bubble sort with DW: " + Util.BubbleSortDW(arr));
        System.out.println("Selection sort: " + Util.SelectionSort(arr));
        System.out.println("Insertion sort: " + Util.InsertionSort(arr));
    }
}