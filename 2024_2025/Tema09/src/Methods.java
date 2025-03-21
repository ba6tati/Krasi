import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Methods
{


    //<editor-fold desc="ReadAndSplitFromFile">

    // METHOD : READ AND SPLIT ===========================================================
    public static Students[] ReadAndSplitFromFile(String DATA) throws IOException {

        int counter = 0; // БРОИМ РЕДОВЕТЕ ВЪВ ФАЙЛА

        //ЧЕТЕМ ОТ ФАЙЛА
        // Scanner myReader = new Scanner(new File(DATA), "UTF-8");// Read from file
        BufferedReader br = new BufferedReader(new FileReader(DATA));
        
        String line = br.readLine();

        // System.out.println("Before while");
        // ПРЕБРОЯВАМЕ ЗАПИСИТЕ (РЕДОВЕТЕ) ВЪВ ФАЙЛА
        while (line != null) { 
            counter++;
            // myReader.nextLine();
            line = br.readLine();
        }

        br.close();
        br = new BufferedReader(new FileReader(DATA));

        
        
        //myReader = new Scanner(new File(DATA), "UTF-8");

        // System.out.println("After while");

        // СЪЗДАВАМЕ МАСИВ ОТ ОБЕКТИ - КЛАСА ЗА ТЯХ Е В Students.java
        Students[] StudentGroup = new Students[counter];
        counter = 0;

        line = br.readLine();

        // FOR цикъл за попълване на масива с учениците
        while (line != null) { // myReader.hasNextLine()
            // System.out.println(myReader.hasNextLine());
            // System.out.println(counter);

            System.out.println("NOW READING FROM FILE FOR EVERY STUDENT [" + counter + "] : ");
            StudentGroup[counter] = new Students();

            // ЧЕТЕМ ЕДИН ПО ЕДИН РЕДОВЕТЕ
            String dataString = line;

            // сплитваме по "," (запетая) и ги слагаме в масив
            String[] splitedData  = dataString.split(",");

            StudentGroup[counter].setNumber(Integer.parseInt(splitedData[0]));    // get from col Number of DATA.TXT
            StudentGroup[counter].setName(splitedData[1]);      //get from col Name of DATA.TXT
            StudentGroup[counter].setFamily(splitedData[2]);    //get from col Family of DATA.TXT
            StudentGroup[counter].setAvgscore(Double.parseDouble(splitedData[3]));  //grt from col Avgscore of DATA.TXT

            counter++;
            line = br.readLine();
        }

        System.out.println("FINISHING READ FROM FILE !!!");

        return StudentGroup;
    }// end of read and split ---------------------------------------

    //</editor-fold>



    //<editor-fold desc="MakeStatistic">

    // METHOD : MAKE STATISTIC ==========================================================

    public static void MakeStatistic(Students[] StudentGroup) {

        // print group.................................................
        printGroup(StudentGroup);

        // print average score...........................................
        printAverageScore(StudentGroup);

        // MAX score ....................................................
        printMax(StudentGroup);

        // MIN score .......................................................
        printMin(StudentGroup);

    } // end of Make Statistic --------------------------------------

    public static void printGroup(Students[] StudentGroup) {
        for (Students thisStudent : StudentGroup) // FOR-EACH
        {
            System.out.print("Номер : " + thisStudent.getNumber());
            System.out.print(" Име : " + thisStudent.getName());
            System.out.print(" Фамилия : " + thisStudent.getFamily());
            System.out.println(" Ср.Успех : " + thisStudent.getAvgscore());
        }
    }

    public static void printAverageScore(Students[] StudentGroup) {
        double GroupAvgScore = 0;

        for (Students thisStudent : StudentGroup) // FOR-EACH
        {
            GroupAvgScore = GroupAvgScore + thisStudent.getAvgscore();
            GroupAvgScore = GroupAvgScore / StudentGroup.length;
            System.out.println("AVG SCORE : " + GroupAvgScore);
        }
    }

    public static void printMax(Students[] StudentGroup) {
        int index = -1; // 1 2 3
        double MaxScore = 0; // 4 5 6

        for (Students thisStudent : StudentGroup) // FOR-EACH
        {
            if (MaxScore < thisStudent.getAvgscore()) {
                System.out.println(MaxScore + "<" + thisStudent.getAvgscore());
                MaxScore = thisStudent.getAvgscore();
                index++;
            }
        } 

        System.out.println("MAX SCORE : " + MaxScore);
        System.out.print("Номер : " + StudentGroup[index].getNumber());
        System.out.print(" Име : " + StudentGroup[index].getName());
        System.out.print(" Фамилия : " + StudentGroup[index].getFamily());
        System.out.println(" Ср.Успех : " + StudentGroup[index].getAvgscore());
    }

    public static void printMin(Students[] StudentGroup) {
        int index = -1;
        double MinScore = 0;

        for (Students thisStudent : StudentGroup) // FOR-EACH
        {
            if ( MinScore < thisStudent.getAvgscore() ) {
                MinScore = thisStudent.getAvgscore();
                index++;
            }
            System.out.println("MIN SCORE : " + MinScore);
            System.out.print("Номер : " + StudentGroup[index].getNumber());
            System.out.print(" Име : " + StudentGroup[index].getName());
            System.out.print(" Фамилия : " + StudentGroup[index].getFamily());
            System.out.println(" Ср.Успех : " + StudentGroup[index].getAvgscore());

        }
    }

    //</editor-fold>

}
