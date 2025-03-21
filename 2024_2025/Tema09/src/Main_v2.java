import java.io.IOException;

public class Main_v2 {


    // MAIN =============================================================================
    public static void main(String[] args) throws IOException {

        // МЕТОДИ ЗА ЧЕТЕНЕ И АНАЛИЗ НА ДАННИТЕ - НАМИРАТ СЕ В Students_Methods.java
        Methods.MakeStatistic( Methods.ReadAndSplitFromFile("data.txt") );

    }// END OF MAIN ======================================================================


}