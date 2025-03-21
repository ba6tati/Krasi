import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));

        String line = br.readLine();

        while(line != null) {
            System.out.println(line);

            line = br.readLine();
        }
        
    }
}
