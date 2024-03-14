import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        int[] array = Util.Input();

        Util.Print(array, "Unsorted array");

        Util.InsertionSort(array);

        Util.Print(array, "Sorted array");
    }
}
